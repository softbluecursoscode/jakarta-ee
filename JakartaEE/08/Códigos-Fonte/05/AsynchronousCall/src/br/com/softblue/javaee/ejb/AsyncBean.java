package br.com.softblue.javaee.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBean {

	@Asynchronous
	public void processar() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	@Asynchronous
	public Future<Integer> processarERetornar() {
		int soma = 0;
		
		for (int i = 1; i <= 10; i++) {
			soma += 1;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		return new AsyncResult<Integer>(soma);
	}
}
