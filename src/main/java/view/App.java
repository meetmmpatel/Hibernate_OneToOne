package view;

import dao.AccEmpDao;
import model.Account;
import model.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class App {
  
  public static void main(String[] args) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
	
	Account accountOne = new Account();
	accountOne.setAccountNumber(1234);
	
	
	Set<Account> accountSet = new HashSet<>();
	accountSet.add(accountOne);
	
	Employee employeeOne = new Employee();
	employeeOne.setFirstName("Josh");
	employeeOne.setLastName("Smith");
	employeeOne.setEmail("test@gmail.com");
	employeeOne.setAccount(accountSet);
	
	
	Account accountTwo = new Account();
	accountTwo.setAccountNumber(5637);
	
	
	Set<Account> accountTwoSet = new HashSet<>();
	accountSet.add(accountTwo);
	
	Employee employeeTwo = new Employee();
	employeeTwo.setFirstName("Jems");
	employeeTwo.setLastName("Miller");
	employeeTwo.setEmail("testOne@gmail.com");
	employeeTwo.setAccount(accountTwoSet);
	
	session.save(employeeOne);
	session.save(employeeTwo);
	
	session.getTransaction().commit();
	HibernateUtil.shutDown();
	
	
  }
}
