package com.example.demo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo3.dto.MemberDTO;
import com.example.demo3.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberDTO> findMemberList() {
// TODO Auto-generated method stub
        return memberMapper.selectMemberList();
    }

    @Override
    public MemberDTO findMemberDetail(String id) {
// TODO Auto-generated method stub
        return memberMapper.selectMemberDetail(id);
    }

    @Override
    public void removeMember(String id) {
        // TODO Auto-generated method stub
        memberMapper.deleteMember(id);
    }

    @Override
    public void registerMember(MemberDTO dto) {
        memberMapper.insertMember(dto);
    }

    @Override
    public void modifyMember(MemberDTO dto) {
        memberMapper.updateMember(dto);
    }
}
