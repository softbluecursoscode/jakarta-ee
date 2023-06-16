package br.com.softblue.javaee.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0)  { 
         System.out.println("Request foi destruída");
    }

    public void requestInitialized(ServletRequestEvent event)  { 
         System.out.println("Request foi inicializada");
         
         HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
         request.setAttribute("nome", "Carlos");
    }
}
