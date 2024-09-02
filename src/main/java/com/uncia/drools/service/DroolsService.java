package com.uncia.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uncia.drools.model.Participant;
import com.uncia.drools.model.Rate;


@Service
public class DroolsService {

	@Autowired
	private KieContainer kieContainer;

	public Rate getRate(Participant applicantRequest) {
		Rate rate = new Rate();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("rate", rate);
		kieSession.insert(applicantRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return rate;
	}
//	public Response getRate(List<Deviation> deviationList) {
////		Rate rate = new Rate();
//		Response response = new Response();
////		Integer overDue = 0;
////		Rate rate = new Rate();
//		KieSession kieSession = kieContainer.newKieSession();
//		kieSession.setGlobal("response", response);
//		kieSession.insert(deviationList);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return response;
//	}
//
////	public List<Rate> getRate(List<Participant> request) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	

}
