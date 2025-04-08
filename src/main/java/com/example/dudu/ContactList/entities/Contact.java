package com.example.dudu.ContactList.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "contact")
@Table(name= "contacts")
@Data
public class Contact {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String number;
}
