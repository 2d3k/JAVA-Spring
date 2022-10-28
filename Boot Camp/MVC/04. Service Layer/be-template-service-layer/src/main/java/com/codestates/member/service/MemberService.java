package com.codestates.member.service;

import com.codestates.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        Member createMember = member;
        return createMember;
    }

    public Member updateMember(Member member) {
        Member updateMember = member;
        return updateMember;
    }

    public Member findMember(long memberId) {
        Member member =
                new Member(memberId, "ksa@gmail.com", "김설아", "010-1994-1224");
        return member;
    }

    public List<Member> findMembers() {
        List<Member> members = List.of(
                new Member(1, "ksa@gmail.com", "김설아", "010-1994-1224"),
                new Member(2, "kbn@gmail.com", "김보나", "010-1995-0819")
        );
        return members;
    }

    public void deleteMember(long memberId) {

    }
}