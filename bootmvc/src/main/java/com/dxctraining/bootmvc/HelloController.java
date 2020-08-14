package com.dxctraining.bootmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    /**
     *
     *  1) decides which view should render response
     *  2)model data to the view
     */
  @GetMapping("/hello")
  public ModelAndView  helloworld(){
      System.out.println("inside helloworld");
      String msg="hello friend";
      ModelAndView modelAndView=new ModelAndView("hello","message",msg);
      return modelAndView;
  }

}
