package com.example.dudu.ContactList.service;

import com.example.dudu.ContactList.dto.ContactDTO;
import com.example.dudu.ContactList.dto.CreateContactRequest;
import com.example.dudu.ContactList.dto.UpdateContactRequest;
import com.example.dudu.ContactList.entities.Contact;
import com.example.dudu.ContactList.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Contact updateContact(Long id, UpdateContactRequest request) {
        Contact contact = repository.findById(id).orElseThrow(() -> new RuntimeException(
                "Contact not found with id: " + id)
        );
        contact.setName(request.getName());
        contact.setLastName(request.getLastName());
        contact.setNumber(request.getNumber());
        return repository.save(contact);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}
