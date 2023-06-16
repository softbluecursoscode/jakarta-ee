package br.com.softblue.javaee;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

@BasicAuthenticationMechanismDefinition
@DeclareRoles({ "admin", "guest" })
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class Config {

}
