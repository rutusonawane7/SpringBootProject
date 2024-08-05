package com.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.MyBooList;
import com.demo.Repo.MyBookRepo;



@Service
public class MyBookService {
	
	@Autowired
	public MyBookRepo myBookRepo;
	
	
	public void saveMyBook(MyBooList book) {
		myBookRepo.save(book);
	}
	
	
	public List<MyBooList> getAllMyBooks(){
		return myBookRepo.findAll();
	}
	
	
	public void deleteById(int id) {
		myBookRepo.deleteById(id);
	}
}
