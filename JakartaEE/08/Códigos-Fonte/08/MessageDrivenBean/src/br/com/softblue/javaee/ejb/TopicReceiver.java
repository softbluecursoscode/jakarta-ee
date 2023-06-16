package br.com.softblue.javaee.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.softblue.javaee.Produto;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/topic/SoftTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jms/topic/SoftTopic")
public class TopicReceiver implements MessageListener {
	
    public void onMessage(Message message) {
    	ObjectMessage objectMessage = (ObjectMessage) message;
    	
    	try {
			Produto p = (Produto) objectMessage.getObject();
			System.out.println(p);
		
    	} catch (JMSException e) {
			e.printStackTrace();
		}
    	
    }
}
