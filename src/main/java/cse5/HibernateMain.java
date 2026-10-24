package cse5;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.*;

import java.util.List;
import java.util.Scanner;

public class HibernateMain {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure("hibernate-cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory(); // session creation
		Session session=factory.openSession(); // session initilization // starting
		// crud operations
		Transaction tx=session.beginTransaction();
		try {	
		Bank b=new Bank("Axis",829292,"NagaSai","8282828");
		session.persist(b); // create 
		List<Bank> list=session.createQuery("From Bank",Bank.class).getResultList(); // read
		for(Bank i: list) {
			System.out.println(i.getbankname());
			System.out.println(i.getaccountname());
			System.out.println(i.getaccountno());
		}
		tx.commit();
		System.out.println("Values are Inserted Successfully");
		}
		catch(Exception e) {
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
//		session.createNativeQuery("insert into banking values(:no,:name,:bankname,:mobileno)")
//		.setParameter("no", 123).setParameter("name", "hai").setParameter("bankname","SBI").setParameter("mobileno", "71617171").executeUpdate();
		
//		session.createQuery("insert into Bank(accountno,accountname,bankname,phonenumber) values(:no,:name,:bankname,:mobileno)").setParameter("no", 1234)
//		.setParameter("name","SaiRevanth")
//		.setParameter("bankname", "HDFC")
//		.setParameter("mobileno", 1234567).executeUpdate();
	
		
		
		

	}

}
