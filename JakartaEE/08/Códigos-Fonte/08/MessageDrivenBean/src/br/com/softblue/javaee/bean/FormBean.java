package br.com.softblue.javaee.bean;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;

import br.com.softblue.javaee.Produto;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	@Resource
	private ConnectionFactory connFactory;
	
	@Resource(mappedName = "java:/jms/queue/SoftQueue")
	private Queue queue;
	
	@Resource(mappedName = "java:/jms/topic/SoftTopic")
	private Topic topic;
	
	private String mensagem;
	
	public String enviar() {
		JMSContext context = connFactory.createContext();
		JMSProducer producer = context.createProducer();
		producer.send(queue, mensagem);
		
		Produto p = new Produto(1, "P1");
		producer.send(topic, p);
		
		return null;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
