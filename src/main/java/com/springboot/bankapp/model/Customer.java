package com.springboot.bankapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(length = 512)
	private String address;
	
	private String city;
	
	@Column(nullable = false, unique = true)
	private String pan;
	

	@OneToOne(cascade = CascadeType.ALL)
	private UserInfo userInfo; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account; 

	
	public Long getId() {
		return id;
	}

	public void setId(Long id)  throws Exception  {
		if(this.id==0) { 
		this.id = id;
		}else {
			throw new Exception("can't change id once set");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name)  throws Exception  {
		if (this.name.equals(null)) {
		this.name = name;
		}else {
			throw new Exception("can't change name once set");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) throws Exception {
		if (this.pan.equals(null)) {
		this.pan = pan;
		} else {
			throw new Exception("can't change pan once set");
		}
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", pan=" + pan
				+ ", userInfo=" + userInfo + ", account=" + account + "]";
	}

	
}
