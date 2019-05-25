package com.example.gitsoft.personAPP.repository;

import com.example.gitsoft.personAPP.controller.dominio.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {
}
