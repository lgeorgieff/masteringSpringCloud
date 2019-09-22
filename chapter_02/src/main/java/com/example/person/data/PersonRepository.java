package com.example.person.data;

import com.example.person.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, String> {
  Flux<Person> findByLastName(String lastName);
  Flux<Person> findByAgeGreaterThan(int age);
}
