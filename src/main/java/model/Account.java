package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "Account", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Id")})


public class Account implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id", unique = true, nullable = false)
  private long id;
  
  
  @Column(name = "account_number", unique = true, nullable = false)
  private long accountNumber;
  
  @ManyToOne
  private Employee employee;
  
  
  public Account() {
	
  }
  
  public Account(long accountNumber, Employee employee) {
	this.accountNumber = accountNumber;
	this.employee = employee;
  }
  
  public long getId() {
	return id;
  }
  
  public void setId(long id) {
	this.id = id;
  }
  
  public long getAccountNumber() {
	return accountNumber;
  }
  
  public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
  }
  
  public Employee getEmployee() {
	return employee;
  }
  
  public void setEmployee(Employee employee) {
	this.employee = employee;
  }
  
  @Override
  public String toString() {
	return "Account{" +
			"id=" + id +
			", accountNumber=" + accountNumber +
			", employee=" + employee +
			'}';
  }
}
