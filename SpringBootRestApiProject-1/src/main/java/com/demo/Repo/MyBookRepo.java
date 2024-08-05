package com.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.MyBooList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBooList, Integer>{

}
