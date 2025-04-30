package de.hehnle.parkingpermit.craftsperson;  

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils; 

@Configuration
public class AppConfig{
	
    @Autowired // do not use field injection
    private ResourceLoader resourceLoader;

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        
        Resource[] propertiesResources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:properties/*/application.properties");
        propertySourcesPlaceholderConfigurer.setLocations(propertiesResources);

        return propertySourcesPlaceholderConfigurer;
    }
}