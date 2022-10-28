package com.codestates.member.entity;

import com.codestates.audit.Auditable;
import com.codestates.order.entity.Order;
import com.codestates.stamp.Stamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table
public class Member extends Auditable {
    @Id
    private Long memberId;

    private String email;

    private String name;

    private String phone;

    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime modifiedAt;

    public Member(String email) {
        this.email = email;
    }

    public Member(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
