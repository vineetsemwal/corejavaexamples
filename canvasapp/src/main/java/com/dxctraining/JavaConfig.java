package com.dxctraining;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration annotation tells spring that JavaConfig class is our configuration class
 * @ComponentScan is telling spring where to scan for bean classes
 */
@Configuration
@ComponentScan("com.dxctraining")
public class JavaConfig {

}
