package com.example.person.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
@Data
public class Person {
  @Id
  private String id;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @Min(value = 0)
  @Max(value = 120)
  private int age;
  @NotNull
  private Gender gender;

  public enum Gender {
    MALE,
    FEMALE
  }

  public Person takeFrom(Person other) {
    id = other.id;
    firstName = other.firstName;
    lastName = other.lastName;
    age = other.age;
    gender = other.gender;
    return this;
  }
}
