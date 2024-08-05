package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Service.MyBookService;

@Controller
public class MyBookListController {
	
	@Autowired
	MyBookService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
		service.deleteById(id);
		
		return"redirect:/my_books";
		
	}

}
