package com.example.dudu.ContactList.controllers;

import com.example.dudu.ContactList.dto.ContactDTO;
import com.example.dudu.ContactList.dto.CreateContactRequest;
import com.example.dudu.ContactList.entities.Contact;
import com.example.dudu.ContactList.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    public ContactService service;

    @PostMapping("/newContact")
    public ResponseEntity<Contact> addNewContact(@RequestBody CreateContactRequest ctt) {
       Contact newCtt = service.addNewContact(ctt);
        URI location = URI.create("/newContact" + newCtt.getId());
       return ResponseEntity.created(location).body(newCtt);
    }

    @GetMapping("/showAllContacts")
    public ResponseEntity<List<ContactDTO>> showAllContacts() {
        List<ContactDTO> allCtts = service.getAllcontacts();
        return ResponseEntity.ok(allCtts);
    }

    @PutMapping("/updtContact/{id}")
    public ResponseEntity<> updtContact(@PathVariable Long id, @RequestBody com.example.dudu.ContactList.entities.Contact data) {

    }
}
