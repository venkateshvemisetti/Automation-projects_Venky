package com.intense.als;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;

import java.io.StringReader;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ALS_NEService {
	public static Response res;
	String statusRes = null;
	String ackIDRes = null;
	String errdescRes = null;
	int HTTPStatusCode;
	ExcelOperations re = new ExcelOperations();
	VerifyDB vdb = new VerifyDB();

	public void sendRequestTOservice() {

		try {

			String baseWSDl = re.readExcelDataValue("wsdl");
			FileInputStream fis = new FileInputStream("NEreqXML.xml");
			RequestSpecification request = RestAssured.given().contentType("text/xml");
			request.body(fis);
			// request.body(IOUtils.toString(fis, "UTF-8"));
			res = request.request(Method.POST, baseWSDl);
			String receivedRes = res.getBody().asPrettyString();
			// System.err.println(res.getBody().asString());
			// System.out.println(receivedRes);
			HTTPStatusCode = res.getStatusCode();

			if (HTTPStatusCode == 200) {
				System.out.println("The request is processed successfully ::\nHTTP code is :: " + res.getStatusCode());
				System.out.println("The resposne XML from servcie is/n" + receivedRes);
			} else {
				System.err.println(
						"The request is failed/not submitted ::\nError HTTP respose code is :: " + res.getStatusCode());
				System.out.println(receivedRes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readResXML() {
		try {
			if (HTTPStatusCode == 200) {
				DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dbuilder = null;

				dbuilder = dbfactory.newDocumentBuilder();

				Document doc = null;

				doc = dbuilder.parse(new InputSource(new StringReader(res.getBody().asString())));

				doc.getDocumentElement().normalize();
				// System.out.println("Root element: " +
				// doc.getDocumentElement().getNodeName());

				NodeList nodeList = doc.getElementsByTagName("return");

				Node node = nodeList.item(0);
				Element element = (Element) node;

				// String
				// status=element.getElementsByTagName("status").item(0).getTextContent();

				// System.err.println(status);

				statusRes = element.getElementsByTagName("status").item(0).getFirstChild().getNodeValue();
				System.err.println("Status is : " + statusRes);

				if ((statusRes.equals("PARTIAL") || statusRes.equals("ACCEPTED"))) {
					ackIDRes = element.getElementsByTagName("ackId").item(0).getFirstChild().getNodeValue();
					System.err.println("AckId is : " + ackIDRes);
				} else {
					errdescRes = element.getElementsByTagName("errdesc").item(0).getFirstChild().getNodeValue();
					System.err.println("ERRdesc is : " + errdescRes);
				}

				/*----------------------loop here for retriving all values----------------------*/

				/*
				 * for (int itr = 0; itr < nodeList.getLength(); itr++) { Node node =
				 * nodeList.item(itr); System.out.println("\nNode Name :" + node.getNodeName());
				 * if (node.getNodeType() == Node.ELEMENT_NODE) { Element eElement = (Element)
				 * node; System.out.println("staus: "+
				 * eElement.getElementsByTagName("status").item(0).getTextContent());
				 * 
				 * }}
				 */
			} else {
				System.err.println("readResXML :: The request is failed :: " + HTTPStatusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void transMasterValidate() {
		try {
			long ackIDL;
			if (HTTPStatusCode == 200) {
				if (statusRes.equals("REJECTED")) {
					ackIDL = 0;
				} else {
					ackIDL = Long.valueOf(ackIDRes);
				}
				ackIDL = Long.valueOf(ackIDL);

				Map<String, String> queryreslutMasterT = vdb.getTransMasterData(re.readExcelDataValue("transactionId"),
						ackIDL);
				// System.out.println("The ALS_TRANS_MASTER table date are :: ");

				for (Map.Entry<String, String> queryreslutMasterTvalues : queryreslutMasterT.entrySet()) {
					System.out.println(queryreslutMasterTvalues.getKey() + " = " + queryreslutMasterTvalues.getValue());
				}

			} else {
				System.out.println("transMasterValidate :: HTTPStatusCode is " + HTTPStatusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void transInfoValidate() {
		try {
			long ackIDL = 0;
			if (HTTPStatusCode == 200) {
				if (statusRes.equals("REJECTED")) {
					System.err.println("transINFOValidate :: The request is REJECTED");
				} else {
					ackIDL = Long.valueOf(ackIDRes);
					Map<String, String> queryreslutInfoT = vdb.getTransINFOData(re.readExcelDataValue("transactionId"),
							ackIDL);
					for (Map.Entry<String, String> queryreslutInfoTvalues : queryreslutInfoT.entrySet()) {
						System.out.println(queryreslutInfoTvalues.getKey() + " = " + queryreslutInfoTvalues.getValue());
					}
				}

			} else {
				System.out.println("transINFOValidate :: HTTPStatusCode is " + HTTPStatusCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeReqXML() {
		try {
			File fis = new File("NEreqXML.xml");
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = null;
			dbuilder = dbfactory.newDocumentBuilder();
			Document doc = null;
			doc = dbuilder.parse(fis);
			NodeList nodes;
			Element element;
			nodes = doc.getElementsByTagName("transactionId");
			element = (Element) nodes.item(0);
			element.setTextContent(re.readExcelDataValue("transactionId"));

			nodes=doc.getElementsByTagName("neTemplateDetails");
			element = (Element) nodes.item(0);
			element.getElementsByTagName("context").item(0).setTextContent(re.readExcelDataValue("context"));
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fis);
			transformer.transform(source, result);

			/*--------------------------To print on console----------*/
			// StreamResult consoleResult = new StreamResult(System.out);
			// transformer.transform(source, consoleResult);

			System.out.println("XML file updated successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeReqXML1() {
		try {

			File fis = new File("NEreqXML.xml");
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = null;
			dbuilder = dbfactory.newDocumentBuilder();
			Document doc = null;
			doc = dbuilder.parse(fis);
			NodeList nodes = doc.getElementsByTagName("neTemplateDetails"); // Replace with actual element name
			Element element = (Element) nodes.item(0);
			element.getElementsByTagName("context").item(0).setTextContent("133JK");

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fis);
			transformer.transform(source, result);

			/*--------------------------To print on console----------*/
			// StreamResult consoleResult = new StreamResult(System.out);
			// transformer.transform(source, consoleResult);

			System.out.println("XML file updated successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}