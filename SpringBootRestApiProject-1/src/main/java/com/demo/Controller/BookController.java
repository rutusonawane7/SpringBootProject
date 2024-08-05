package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.demo.Entity.Book;
import com.demo.Entity.MyBooList;
import com.demo.Service.BookService;
import com.demo.Service.MyBookService;

@Controller
public class BookController {

	
	@Autowired
	BookService bookService;
	
	@Autowired
	MyBookService myBookService;
	
	@Value("${query.insert}")
	private String name;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>List=bookService.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book", List);
		
		return new ModelAndView("bookList","book",List);
		
		
	}
	
	@PostMapping("/save")
	public String inertDate(Book b) {
		bookService.save(b);
		
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBooList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "MyBooks";
	}
	
	@RequestMapping("/mylist/{id}")
		public String getMyList(@PathVariable("id")int id){
		
		Book b=bookService.getBookById(id);
		MyBooList mb = new MyBooList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBook(mb);
			return "redirect:/my_books";
		}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book",b);
		
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		bookService.deleteById(id);
		return "redirect:/available_books";
	}

	@GetMapping("/get")
	public String getter()
	{
		return name;
	}
}
	


