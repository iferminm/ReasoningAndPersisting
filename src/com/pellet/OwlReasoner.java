package com.pellet;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;

public class OwlReasoner {

	private OwlReasoner instance = new OwlReasoner();
	
	private OwlReasoner() {}
	
	public OwlReasoner getInstance() {
		return this.instance;
	}
	
	public InfModel reasonOverModel(String path) {
		Model emptyModel = ModelFactory.createDefaultModel();
		
		Reasoner reasoner = PelletReasonerFactory.theInstance().create();
		InfModel model = ModelFactory.createInfModel(reasoner, emptyModel);
		model.read(path);
		
		return model;
	}
}
