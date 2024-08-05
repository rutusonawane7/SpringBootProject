package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Book;
import com.demo.Repo.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	
	public void save(Book b) {
	 bookRepo.save(b);
	
	}
	
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}
	
}
