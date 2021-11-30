package com.example.study.Repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> { //T : 테이블 Long: Primary key의 타입
}
