package com.cos.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security1.model.User;

//CRUD 함수를 JPARepository가 들고 있음.
//@Repository 라는 어노테이션이 없어도 IoC가 됨. 이유는 JPARepository를 상속했기 때문에
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
