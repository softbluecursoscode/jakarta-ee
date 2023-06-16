package br.com.softblue.javaee.security;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class FileIdentityStore implements IdentityStore {
	
	private Properties props;
	
	@PostConstruct
	public void setup() {
		props = new Properties();
		try {
			props.load(getClass().getResourceAsStream("/security.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential unpc = (UsernamePasswordCredential) credential;

		String userName = unpc.getCaller();
		String password = unpc.getPasswordAsString();
		
		if (!isUserValid(userName, password)) {
			return CredentialValidationResult.INVALID_RESULT;
		}
		
		Set<String> groups = groups(userName);
		return new CredentialValidationResult(userName, groups);
	}
	
	private boolean isUserValid(String userName, String password) {
		String storedPassword = props.getProperty("pwd_" + userName);
		
		if (password.equals(storedPassword)) {
			return true;
		}
		
		return false;
	}
	
	private Set<String> groups(String userName) {
		String groups = props.getProperty("groups_" + userName);
		
		if (groups == null) {
			return null;
		}
		
		return Stream.of(groups.split(","))
				.collect(Collectors.toSet());
	}
}
