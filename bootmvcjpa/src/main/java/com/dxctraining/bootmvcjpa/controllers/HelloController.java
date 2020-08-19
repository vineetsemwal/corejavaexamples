package com.dxctraining.bootmvcjpa.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    /**
     *
     *  1) decides which view should render response
     *  2)model data to the view
     *
     *  localhost:8585/hellomsg
     *
     */
  @GetMapping("/hellomsg")
  public ModelAndView  helloworld(){
      System.out.println("inside helloworld");
      String msg="hello friend";
      // hello is name of the view
      // message is model object name
      // msg is model object value
      ModelAndView modelAndView=new ModelAndView("hello","message",msg);
      return modelAndView;
  }

}
