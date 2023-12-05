package com.gb.spring.lessons.GB_Spring;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import com.gb.spring.lessons.GB_Spring.repository.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GbSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(GbSpringApplication.class, args);

//		Product product = new Product("BrioBurst", 12);
//
//		ProductDao productDao = new ProductDao();
//		productDao.findById(1l);
////		productDao.deleteById(3l);
//		productDao.findAll();
//		productDao.saveOrUpdate(product);
	}
}
