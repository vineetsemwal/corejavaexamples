package com.dxctraining.ui;

import com.dxctraining.JavaConfig;
import com.dxctraining.entities.*;
import com.dxctraining.exceptions.*;
import com.dxctraining.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

public class StudentMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

    }

}