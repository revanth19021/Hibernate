package cse5;

import jakarta.persistence.*;

// create table banking(bankname varchar(20), accountno int primary key, accountname varchar(20),phonenumber varchar(20) unique);
@Entity
@Table(name="banking")
public class Bank {
	@Column(name="nameofthebank")
	private String bankname;
	@Id 
	private int accountno;
	@Column(name="AccountHolderName")
	private String accountname;
	@Column(name="mobileno",unique=true)
	private String phonenumber;
	
	
	Bank(String a,int b, String c,String d){
		this.bankname=a;
		this.accountno=b;
		this.accountname=c;
		this.phonenumber=d;
	}
	Bank(){
		
	}
	
	public void setbankname(String a) {
		this.bankname=a;
	}
	public void setaccountno(int a) {
		this.accountno=a;
	}
	public void setaccountname(String a) {
		this.accountname=a;
	}
	public void setmobilenumber(String a) {
		this.phonenumber=a;
	}
	public String getbankname() {
		return bankname;
	}
	
	public int getaccountno() {
		return accountno;
	}
	public String getaccountname() {
		return accountname;
	}
	public String getmobilenumber() {
		return phonenumber;
	}

}
