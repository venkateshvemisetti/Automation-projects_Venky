package com.intense.als;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class VerifyDB {
	Connection con = null;
	Statement stmt = null;
	ResultSet resultquery = null;

	private static boolean foundRecordInfoTable = false;
	private static boolean foundRecordMasterTable = false;
	java.util.Date date ;

	public void connectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.161:1521:orcl", "RJIO_NE", "RJIO_NE");
			stmt = con.createStatement();
		} catch (Exception e) {

		}
	}

	public LinkedHashMap<String, String> getTransMasterData(String tranID, long ackID) {
		try {

			connectDB();
			int maxfindings = 11;
			int findings = 0;
			System.err.println(tranID + " :: Master table :: " + ackID);
			String queryMaster = "select * from ALS_TRANS_MASTER where ACK_ID='" + ackID + "' AND TRANACTION_ID='"
					+ tranID + "' ORDER BY SUBMITTED_AT DESC FETCH FIRST 1 ROW ONLY";
			LinkedHashMap<String, String> resultMaster = new LinkedHashMap<String, String>();

			while (!foundRecordMasterTable && findings < maxfindings) {
				// java.util.Date date = new java.util.Date();
				resultquery = stmt.executeQuery(queryMaster);
				if (resultquery.next()) {
					foundRecordMasterTable = true;
					resultMaster.put("", "The ALS_TRANS_MASTER table data are ::");
					resultMaster.put("status", resultquery.getString("STATUS"));
					resultMaster.put("comments", resultquery.getString("COMMENTS"));
					resultMaster.put("noOfevents", Integer.toString(resultquery.getInt("NO_OF_EVENTS")));
					resultMaster.put("listener", resultquery.getString("LISTENER"));
					resultMaster.put("submittedDate", resultquery.getString("SUBMITTED_AT"));
					resultMaster.put("tranactionID", resultquery.getString("TRANACTION_ID"));
					break;

				} else {
					 date = new java.util.Date();
					System.out.println(+findings + " : " + date + " :: checking for record in Master table.......");
				}
				resultquery.close();
				findings++;
				TimeUnit.SECONDS.sleep(5);

			}
			if (!foundRecordMasterTable) {
				System.err.println("not record found in trans info table");
			}

			return resultMaster;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LinkedHashMap<>();
	}

	public LinkedHashMap<String, String> getTransINFOData(String tranID, long ackID) {
		try {
			connectDB();
			int maxfindings = 11;
			int findings = 0;
			System.err.println( tranID + " :: Info table :: " +ackID);
			String queryInfo = "select * from ALS_TRANS_INFO where TRANSACTION_ID='" + tranID + "' and ACK_ID='" + ackID
					+ "' order by SUBMITTED_AT desc FETCH FIRST 1 ROW ONLY";
			LinkedHashMap<String, String> reslutALSInfo = new LinkedHashMap<String, String>();
			while (!foundRecordInfoTable && findings < maxfindings) {
				// java.util.Date date = new java.util.Date();
				resultquery = stmt.executeQuery(queryInfo);

				if (resultquery.next()) {
					foundRecordInfoTable = true;
					reslutALSInfo.put("", "The ALS_TRANS_INFO table data are ::");
					reslutALSInfo.put("EVENT_ID", Long.toString((resultquery.getLong("EVENT_ID"))));
					reslutALSInfo.put("CHANNEL", resultquery.getString("CHANNEL"));
					reslutALSInfo.put("RECEIVER_ID", Integer.toString(resultquery.getInt("RECEIVER_ID")));
					reslutALSInfo.put("STATUS", resultquery.getString("STATUS"));
					reslutALSInfo.put("SUBMITTED_AT", resultquery.getString("SUBMITTED_AT"));
					reslutALSInfo.put("PROCESSED_AT", (resultquery.getString("PROCESSED_AT")));
					reslutALSInfo.put("COMMENTS", resultquery.getString("COMMENTS"));
					reslutALSInfo.put("ACTION_NAME", resultquery.getString("ACTION_NAME"));
					reslutALSInfo.put("MESSAGE_ID", resultquery.getString("MESSAGE_ID"));
					reslutALSInfo.put("ACCOUNT_NAME", resultquery.getString("ACCOUNT_NAME"));
					reslutALSInfo.put("SOURCE_NAME", resultquery.getString("SOURCE_NAME"));
					reslutALSInfo.put("DELIVERED_AT", resultquery.getString("DELIVERED_AT"));
					reslutALSInfo.put("SERVER_TIME", Integer.toString(resultquery.getInt("SERVER_TIME")));
					reslutALSInfo.put("ACK_ID", Long.toString(resultquery.getLong("ACK_ID")));
					reslutALSInfo.put("NOTIFICATION_MSG", resultquery.getString("NOTIFICATION_MSG"));
					reslutALSInfo.put("ACCOUNT_GROUP", resultquery.getString("ACCOUNT_GROUP"));
					reslutALSInfo.put("EMAIL_SUBJECT", resultquery.getString("EMAIL_SUBJECT"));
					break;
				} else {
					 date = new java.util.Date();
					System.out.println(+findings + " : " + date + " :: checking for record in Info table.......");

				}
				resultquery.close();
				findings++;
				TimeUnit.SECONDS.sleep(5);
			}
			if (!foundRecordInfoTable) {
				System.err.println("not record found in trans info table");
			}
			return reslutALSInfo;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LinkedHashMap<>();
	}

	@Test
	public void m1() {
		try {
			long ack = 3283838690163574134L;
			// Map<String, String> rs = getTransMasterData("JD0287", ack); //
			// System.out.println(rs.get("comments"));
			// Map<String, String> rs=getTransINFOData("JD0211", ack);
			// System.out.println(rs.get("CHANNEL"));

			Map<String, String> queryreslutInfoT = getTransINFOData("NA057", ack);
			for (Map.Entry<String, String> queryreslutInfoTvalues : queryreslutInfoT.entrySet()) {
				System.out.println(queryreslutInfoTvalues.getKey() + " = " + queryreslutInfoTvalues.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
