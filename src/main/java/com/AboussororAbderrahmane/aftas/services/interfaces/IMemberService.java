package com.AboussororAbderrahmane.aftas.services.interfaces;

import com.AboussororAbderrahmane.aftas.dtos.member.MemberDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.IData;

import java.util.List;

public interface IMemberService extends IData<MemberDTO, RequestMemberDTO, Integer> {
    List<MemberDTO> find(String s) throws NotFoundException;
}
