package com.example.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Beans.InsertManishReq;
import com.example.Service.MyService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyController {
	
	// use to loss coupling 
	@Autowired
	private MyService myService;

	
	//@PostMapping(value="/insert")
	@PostMapping("/insert")
	public Boolean insert(@RequestBody InsertManishReq insertManishReq){
		System.out.println("inside the insert methode");
	return	myService.insert(insertManishReq);

	}
	
	
	@GetMapping("/display")
	public List<InsertManishReq> display(@RequestParam String number) {
		
		
		return myService.display(number);
	
		
	}
	
}
