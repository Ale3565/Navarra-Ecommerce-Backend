package com.alexislevano.projectspring.dao;

import com.alexislevano.projectspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

}
