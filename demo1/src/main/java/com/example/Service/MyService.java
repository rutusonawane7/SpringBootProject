package com.example.Service;

import java.util.List;

import com.example.Beans.InsertManishReq;

public interface MyService {

	
	public Boolean insert(InsertManishReq insertManishReq);

	public List<InsertManishReq> display(String number);

}
