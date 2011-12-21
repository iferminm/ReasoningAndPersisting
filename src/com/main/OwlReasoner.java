package com.main;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.util.FileManager;

import java.io.InputStream;

public class OwlReasoner {

	private String modelLocation;
	private String reasonedModelLocation;
	
	public OwlReasoner() {}
	
	public OwlReasoner(String model) {
		this.modelLocation = model;
		String[] arg = model.split(".");
		this.reasonedModelLocation = arg[0] + "Reasoned.owl";
	}
	
	public OwlReasoner(String model, String reasoned) {
		this.modelLocation = model;
		this.reasonedModelLocation = reasoned;
	}
	
	private void printModel(Model model) {
		StmtIterator iter = model.listStatements(
				new SimpleSelector(null, null, (RDFNode) null)
			);
		if (iter.hasNext()) {
			int counter = 0;
			System.out.println("I've found the following statements:");
			while (iter.hasNext()) {
				System.out.println("    " + iter.nextStatement().toString());
				counter++;
			}
			System.out.println("Found: " + counter + " statements");
		}
		else {
			System.out.println("No statements on loaded model");
		}
	}
	
	public void generateReasonedModel() {
		Model emptyModel = ModelFactory.createDefaultModel();
		
		// Getting a Pellet instance
		Reasoner reasoner = PelletReasonerFactory.theInstance().create();
		
		InfModel model = ModelFactory.createInfModel(reasoner, emptyModel);
		InputStream in = FileManager.get().open(modelLocation);
		
		model.read(in, "");
		this.printModel(model);
	}

	public String getModelLocation() {
		return modelLocation;
	}

	public void setModelLocation(String modelLocation) {
		this.modelLocation = modelLocation;
	}

	public String getReasonedModelLocation() {
		return reasonedModelLocation;
	}

	public void setReasonedModelLocation(String reasonedModelLocation) {
		this.reasonedModelLocation = reasonedModelLocation;
	}
}
