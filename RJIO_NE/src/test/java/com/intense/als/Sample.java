package com.intense.als;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Sample extends Thread {

	private static volatile boolean foundRecord = false;
	static Connection con = null;
	static Statement stmt = null;
	boolean v1 = false;

	String status = null;
	String comments = null;
	String noOfevents = null;
	String listener = null;
	String submittedDate = null;
	String tranactionID = null;
	String transID = null;
	long ackiID;

	public void connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.161:1521:orcl", "RJIO_NE", "RJIO_NE");
			stmt = con.createStatement();
		} catch (Exception e) {

		}
	}

	public Map<String, String> getTransMasterData(String tranID, long ackID) {
		try {

			connectDB();
			ResultSet resultquery = null;
			resultquery = stmt.executeQuery("select * from ALS_TRANS_MASTER where ACK_ID='" + ackID
					+ "' AND TRANACTION_ID='" + tranID + "' ORDER BY SUBMITTED_AT DESC FETCH FIRST 1 ROW ONLY");
			Map<String, String> result = new HashMap<String, String>();
			while (resultquery.next()) {
				// status = resultquery.getString("STATUS");
				status = result.put("status", resultquery.getString("STATUS"));
				comments = result.put("comments", resultquery.getString("COMMENTS"));
				noOfevents = result.put("noOfevents", Integer.toString(resultquery.getInt("NO_OF_EVENTS")));
				listener = result.put("listener", resultquery.getString("LISTENER"));
				submittedDate = result.put("submittedDate", resultquery.getString("SUBMITTED_AT"));
				tranactionID = result.put("tranactionID", resultquery.getString("TRANACTION_ID"));
			}

			/*
			 * result.put("status", status); result.put("comments", comments);
			 * result.put("noOfevents", noOfevents); result.put("listener", listener);
			 * result.put("submittedDate", submittedDate); result.put("tranactionID",
			 * tranactionID);*
			 * 
			 * /* List<String> result = new ArrayList<String>(); result.add(status);
			 * result.add(comments); result.add(noOfevents); result.add(listener);
			 * result.add(submittedDate);
			 */
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void display(String transID, long ackiID) {
		this.transID = transID;
		this.ackiID = ackiID;
		System.out.println(transID + "  :: " + ackiID);

	}

	public void run() {
		try {
			System.out.println("This code is running in a thread!!");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.161:1521:orcl", "RJIO_NE", "RJIO_NE");
			stmt = con.createStatement();
			ResultSet resultSet;
			while (!foundRecord) {
				java.util.Date date = new java.util.Date();
				System.out.println(date);
				resultSet = stmt.executeQuery("select * from ALS_TRANS_INFO where TRANSACTION_ID='" + transID
						+ "' and ACK_ID='" + ackiID + "' order by SUBMITTED_AT desc FETCH FIRST 1 ROW ONLY");

				if (resultSet.next()) {
					System.out.println("Record found!");
					foundRecord = true;
					break;
				} else {
					System.out.println("Record not found!");
				}

				TimeUnit.SECONDS.sleep(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void m1() throws InterruptedException {
		/*
		 * Sample thread = new Sample(); long ack = 4974837036373874408L; Map<String,
		 * String> rs = getTransMasterData("JD02", ack); //
		 * System.out.println(rs.get("comments")); thread.display("JD02", ack);
		 * thread.start(); thread.join();
		 */
		Map<String, String> rss1 = rt();
		
		if(rss1.get("") != null) {
		System.err.println(rss1.get("name"));
		}
		else
		{
			System.err.println("hjjh");
		}
	}

	public LinkedHashMap<String, String> rt() {
		
		try {
			LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
			if (false) {
				lhm.put("name", "venky");
				return lhm;
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new LinkedHashMap<>();

	}
}
