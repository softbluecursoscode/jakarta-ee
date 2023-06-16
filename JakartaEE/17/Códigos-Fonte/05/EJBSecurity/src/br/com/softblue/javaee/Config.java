package br.com.softblue.javaee;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

@BasicAuthenticationMechanismDefinition
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class Config {

}
