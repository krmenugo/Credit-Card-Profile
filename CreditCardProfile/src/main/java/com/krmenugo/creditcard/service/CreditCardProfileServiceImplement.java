package com.krmenugo.creditcard.service;

import org.springframework.stereotype.Service;

import com.krmenugo.creditcard.model.CreditCardProfileModel;

@Service
public class CreditCardProfileServiceImplement implements CreditCardProfileService {

//	public CreditCardProfileModel model;
	
//	@Override
//	public CreditCardProfileModel mensaje() {
//		String mensaje;
//		mensaje = System.out.println("Hola, este mensaje viene de service implement");
//		return mensaje;
//	}
	
	public String mensaje2(CreditCardProfileModel profile) {
		profile.getAge();
		return profile.getAge() + "Hola, este mensaje viene de service implement";
	}
	

}
