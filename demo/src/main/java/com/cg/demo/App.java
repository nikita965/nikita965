package com.cg.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{

	public static void main(final String[] args)
	{
		DBase db = new DBase();
		Connection conn = db.connect("jdbc:oracle:thin:@localhost:1521:xe", "system", "Niki10@pas");

		db.importData(conn, "D:\\moeve-ide\\workspaces\\main\\nikita965\\demo\\src\\main\\resources\\csv\\report.csv");
		System.out.println("bsdcvbdw");
	}

}

class DBase
{
	public DBase()
	{
	}


	public Connection connect(final String db_connect_str,
	        final String db_userid, final String db_password)
	{
		Connection conn;
		try
		{
			Class.forName(
			        "oracle.jdbc.driver.OracleDriver").newInstance();

			conn = DriverManager.getConnection(db_connect_str,
			        db_userid, db_password);

		} catch (Exception e)
		{
			e.printStackTrace();
			conn = null;
		}

		return conn;
	}


	public void importData(final Connection conn, final String filename)
	{
		Statement stmt;
		String query;
		// filename="D:\moeve-ide\workspaces\main\nikita965\demo\src\main\resources\csv\report.csv";

		try
		{
			stmt = conn.createStatement(
			        ResultSet.TYPE_SCROLL_SENSITIVE,
			        ResultSet.CONCUR_UPDATABLE);

			System.out.println("jsgfsa");

			query = "LOAD DATA INFILE '" + filename + "' INTO TABLE Person  FIELDS TERMINATED BY ',' (name,age)";

			System.out.println(query);

			stmt.executeUpdate(query);

		} catch (Exception e)
		{
			e.printStackTrace();
			stmt = null;
		}
	}
};
