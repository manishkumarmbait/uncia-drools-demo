package com.uncia.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsApplicationConfig {

	private static final KieServices kieServices = KieServices.Factory.get();
	 private static final String RULES_CUSTOMER_RULES_DRL = "rules/loan_rate.drl";
	 
	   @Bean
	     public KieContainer kieContainer() {
	         KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
	         kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
	         KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
	         kb.buildAll();
	         KieModule kieModule = kb.getKieModule();
	         KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
	         return kieContainer;
	     }
}
