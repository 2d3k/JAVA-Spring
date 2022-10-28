package com.codestates.stamp;

import com.codestates.audit.Auditable;
import com.codestates.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table
public class Stamp extends Auditable {
    @Id
    private Long memberId;

    private String email;

    private String name;

    private String phone;

    private Member.MemberStatus memberStatus = Member.MemberStatus.MEMBER_ACTIVE;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime modifiedAt;

    public Stamp(long memberId) {
        this.memberId = memberId;
    }
}
