package com.compareglobal.service;

import com.compareglobal.service.config.CreditCardServiceConfiguration;
import com.compareglobal.service.config.DatabaseConfiguration;
import com.compareglobal.service.config.MessagesConfiguration;
import com.compareglobal.service.dao.*;
import com.compareglobal.service.resource.CreditCardResource;
import com.github.jknack.handlebars.Handlebars;
import com.compareglobal.service.helper.ContainsHelper;
import com.compareglobal.service.helper.IsInHelper;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.github.jknack.handlebars.springmvc.SpringTemplateLoader;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;
@Configuration
public class CreditCardService extends Service<CreditCardServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new CreditCardService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<CreditCardServiceConfiguration> bootstrap) {
        bootstrap.setName("creditcard-service");
    }

    // you probably would like to move this method to separate class
    private Injector createInjector(final CreditCardServiceConfiguration conf) {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(CreditCardServiceConfiguration.class).toInstance(conf);
                bind(MessagesConfiguration.class).toInstance(conf.getMessages());
                bind(CreditCardDAO.class).to(CreditCardDAOImpl.class);
            }
        }, createJpaPersistModule(conf.getDatabase()));
    }

    // you probably would like to move this method to separate class
    private JpaPersistModule createJpaPersistModule(DatabaseConfiguration conf) {
        Properties props = new Properties();
        props.put("javax.persistence.jdbc.url", conf.getUrl());
        props.put("javax.persistence.jdbc.user", conf.getUser());
        props.put("javax.persistence.jdbc.password", conf.getPassword());
        props.put("javax.persistence.jdbc.driver", conf.getDriverClass());
        JpaPersistModule jpaModule = new JpaPersistModule("Default");
        jpaModule.properties(props);
        return jpaModule;
    }

    @Override
    public void run(final CreditCardServiceConfiguration conf, final Environment env) {
        Injector injector = createInjector(conf);
        env.addFilter(injector.getInstance(PersistFilter.class), "/*");
        env.addResource(injector.getInstance(CreditCardResource.class));
    }
}
