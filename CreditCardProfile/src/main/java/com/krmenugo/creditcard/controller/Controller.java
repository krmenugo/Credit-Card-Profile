package com.krmenugo.creditcard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krmenugo.creditcard.model.CreditCardProfileModel;
import com.krmenugo.creditcard.repository.CreditCardProfileRepository;
import com.krmenugo.creditcard.service.CreditCardProfileService;

@RestController
@RequestMapping("/CreditCardProfile")
public class Controller {
	
	@Autowired
	private CreditCardProfileRepository repository;
	
	@Autowired
	private CreditCardProfileService service;
	
	@RequestMapping(value = "viewCreditCardProfile/{idCreditCardProfile}")
	public ResponseEntity<CreditCardProfileModel> viewCreditCardProfile(@PathVariable ("idCreditCardProfile") Long idCreditCardProfile) {
		Optional<CreditCardProfileModel> optProfile = repository.findById(idCreditCardProfile);
		if(optProfile.isPresent()) {
			String preference = optProfile.get().getPreference();
			Double salary = optProfile.get().getSalary();
			Integer age = optProfile.get().getAge();
			
			try {
				
				if(preference.equals("Shopping")) {
					
					if (salary >= 7000 && salary <= 14999) {
						if (age >= 18 && age <= 23) {
							System.out.println("B+smart Afinity Card");
						} else if (age >= 24 && age <= 32) {
							System.out.println("B+smart Clásica Afinity Card, Office Depot, Costco, Best Buy Banamex");
						} else if (age >= 33 && age <= 75) {
							System.out.println("Clásica Afinity Card, Office Depot, Costco, Best Buy Banamex, The Home Depot");
						} 			
						
					} else if (salary >= 15000 && salary <= 34999) {
						
						if (age >= 18 && age <= 23) {
							System.out.println("B+smart Afinity Card");
						} else if (age >= 24 && age <= 32) {
							System.out.println("Oro, Afinity Card, Office Depot, Costco, Best Buy Banamex");
						} else if (age >= 33 && age <= 75) {
							System.out.println("Oro, Afinity Card, Office Depot, Costco, Best Buy Banamex, The Home Depot");
						} 				
					}else if (salary >= 35000 && salary <= 49999) {
						
						if (age >= 18 && age <= 23) {
							System.out.println("B+smart Afinity Card");
						} else if (age >= 24 && age <= 75) {
							System.out.println("Platinum, Office Depot, Costco, Best Buy Banamex, The Home Depot");
						} 				
					} else if (salary >= 50000) {
						
						if (age >= 18 && age <= 23) {
							System.out.println("B+smart Afinity Card");
						} else if (age >= 24 && age <= 75) {
							System.out.println("Platinum");
						} 				
					} else {
						System.out.println("El salario no permite generar el perfil de tarjeta de crédito para Shopping");
					}
					
				} else {
					System.out.println("Deberás ingresar valores válidos");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
						
			return ResponseEntity.ok(optProfile.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
//	@RequestMapping(value = "mensaje/{idCreditCardProfile}")
//	public String mostrarMensaje(@PathVariable ("idCreditCardProfile") Long idCreditCardProfile) {
//		CreditCardProfileModel profile = new CreditCardProfileModel();
//		return service.mensaje2(profile);
//	}
	
	@GetMapping
	public ResponseEntity<List<CreditCardProfileModel>> getProfile() {
		List<CreditCardProfileModel> profiles = repository.findAll();
		return ResponseEntity.ok(profiles);
	}
	
	@RequestMapping(value = "{idCreditCardProfile}")
	public ResponseEntity<CreditCardProfileModel> getProfileById(@PathVariable ("idCreditCardProfile") Long idCreditCardProfile) {
		Optional<CreditCardProfileModel> optProfile = repository.findById(idCreditCardProfile);
		if(optProfile.isPresent()) {
			return ResponseEntity.ok(optProfile.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<CreditCardProfileModel> createProfile(@RequestBody CreditCardProfileModel profile){
			CreditCardProfileModel newProfile = repository.save(profile);
			return ResponseEntity.ok(newProfile);
	}

}
