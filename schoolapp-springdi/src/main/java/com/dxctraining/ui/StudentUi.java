package com.dxctraining.ui;

import com.dxctraining.JavaConfig;
import com.dxctraining.entities.ComputerScienceStudent;
import com.dxctraining.entities.Course;
import com.dxctraining.entities.ElectronicsStudent;
import com.dxctraining.entities.Student;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.exceptions.StudentNotFoundException;
import com.dxctraining.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class StudentUi {

    @Autowired
    private IStudentService service;

    @PostConstruct
     public void runApp() {
        try {
            Course java = new Course(1, "java");
            Course python = new Course(2, "python");
            Course embedded = new Course(3, "embedded");
            Student student1 = new ComputerScienceStudent("dharma", 21, true, "dell", java);
            service.add(student1);
            int id1 = student1.getId();
            Student student2 = new ComputerScienceStudent("muskan", 22, true, "lenovo", python);
            service.add(student2);
            int id2 = student2.getId();
            Student student3 = new ElectronicsStudent("roopsai", 22, true, "multimeter", embedded);
            service.add(student3);
            int id3 = student3.getId();
            service.delete(student2.getId());
            service.updateName(student1.getId(), "dharma teja");


            Student fetched = service.findById(id3);
            display(fetched);
            System.out.println("********display all students******");
            displayAll();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some thing went wrong");
        }

    }

    public void displayAll() {
        List<Student> list = service.findAll();
        for (Student student : list) {
            display(student);
        }
    }

    public void display(Student student) {
        System.out.println("student " + student.getId() + " " + student.getName() + " " + student.getAge() + " "
                + student.getPlaced());
        Course course = student.getCourse();
        System.out.println("course=" + course.getId() + " " + course.getName());
        if (student instanceof ComputerScienceStudent) {
            ComputerScienceStudent cseStud = (ComputerScienceStudent) student;
            System.out.println("laptop allotted is " + cseStud.getLaptopAlloted());
        }

        if (student instanceof ElectronicsStudent) {
            ElectronicsStudent eceStud = (ElectronicsStudent) student;
            System.out.println("gadget alloted is " + eceStud.getGadgetAlloted());
        }

    }

}
