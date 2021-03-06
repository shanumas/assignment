package com.uma.assignment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.support.DefaultCrudMethods;
import org.springframework.stereotype.Repository;

import com.uma.assignment.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
