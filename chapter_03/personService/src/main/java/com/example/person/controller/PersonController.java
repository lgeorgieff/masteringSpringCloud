package com.example.person.controller;

import com.example.person.data.PersonRepository;
import com.example.person.model.Person;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonRepository mPersonRepository;

  @GetMapping
  public Flux<Person> findAll() {
    return mPersonRepository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Person>> findById(@PathVariable String id) {
    return mPersonRepository.findById(id)
        .map(person -> ResponseEntity.ok().body(person))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping("/lastname/{lastname}")
  public Flux<Person> findByLastName(@PathVariable String lastname) {
    return mPersonRepository.findByLastName(lastname);
  }

  @GetMapping("/age/{age}")
  public Flux<Person> findByAge(@PathVariable int age) {
    return mPersonRepository.findByAgeGreaterThan(age);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Person> add(@Valid @RequestBody Person person) {
    return mPersonRepository.save(person);
  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<Person>> update(@PathVariable String id, @Valid @RequestBody Person person) {
    person.setId(id);
    return mPersonRepository.existsById(id)
        .flatMap(exists -> exists ? mPersonRepository.save(person) : Mono.empty())
        .map(updatedPerson -> ResponseEntity.ok().body(updatedPerson))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable String id) {
    return mPersonRepository.deleteById(id);
  }
}
