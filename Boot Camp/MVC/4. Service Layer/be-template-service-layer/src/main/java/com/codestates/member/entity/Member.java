package com.codestates.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //각 멤버 변수에 해당하는 getter/setter 메서드를 일일이 작성하는 수고를 덜어줌
@Setter
@NoArgsConstructor  //현재 Member 클래스에 추가된 모든 멤버 변수를 파라미터로 갖는 Member 생성자를 자동으로 생성
@AllArgsConstructor //파라미터가 없는 기본 생성자를 자동으로 생성
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
