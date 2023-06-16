package br.com.softblue.javaa.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator<Date> {

	@Override
	public void validate(FacesContext context, UIComponent component, Date dateNasc) throws ValidatorException {		
		Date now = new Date();
		
		if (dateNasc != null && dateNasc.after(now)) {
			FacesMessage msg = new FacesMessage("A data digitada é maior que a data atual");
			throw new ValidatorException(msg);
		}
	}
}
