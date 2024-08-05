package com.example.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Beans.InsertManishReq;
import com.example.Dao.MyDemo;

@Service
public class MySerivceImpl implements MyService {
	
	@Autowired
	MyDemo myDemo;
	
	
	@Override
	public Boolean insert(InsertManishReq insertManishReq) {
		System.out.println("inside the service leyer");
		return myDemo.insert(insertManishReq);
	}
	@Override
	public List<InsertManishReq> display(String number) {
		// TODO Auto-generated method stub
//		List<InsertManishReq> result= new ArrayList<InsertManishReq>();
//		
//		List<InsertManishReq> rows =myDemo.display(number);
		
//		if(rows!=null) {
//			InsertManishReq row = new InsertManishReq();
//			if("manish".equalsIgnoreCase(row.getName())) {
//				row.setMobileNumber("7219232301");
//			}
//			result.add(row);
//		}
		
		
		
		
		return myDemo.display(number);
	}

}
