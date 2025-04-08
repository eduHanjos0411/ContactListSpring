package com.example.dudu.ContactList.repositories;

import com.example.dudu.ContactList.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
