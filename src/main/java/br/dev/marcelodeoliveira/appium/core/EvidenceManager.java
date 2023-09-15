package br.dev.marcelodeoliveira.appium.core;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class EvidenceManager {

	@Rule
	public static TestName testName = new TestName();

	private final static String DEFAULT_EVIDENCE_LOCATION = "target/evidence/";
	private final static String DEFAULT_EVIDENCE_FORMAT = ".png";

	public static void takeScreenshot(String methodName) {
		try {
			File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, getNewEvidenceFile(methodName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File getNewEvidenceFile(String methodName) {
		// String methodName = testName.getMethodName();
		return new File(DEFAULT_EVIDENCE_LOCATION + methodName + DEFAULT_EVIDENCE_FORMAT);
	}

}
