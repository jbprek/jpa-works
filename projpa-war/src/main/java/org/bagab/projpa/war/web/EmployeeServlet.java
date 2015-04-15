package org.bagab.projpa.war.web;

import org.bagab.projpa.war.boundary.EmployeeService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author prekezes.
 */
public class EmployeeServlet {

    @EJB
    private EmployeeService bean;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            String name = request.getParameter("name");
            String salary = request.getParameter("salary");
            bean.createEmployee( name,  Long.parseLong(salary));
        }
    }
}
