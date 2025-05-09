package com.intense.als;

import java.sql.*;
import java.util.concurrent.*;

public class DatabaseRecordCheckerOptimized {

	static Connection con = null;
	static Statement stmt = null;

	private static volatile boolean foundRecord = false;

	public void connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.161:1521:orcl", "RJIO_NE", "RJIO_NE");
			stmt = con.createStatement();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void m1() {
		try {
			connectDB();
			Thread checkingThread = new Thread(() -> {
				try {
					while (!foundRecord) {
						java.util.Date date = new java.util.Date();
						System.out.println(date);
						ResultSet resultSet = stmt
								.executeQuery("select * from ALS_TRANS_INFO where TRANSACTION_ID='JD02' and ACK_ID='4974837036373874408' order by SUBMITTED_AT desc FETCH FIRST 1 ROW ONLY");

						if (resultSet.next()) {
							System.out.println("Record found!");
							foundRecord = true;
							break;
						} else {
							System.out.println("Record not found!");
						}

						TimeUnit.SECONDS.sleep(5);
					}
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}
			});

			checkingThread.start();
			
			  try { 
				  checkingThread.join(); 
			  } catch (Exception e2) { e2.printStackTrace();
			  
			  }
			 

		}
		// Wait for the checking thread to finish
		catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		DatabaseRecordCheckerOptimized dr=new DatabaseRecordCheckerOptimized();
		dr.m1();
	}
}
