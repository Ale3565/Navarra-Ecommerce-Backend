package com.alexislevano.projectspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.alexislevano.projectspring.entities.Client;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

}