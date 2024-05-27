package com.example.likelion.login;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface LoginMapper {
    @Insert("INSERT INTO member(memberId, memberPassword,name, phone, address) " +
            "VALUES(#{memberId}, #{memberPassword},#{name}, #{phone}, #{address})")
    void saveMemberInfo(MemberInfo memberInfo);

    @Select("SELECT memberPassword FROM member WHERE memberId = #{memberId}")
    String findByPassword(String memberId);
}
