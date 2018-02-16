package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{



    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data ...");
        roleRepository.save(new Role("EMPLOYER"));
        roleRepository.save(new Role("APPLICANT"));

       ;
    }

}
