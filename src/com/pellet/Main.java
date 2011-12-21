package com.pellet;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Main {

	private static String file = "/var/www/ontologies/ThesisOntology.owl";
	
	private static int countStatements(StmtIterator i) {
		if (i.hasNext()) {
			int counter = 0;
			while (i.hasNext()) {
				i.nextStatement();
				counter++;
			}
			return counter;
		}
		return 0;
	}
	
	private static void select(InfModel model) {
		Property p = model.getProperty("http://localhost/ontologies/ThesisOntology.owl#contents");
		
		StmtIterator iter = model.listStatements(
				new SimpleSelector(null, p, (RDFNode) null)
			);
		int total = countStatements(iter);
		System.out.println("Total of statements on select: " + total);
	}
	
	public static void main(String args[]) {
		InfModel model = OwlReasoner.getInstance().reasonOverModel(file);
		select(model);
	}
}
