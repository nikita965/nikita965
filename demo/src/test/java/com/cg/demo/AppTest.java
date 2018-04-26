package com.cg.demo;

import com.cg.demo.model.Report;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */

	public AppTest(final String testName)
	{
		super(testName);
	}


	@org.junit.Test
	public void ReportTest() throws Exception
	{

		Report report = new Report();
		report.setName("Barry Alder");
		report.setAge("45");

	}


	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(AppTest.class);
	}


	public void testApp()
	{
		assertTrue(true);
	}

}
