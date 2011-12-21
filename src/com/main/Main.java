package com.main;

public class Main {

	private static String model = "/var/www/ontologies/ThesisOntology.owl";
	private static String reasoned = "/var/www/ontologies/reasoned.owl";
	
	public static void main(String args[]) {
		OwlReasoner or = new OwlReasoner(model, reasoned);
		or.generateReasonedModel();
		VirtuosoImporter vi = new VirtuosoImporter();
		vi.toVirtuoso(reasoned);
		System.out.println("Done.");
	}

}
