package com.example.demo3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo3.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectMemberList();
    MemberDTO selectMemberDetail(@Param("paramId") String id);

    void deleteMember(@Param("paramId") String id);

    void insertMember(MemberDTO dto);

    void updateMember(MemberDTO dto);
}
