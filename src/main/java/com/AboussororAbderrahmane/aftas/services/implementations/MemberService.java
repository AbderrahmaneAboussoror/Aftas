package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.member.MemberDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import com.AboussororAbderrahmane.aftas.entities.Member;
import com.AboussororAbderrahmane.aftas.enums.IdentityDocumentType;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.MemberRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.IMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService implements IMemberService {
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Override
    public List<MemberDTO> findAll() {
        log.info("Retrieving all members");
        return List.of(modelMapper.map(memberRepository.findAll(), MemberDTO[].class));
    }

    @Override
    public MemberDTO findById(Integer integer) throws NotFoundException {
        log.info("Retrieving a member by number");
        Member member = memberRepository.findMemberByNum(integer)
                .orElseThrow(() -> new NotFoundException("Member not found"));
        return modelMapper.map(member, MemberDTO.class);
    }

    @Override
    public List<MemberDTO> find(String s) throws NotFoundException {
        log.info("Retrieving member(s) by name or family name");
        List<Member> memberList = memberRepository.findAllByName(s);
        if (memberList.isEmpty()) {
            memberList = memberRepository.findAllByFamilyName(s);
            if (memberList.isEmpty())
                throw new NotFoundException("no members found with that value");
        }
        return List.of(modelMapper.map(memberList, MemberDTO[].class));
    }

    @Override
    public MemberDTO save(RequestMemberDTO bean) throws InvalidDataException {
        Member member = modelMapper.map(bean, Member.class);
        member.setIdentityDocument(IdentityDocumentType.valueOf(
                bean.getIdentityDocument().name()
        ));
        log.info("Saving new member {}", member.getName());
        return modelMapper.map(memberRepository.save(member), MemberDTO.class);
    }

    @Override
    public MemberDTO update(Integer integer, RequestMemberDTO bean) throws NotFoundException, InvalidDataException {
        log.info("Checking if the member exists");
        Member member = memberRepository.findMemberByNum(integer)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        member.setName(bean.getName());
        member.setFamilyName(bean.getFamilyName());
        member.setNationality(bean.getNationality());
        member.setIdentityNumber(bean.getIdentityNumber());
        member.setAccessionDate(bean.getAccessionDate());
        member.setIdentityDocument(IdentityDocumentType.valueOf(
                bean.getIdentityDocument().name()
        ));

        log.info("Updating member {}", member.getName());
        return modelMapper.map(memberRepository.save(member), MemberDTO.class);
    }

    @Override
    public boolean delete(Integer integer) throws NotFoundException {
        log.info("Checking if the member exists");
        Member member = memberRepository.findMemberByNum(integer)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        log.info("Deleting member {}", member.getName());
        memberRepository.delete(member);
        return true;
    }
}
