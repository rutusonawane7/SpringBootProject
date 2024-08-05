package com.example.Dao;

import java.util.List;

import com.example.Beans.InsertManishReq;

public interface MyDemo {

	Boolean insert(InsertManishReq insertManishReq);

	List<InsertManishReq> display(String number);

}
