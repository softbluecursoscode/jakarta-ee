package br.com.softblue.javaee.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validador customizado.
 * Valida se a data fornecida, no padr�o MM/yyyy � igual ou posterior � data atual.
 */
@FacesValidator("dateValidator")
public class DateValidator implements Validator<Date> {

	@Override
	public void validate(FacesContext context, UIComponent component, Date date) throws ValidatorException {
		// Prepara um Calendar com a data fornecida
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		resetCalendar(dateCal);
		
		// Prepara um Calendar com a data atual
		Calendar todayCal = Calendar.getInstance();
		resetCalendar(todayCal);
		
		// Verifica se a data fornecida � anterior � data atual. Neste caso gera o erro de valida��o
		if (dateCal.before(todayCal)) {
			// Obt�m a refer�ncia ao message bundle cadastro no faces-config.xml
			Application app = context.getApplication();
			String messageBundle = app.getMessageBundle();
			
			// Obt�m um ResourceBundle com base neste arquivo
			ResourceBundle resourceBundle = ResourceBundle.getBundle(messageBundle);
			
			// L� a mensagem de erro do arquivo de recursos
			String msg = resourceBundle.getString("curso.jsf.validator.DateValidator");
			
			// Lan�a a exce��o de valida��o
			FacesMessage facesMsg = new FacesMessage(msg);
			throw new ValidatorException(facesMsg);
		}
	}
	
	/**
	 * Reseta os campos do dia, hora, minuto, segundo e milissegundo do Calendar. Isto � necess�rio para que estes 
	 * valores n�o interfiram na compara��o das datas, que leva em conta apenas o m�s e o ano.
	 */
	private void resetCalendar(Calendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
}
