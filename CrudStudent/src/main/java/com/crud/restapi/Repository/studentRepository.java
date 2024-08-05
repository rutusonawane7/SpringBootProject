package com.crud.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.restapi.entity.Student;

public interface studentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAll();

	

}
