package com.example.activemq.producer.config;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {
    @Value("${activemq.url}")
    private String brokerUrl;
    @Value("${activemq.user}")
    private String user;
    @Value("${activemq.password}")
    private String password;

    public JmsConfig() {
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return "".equals(this.user) ? new ActiveMQConnectionFactory(this.brokerUrl) : new ActiveMQConnectionFactory(this.user, this.password, this.brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory jmsFactoryTopic(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(this.connectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplateTopic() {
        JmsTemplate jmsTemplate = new JmsTemplate(this.connectionFactory());
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }
}