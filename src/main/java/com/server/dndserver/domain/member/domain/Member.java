package com.server.dndserver.domain.member.domain;

import com.server.dndserver.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Builder
    public Member(String name, String email, boolean isFirstLogin) {
        this.name = name;
        this.email = email;
    }

    public static Member createDefaultMember(String name, String email) {
        return Member.builder()
                .name(name)
                .email(email)
                .isFirstLogin(true)
                .build();
    }

}