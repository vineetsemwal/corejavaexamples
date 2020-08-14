package com.dxctraining.ui;

import com.dxctraining.developer.entities.Developer;
import com.dxctraining.developer.service.IDeveloperService;
import com.dxctraining.tester.entities.Tester;
import com.dxctraining.exceptions.EmployeeNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.tester.service.ITesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployeeUi {
    @Autowired
    private IDeveloperService developerService;

    @Autowired
    private ITesterService testerService;


    @PostConstruct
    public void runUi() {
        try {
            Developer developer = new Developer("vineel", 21, 5000,"java");
            developer=developerService.save(developer);

            Tester tester = new Tester("khadar", 22, 3000,"junit");
            tester =testerService.save(tester);

            int developerId1 = developer.getId();
            Developer fetchedDeveloper1 = developerService.findById(developerId1);
            System.out.println("fetcehed employee =" + fetchedDeveloper1.getName() + " " + fetchedDeveloper1.getAge() + " " + fetchedDeveloper1.getSalary());

            System.out.println("language used=" + fetchedDeveloper1.getLanguage());


        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
