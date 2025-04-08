package com.example.dudu.ContactList.dto;

import lombok.Data;

@Data
public class CreateContactRequest {

    private String name;
    private String lastName;
    private String number;
}
