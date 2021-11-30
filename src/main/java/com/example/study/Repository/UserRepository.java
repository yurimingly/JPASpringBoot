package com.example.study.Repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> { //T : 테이블 Long: Primary key의 타입


    ////////////////////////////////쿼리 메소드//////////////////////////
    //user는 있을수도 없을수도 있는데
    //select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account); //Optional<User> findByAccount(String ac); 라고 해도 순서대로 들어가기 때문에 ac라고 써도 된다. 하지만 유지보수측면에서 전자

    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email =?
    Optional<User> findByAccountAndEmail(String account, String email);
}
