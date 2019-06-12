package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "Employee", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Id"),
		@UniqueConstraint(columnNames = "email")})
public class Employee implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id", unique = true, nullable = false)
  private long id;
  
  
  @Column(name = "email", unique = true, nullable = false, length = 100)
  private String email;
  
  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;
  
  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;
  
 @OneToMany(cascade = CascadeType.ALL)
 @JoinColumn(name = "EMPLOYEE_ID")
  private Set<Account> account;
  
  public Employee() {
	
  }
  
  public Employee(String email, String firstName, String lastName, Set<Account> account) {
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.account = account;
  }
  
  public Employee(@Email String email, String firstName, String lastName) {
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
  }
  
  public long getId() {
	return id;
  }
  
  public void setId(long id) {
	this.id = id;
  }
  
  public String getEmail() {
	return email;
  }
  
  public void setEmail(String email) {
	this.email = email;
  }
  
  public String getFirstName() {
	return firstName;
  }
  
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  
  public String getLastName() {
	return lastName;
  }
  
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  
  public Set<Account> getAccount() {
	return account;
  }
  
  public void setAccount(Set<Account> account) {
	this.account = account;
  }
  
  @Override
  public String toString() {
	return "Employee{" +
			"id=" + id +
			", email='" + email + '\'' +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", account=" + account +
			'}';
  }
}
