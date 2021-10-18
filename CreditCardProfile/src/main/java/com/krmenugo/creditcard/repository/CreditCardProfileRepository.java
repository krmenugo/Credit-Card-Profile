package com.krmenugo.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krmenugo.creditcard.model.CreditCardProfileModel;

@Repository
public interface CreditCardProfileRepository extends JpaRepository<CreditCardProfileModel, Long> {

	//
	
}
