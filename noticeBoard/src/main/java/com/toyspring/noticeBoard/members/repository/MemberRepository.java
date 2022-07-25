package com.toyspring.noticeBoard.members.repository;

import com.toyspring.noticeBoard.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByUsername(String username);

}
