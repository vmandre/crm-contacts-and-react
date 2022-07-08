package com.crm.crm.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactsController {
   
   private ContactRepository contactRepository;
   
   
   public ContactsController(ContactRepository contactRepository) {
      this.contactRepository = contactRepository;
   }
   
   @GetMapping("/contacts")
   List<Contact> contacts() {
      return StreamSupport.stream(contactRepository.findAll().spliterator(), false)
         .collect(Collectors.toList());
   }
   
   @PostMapping("/contacts")
   ResponseEntity<Contact> createContact(@Validated @RequestBody Contact contact) {
      Contact result = contactRepository.save(contact);
      
      return ResponseEntity.ok(result);
   }
   
   
   
   
   
   

}
