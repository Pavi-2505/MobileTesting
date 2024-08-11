package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMReport(String jsonFile) {

		// mention report location
		File reportDirectory = new File(System.getProperty("user.dir") + "\\target");

		// add configuration
		Configuration configuration = new Configuration(reportDirectory, "WizzAirMobileAutomation");

		configuration.addClassifications("author", "Nitish");
		configuration.addClassifications("sprint", "07");
		configuration.addClassifications("build", "Wiz4758");
		configuration.addClassifications("environment", "QA");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
