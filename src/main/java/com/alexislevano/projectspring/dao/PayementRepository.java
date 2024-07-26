package com.alexislevano.projectspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.alexislevano.projectspring.entities.Payment;

@CrossOrigin("*")
@RepositoryRestResource
public interface PayementRepository extends JpaRepository<Payment, Long> {

}
