package com.example.testapp.service;


import com.example.testapp.model.Collaborateur;
import com.example.testapp.configuration.SecurityConfig;
import io.phasetwo.client.PhaseTwo;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurService {
    @Autowired
    SecurityConfig securityConfig;
    public String ajoutCollaborateur(Collaborateur collaborateur){
        Keycloak keycloak = securityConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak,securityConfig.SERVER_URL);
        OrganizationRepresentation organizationRepresentation = new OrganizationRepresentation();
        organizationRepresentation.name(collaborateur.getName());
      //  List<OrganizationRepresentation> organizationRepresentations = phaseTwo.organizations(securityConfig.REALM).get();
      return   phaseTwo.organizations(securityConfig.REALM).create(organizationRepresentation);

    }
}
