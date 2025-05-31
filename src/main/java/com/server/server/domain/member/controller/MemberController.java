package com.server.server.domain.member.controller;

import com.server.server.domain.member.domain.Member;
import com.server.server.domain.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping
    @Operation(summary = "Get all member")
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a member By Id")
    public Member findById(@PathVariable Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Save a member")
    public Member create(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Members")
    public Member update(@PathVariable Long id, @RequestBody Member member) {
        Member existing = memberRepository.findById(id).orElse(null);
        if (existing != null) {
            existing = Member.builder()
                    .name(member.getName())
                    .email(member.getEmail())
                    .build();
            return memberRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
}
