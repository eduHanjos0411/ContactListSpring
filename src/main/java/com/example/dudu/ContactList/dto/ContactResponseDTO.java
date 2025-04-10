package com.example.dudu.ContactList.dto;

import com.example.dudu.ContactList.entities.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDTO {

    private String name;
    private String lastName;
    private String number;

    public ContactResponseDTO(Contact contact) {
    }
}
