package com.example.testapp.controller;


import com.example.testapp.model.Collaborateur;
import com.example.testapp.service.CollaborateurService;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/orgs")
public class collaborateurController {


        @Autowired
        CollaborateurService collaborateurService;

        @PostMapping("/create")

        public String ajoutCollaborateur(@RequestBody OrganizationRepresentation organizationRepresentation){
            Collaborateur collaborateur = new Collaborateur();

            collaborateur.setName((organizationRepresentation.getName()));
            return collaborateurService.ajoutCollaborateur(collaborateur);
        }

        /*@GetMapping("/user/collaborateur")
        @RolesAllowed({ "collaborateur", "admin" })
        public ResponseEntity<List<Collaborateur>> getEmployee() {
            return ResponseEntity.ok(collaborateurRepository.findAll());
        }*/
    }


