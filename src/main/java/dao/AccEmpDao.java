package dao;

import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AccEmpDao {
  
  
  public void saveAccount(Account account) {
	
	Transaction transaction = null;
	
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	  
	  transaction = session.beginTransaction();
	  
	  session.save(account);
	  transaction.commit();
	  
	  
	} catch (Exception e) {
	  if (transaction != null) {
		transaction.rollback();
	  }
	  e.printStackTrace();
	  
	}
	
	
  }
  
  
}
