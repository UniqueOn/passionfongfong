package com.study.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * userId로 UserTable 검색
	 */
	User findByUserId(String userId);
}
