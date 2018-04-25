package com.cg.demo;

import java.io.FileReader;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import au.com.bytecode.opencsv.CSVReader;

public class App
{
	public static void main(final String[] args) throws Exception
	{
		/* Create Connection objects */
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "Niki10@pas");
		PreparedStatement sql_statement = null;
		String jdbc_insert_sql = "INSERT INTO Person"
		        + "(name, age) VALUES"
		        + "(?,?)";
		sql_statement = conn.prepareStatement(jdbc_insert_sql);
		/* Read CSV file in OpenCSV */
		String inputCSVFile = "D:\\moeve-ide\\workspaces\\main\\nikita965\\demo\\src\\main\\resources\\csv\\report.csv";
		CSVReader reader = new CSVReader(new FileReader(inputCSVFile));
		String[] nextLine;
		int lnNum = 0;
		// loop file , add records to batch
		while ((nextLine = reader.readNext()) != null)
		{
			lnNum++;
			/* Bind CSV file input to table columns */
			sql_statement.setString(1, nextLine[0]);
			/* Bind Age as double */
			/* Need to convert string to double here */
			sql_statement.setString(2, nextLine[1]);
			// Add the record to batch
			sql_statement.addBatch();
		}
		// We are now ready to perform a bulk batch insert
		int[] totalRecords = new int[4];
		try
		{
			totalRecords = sql_statement.executeBatch();
		} catch (BatchUpdateException e)
		{
			// you should handle exception for failed records here
			totalRecords = e.getUpdateCounts();
		}
		System.out.println("Total records inserted in bulk from CSV file " + totalRecords.length);
		/* Close prepared statement */
		sql_statement.close();
		/* COMMIT transaction */
		conn.commit();
		/* Close connection */
		conn.close();
	}
}