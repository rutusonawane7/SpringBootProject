package com.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Book;

@Repository
public interface BookRepo extends  JpaRepository<Book, Integer>{

}
