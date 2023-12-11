package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.member.MemberDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import com.AboussororAbderrahmane.aftas.entities.Member;
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
        List<Member> memberList = memberRepository.findAllByNameOrFamilyName(s);
        if (memberList.isEmpty())
            throw new NotFoundException("No members found by that name / family name");
        return List.of(modelMapper.map(memberList, MemberDTO[].class));
    }

    @Override
    public MemberDTO save(RequestMemberDTO bean) throws InvalidDataException {
        return null;
    }

    @Override
    public MemberDTO update(Integer integer, RequestMemberDTO bean) throws NotFoundException, InvalidDataException {
        return null;
    }

    @Override
    public boolean delete(Integer integer) throws NotFoundException {
        return false;
    }
}
