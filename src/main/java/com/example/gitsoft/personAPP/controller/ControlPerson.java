package com.example.gitsoft.personAPP.controller;

import com.example.gitsoft.personAPP.controller.dominio.Person;
import com.example.gitsoft.personAPP.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class ControlPerson {

    @Autowired
    private IPersonRepository  iPersonRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll() {
        return iPersonRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Person> findPerson(@PathVariable Long code){
        Optional<Person> person =  iPersonRepository.findById(code);
        return  person;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    
    public Person save(@Valid @RequestBody Person person){
        iPersonRepository.save(person);
        return person;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/save/{code}", method = RequestMethod.PUT)
    
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person personActualizada){
        iPersonRepository.save(personActualizada);
        return new ResponseEntity<>(personActualizada, HttpStatus.OK) ;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete/{code}", method = RequestMethod.DELETE)
    
    public ResponseEntity<Person> deletePerson(@PathVariable int id){
    	//Buscar objeto en base al Id
    	iPersonRepository.delete(personBorrada);
    	
    	return new ResponseEntity<>(personBorrada, HttpStatus.OK) ;
    }
    
    
    

}
