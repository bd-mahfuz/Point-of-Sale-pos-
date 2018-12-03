package com.pos.controller;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.dto.Test;

@RestController
@Transactional
public class TestController {

//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	
//	
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//	    return new HibernateJpaSessionFactoryBean();
//	}
	
	@RequestMapping("/user/createTable")
	public void createTable() {
		Test t = new Test();
		t.setId(2);
		t.setName("Hamid");
		sessionFactory.getCurrentSession().save(t);
	}
}
