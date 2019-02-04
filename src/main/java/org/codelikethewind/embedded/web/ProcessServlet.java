package org.codelikethewind.embedded.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelikethewind.embedded.util.StartupBean;
import org.jbpm.services.ejb.api.ProcessServiceEJBLocal;

import java.util.HashMap;
import java.util.Map;

public class ProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProcessServiceEJBLocal processService;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
		// Start the process here
		long processInstanceId = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		processInstanceId = processService.startProcess(StartupBean.DEPLOYMENT_ID, "com.sample.bpmn.hello", params);
		 
		System.out.println("Process instance " + processInstanceId + " has been successfully started.");
        
    }
}
