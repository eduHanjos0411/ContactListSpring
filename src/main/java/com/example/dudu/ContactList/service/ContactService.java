package com.example.dudu.ContactList.service;

import com.example.dudu.ContactList.dto.ContactResponseDTO;
import com.example.dudu.ContactList.dto.request.ContactRequestDTO;
import com.example.dudu.ContactList.entities.Contact;
import com.example.dudu.ContactList.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    public ContactRepository repository;

    public Contact addNewContact(ContactRequestDTO request) {
        Contact ctt = new Contact();

        ctt.setName(request.getName());
        ctt.setLastName(request.getLastName());
        ctt.setNumber(request.getNumber());
        return repository.save(ctt);
    }

    public List<ContactResponseDTO> getAllcontacts() {
        List<ContactResponseDTO> contacts = repository.findAll().stream().map(ContactResponseDTO::new).toList();
        return contacts;
    }

    public Contact updateContact(Long id, ContactRequestDTO request) {
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
