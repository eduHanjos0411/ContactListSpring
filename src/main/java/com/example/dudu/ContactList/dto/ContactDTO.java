package com.example.dudu.ContactList.dto;

public record ContactDTO(String name, String lastName, String number) {

    public ContactDTO(com.example.dudu.ContactList.entities.Contact data) {
        this(data.getName(), data.getLastName(), data.getNumber());
    }
}
