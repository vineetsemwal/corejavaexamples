package com.dxctraining;

import org.springframework.context.annotation.*;

/**
 * @Configuration annotation tells spring that JavaConfig class is our configuration class
 * @ComponentScan is telling spring where to scan for bean classes
 */
@Configuration
@ComponentScan("com.dxctraining")
@PropertySource("classpath:canvas.properties")
public class JavaConfig {

    /*
    @Bean
    public Circle circle(){
        Circle circle=new Circle(10);
        return circle;
    }
    */

    @Bean
    public Rectangle rectangle(){
        Rectangle rectangle=new Rectangle();
        return rectangle;
    }

}
