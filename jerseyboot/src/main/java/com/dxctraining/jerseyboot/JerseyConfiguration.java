package com.dxctraining.jerseyboot;

import com.dxctraining.jerseyboot.employee.controllers.EmployeeRestController;
import com.dxctraining.jerseyboot.employee.exceptions.EmployeeExceptionHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(EmployeeRestController.class);
        register(EmployeeExceptionHandler.class);
    }

}
