package com.main;

import java.io.FileInputStream;

import virtuoso.jena.driver.VirtModel;
import com.hp.hpl.jena.rdf.model.Model;

public class VirtuosoImporter {

	private String connection = "jdbc:virtuoso://localhost:1111";
	private String user = "dba";
	private String pwd = "virtuoso";
	
	public void toVirtuoso(String file) {
		try {
			Model virtModel = VirtModel.openDatabaseModel("thesis:test", this.connection, this.user, this.pwd);
			virtModel.read(new FileInputStream(file), "http://localhost/thesis/virt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
