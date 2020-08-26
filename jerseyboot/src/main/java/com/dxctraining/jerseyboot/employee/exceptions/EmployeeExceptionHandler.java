package com.dxctraining.jerseyboot.employee.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.*;

@Provider
public class EmployeeExceptionHandler implements ExceptionMapper<EmployeeNotFoundException> {

    @Override
    public Response toResponse(EmployeeNotFoundException exception) {
        System.out.println("*** handling exomployeenotfoundexception ***");
        String msg = exception.getMessage();
        Response response = Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        return response;
    }
}
