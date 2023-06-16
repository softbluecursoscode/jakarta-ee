package br.com.softblue.javaee;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@FormAuthenticationMechanismDefinition(
	loginToContinue = @LoginToContinue(
		loginPage = "/login.faces",
		errorPage = "/error.faces"
	)		
)
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class Config {

}
