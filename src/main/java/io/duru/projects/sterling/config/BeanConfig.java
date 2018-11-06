package io.duru.projects.sterling.config;

import io.duru.projects.sterling.apimodel.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * created by dduru on 06/10/2018
 */
@Configuration
public class BeanConfig {

    @Autowired
    private Environment env;


    @Bean
    public AppConfiguration appConfiguration() {
        return new AppConfiguration()
                .setName(env.getProperty("app.config.name"));
    }


}