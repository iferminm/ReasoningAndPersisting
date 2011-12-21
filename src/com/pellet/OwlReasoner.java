package com.pellet;


import java.io.InputStream;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.util.FileManager;

public class OwlReasoner {

	private static OwlReasoner instance = new OwlReasoner();
	
	private OwlReasoner() {}
	
	public static OwlReasoner getInstance() {
		return instance;
	}
	
	public InfModel reasonOverModel(String path) {
		Model emptyModel = ModelFactory.createDefaultModel();
		
		Reasoner reasoner = PelletReasonerFactory.theInstance().create();
		InfModel model = ModelFactory.createInfModel(reasoner, emptyModel);
		InputStream in = FileManager.get().open(path);
		model.read(in, "");
		
		return model;
	}
}
