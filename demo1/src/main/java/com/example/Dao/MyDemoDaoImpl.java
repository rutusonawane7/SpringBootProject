package com.example.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Beans.InsertManishReq;

@Repository
public class MyDemoDaoImpl implements MyDemo {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplete;

	@Override
	public Boolean insert(InsertManishReq insertManishReq) {
		String queryForInertData  ="insert into public.manish_inf_ref (name,mobile_number,address) values(:name,:mobileNumber,:address)";
		return namedParameterJdbcTemplete.update(queryForInertData, new  BeanPropertySqlParameterSource(insertManishReq))>0;
	}

	@Override
	public List<InsertManishReq> display(String number) {
		// TODO Auto-generated method stub
		String queryforfetchData = "select name, mobile_number,address from public.manish_inf_ref where mobile_number = :number";
		MapSqlParameterSource msqlp = new MapSqlParameterSource();
		msqlp.addValue("number", number);
		return namedParameterJdbcTemplete.query(queryforfetchData, msqlp,new BeanPropertyRowMapper<InsertManishReq>(InsertManishReq.class));
	}

}
