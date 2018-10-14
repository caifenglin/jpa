package cn.springbook.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.springbook.jpa.entity.Person;

public class TestPerson {
	
	
	@Test
	public void test() {
		// 1.获取EntityManagerFactory
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// 2.获取EntityManager对象
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		// 3.开启事物
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// 4.持久化
		Person person = new Person();
		person.setName("张三");
		person.setDate(new Date());
		person.setBirthday(new Date());
		entityManager.persist(person);
		// 5.提交事物
		transaction.commit();
		// 6.关闭资源
		entityManager.clear();
		createEntityManagerFactory.close();
	}
}
