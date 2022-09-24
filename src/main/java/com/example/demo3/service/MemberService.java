package com.example.demo3.service;

import java.util.List;
import com.example.demo3.dto.MemberDTO;

public interface MemberService {
    List<MemberDTO> findMemberList();
    MemberDTO findMemberDetail(String id);
    void removeMember(String id);

    void registerMember(MemberDTO dto);

    void modifyMember(MemberDTO dto);

    void login(String id, String pw);
}
