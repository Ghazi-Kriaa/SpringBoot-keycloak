package com.example.testapp.configuration;
import lombok.Data;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data

public class SecurityConfig {
    static Keycloak keycloak = null;


    @Value("${keycloak.auth-server-url}")
    public  String SERVER_URL;

    @Value("${keycloak.realm}")
    public  String REALM;

    @Value("${keycloak.ressource}")
    public  String CLIENT_ID;

    @Value("${keycloak.username}")
    public  String USERNAME;
    @Value("${keycloak.password}")
    public  String PASSWORD;

    public  Keycloak getInstance() {

        return KeycloakBuilder.builder()
            .serverUrl(SERVER_URL)
            .realm(REALM)
            .username(USERNAME)
            .password(PASSWORD)
            .grantType(OAuth2Constants.PASSWORD)
            .clientId(CLIENT_ID)
            .build();
    }

}


     /*   // Initialize PhaseTwo client
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, serverUrl);
        UserRepresentation userRepresentation = new UserRepresentation();
        OrganizationRepresentation organization = new OrganizationRepresentation();
        organization.setName("My Organization");
        organization.getId();




        String organizationId = phaseTwo.organizations(realm).create(organization);

        organization.setName("Updated Organization Name");
        phaseTwo.organizations(realm).organization(organizationId).update(organization);

        List<OrganizationRepresentation> organizations = phaseTwo.organizations(realm).get();
        for (OrganizationRepresentation org : organizations) {
            System.out.println("Organization Name: " + org.getName());
        }

        // Delete organization
        phaseTwo.organizations(realm).organization(organizationId).delete();
    }
*/
