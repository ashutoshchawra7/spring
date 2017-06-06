package com.opus.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private String name;
	private Long Id;
	private String Address;
	private String city;
	private Long pincode;

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return Id;
	}
	@XmlElement
	public void setId(Long id) {
		Id = id;
	}

	public String getAddress() {
		return Address;
	}
	@XmlElement
	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}
	@XmlElement
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

}
