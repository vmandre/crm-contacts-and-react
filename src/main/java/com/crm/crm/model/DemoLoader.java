package com.crm.crm.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

     private final ContactRepository repository;
    
     public DemoLoader(ContactRepository repository) {
         this.repository = repository;
     }

    @Override
    public void run(String... args) throws Exception {
         this.repository.save(new Contact("Vanderlei", "Andre", "vanderlei@gmail.com"));
    }
    
}
