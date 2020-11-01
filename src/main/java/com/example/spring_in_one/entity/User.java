package com.example.spring_in_one.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity{
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "age")
    private int age;
}
