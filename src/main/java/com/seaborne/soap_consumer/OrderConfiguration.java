package com.seaborne.soap_consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public OrderClient orderClient(Jaxb2Marshaller marshaller) {
        OrderClient client = new OrderClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
