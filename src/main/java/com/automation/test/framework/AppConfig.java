package com.automation.test.framework;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:cucumber.xml")
public class AppConfig {
}
