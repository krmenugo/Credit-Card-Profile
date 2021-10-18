package com.krmenugo.creditcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profiles")
public class CreditCardProfileModel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCreditCardProfile;
	
	@Column(name="preference", nullable = false)
	private String preference;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="age")
	private Integer Age;

	public Long getIdCreditCardProfile() {
		return idCreditCardProfile;
	}

	public void setIdCreditCardProfile(Long idCreditCardProfile) {
		this.idCreditCardProfile = idCreditCardProfile;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}
	
}
