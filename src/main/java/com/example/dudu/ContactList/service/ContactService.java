package com.example.dudu.ContactList.service;

import com.example.dudu.ContactList.dto.ContactDTO;
import com.example.dudu.ContactList.dto.CreateContactRequest;
import com.example.dudu.ContactList.entities.Contact;
import com.example.dudu.ContactList.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContactService {

    @Autowired
    public ContactRepository repository;

    public Contact addNewContact(CreateContactRequest request) {
        Contact ctt = new Contact();

        ctt.setName(request.getName());
        ctt.setLastName(request.getLastName());
        ctt.setNumber(request.getNumber());
        return repository.save(ctt);
    }

    public List<ContactDTO> getAllcontacts() {
        List<ContactDTO> contacts = repository.findAll().stream().map(ContactDTO::new).toList();
        return contacts;
    }




}
