package net.sf.json.xml;

import net.sf.json.JSON;

import org.custommonkey.xmlunit.XMLTestCase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestXmlWithSingleAndMultipleElements extends XMLTestCase {

	public void test_convert_xml_multiple_entries_1() throws IOException,
			SAXException, ParserConfigurationException {
		
		String fixture = strip("<plan>"
				   + " <validPeriods>"
				   + "  <timePeriod>"
				   + "   <validFrom>"
				   + "    <transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				   + "    <effectiveDate year=\"1990\" month=\"1\" day=\"1\"/>"
				   + "   </validFrom>"
				   + "   <validTo user=\"BBROWN5\" comment=\"PlanCreator 15.1.1.4\">"
				   + "    <transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				   + "    <effectiveDate year=\"2010\" month=\"1\" day=\"1\"/>"
				   + "   </validTo>"
				   + "  </timePeriod>"
				   + "  <timePeriod>"
				   + "   <validFrom>"
				   + "    <transactionDate year=\"3015\" month=\"2\" day=\"1\"/>"
				   + "    <effectiveDate year=\"1990\" month=\"1\" day=\"1\"/>"
				   + "   </validFrom>"
				   + "   <validTo user=\"BBROWN5\" comment=\"PlanCreator 15.1.1.4\">"
				   + "    <transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				   + "    <effectiveDate year=\"2010\" month=\"1\" day=\"1\"/>"
				   + "   </validTo>"
				   + "  </timePeriod>"
				   + " </validPeriods>"
				   + "</plan>");
		
		System.out.println(fixture);
		org.kordamp.json.xml.XMLSerializer xmlSerializer = createXmlSerializer("plan");

		final JSON json = xmlSerializer.read(fixture);
		System.out.println(json);

		final String result = xmlSerializer.write(json);
		System.out.println(result);

		assertXMLEqual(fixture, result);
	}

	public void test_convert_xml_multiple_entries_2() throws IOException,
			SAXException, ParserConfigurationException {
		
		String fixture = strip(
				  "<subgroupList>"
				+ "	<group groupNum=\"0082185\" groupName=\"GENTILINI FORD\">"
				+ "		<subgroups>"
				+ "			<subgroup subgroupNum=\"060\" subgroupName=\"GENTILINI FORD\" groupNumPrefix=\"0082185\"/>"
				+ "			<subgroup subgroupNum=\"061\" subgroupName=\"GENTILINI FORD INC\" groupNumPrefix=\"0082185\"/>"
				+ "			<subgroup subgroupNum=\"062\" subgroupName=\"GENTILINI CHEVROLET LLC\" groupNumPrefix=\"0082185\"/>"
				+ "		</subgroups>"
				+ "	</group>"
				+ "</subgroupList>");		
		
		System.out.println(fixture);
		org.kordamp.json.xml.XMLSerializer xmlSerializer = createXmlSerializer("subgroupList");

		final JSON json = xmlSerializer.read(fixture);
		System.out.println(json);

		final String result = xmlSerializer.write(json);
		System.out.println(result);

		assertXMLEqual(fixture, result);
	}	
	
	public void test_convert_xml_with_single_element_1() throws IOException,
			SAXException, ParserConfigurationException {
		String fixture = strip("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<plan>"
				+ "	<validPeriods>"
				+ "		<timePeriod>"
				+ "			<validFrom>"
				+ "				<transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				+ "				<effectiveDate year=\"1990\" month=\"1\" day=\"1\"/>"
				+ "			</validFrom>"
				+ "			<validTo user=\"BBROWN5\" comment=\"PlanCreator 15.1.1.4\">"
				+ "				<transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				+ "				<effectiveDate year=\"2010\" month=\"1\" day=\"1\"/>"
				+ "			</validTo>"
				+ "		</timePeriod>" 
				+ "	</validPeriods>"
				+ "</plan>");
		org.kordamp.json.xml.XMLSerializer xmlSerializer = createXmlSerializer("plan");

		System.out.println(fixture);
		final JSON json = xmlSerializer.read(fixture);
		System.out.println(json);
		
		final String result = xmlSerializer.write(json);
		System.out.println(result);

		assertXMLEqual(fixture, result);		
	}

	
	public void test_convert_xml_with_single_element_1_1() throws IOException,
			SAXException, ParserConfigurationException {
		String fixture = strip("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<plan>"
				+ "	<validPeriods>"
				+ "		<timePeriod>"
				+ "			<validFrom>"
				+ "				<transactionDate year=\"2015\" month=\"2\" day=\"1\"/>"
				+ "				<effectiveDate year=\"1990\" month=\"1\" day=\"1\"/>"
				+ "			</validFrom>"
				+ "		</timePeriod>" 
				+ "	</validPeriods>"
				+ "</plan>");
		org.kordamp.json.xml.XMLSerializer xmlSerializer = createXmlSerializer("plan");

		System.out.println(fixture);
		final JSON json = xmlSerializer.read(fixture);
		System.out.println(json);

		final String result = xmlSerializer.write(json);
		System.out.println(result);

		assertXMLEqual(fixture, result);
	}	

	public void test_convert_xml_with_single_element_2() throws IOException, SAXException, ParserConfigurationException {

		String fixture = strip(
				  "<subgroupList>"
				+ "	<group groupNum=\"0082185\" groupName=\"GENTILINI FORD\">"
				+ "		<subgroups>"
				+ "			<subgroup subgroupNum=\"062\" subgroupName=\"GENTILINI CHEVROLET LLC\" groupNumPrefix=\"0082185\"/>"
				+ "		</subgroups>"
				+ "	</group>"
				+ "</subgroupList>");		
		
		System.out.println(fixture);
		org.kordamp.json.xml.XMLSerializer xmlSerializer = createXmlSerializer("subgroupList");
		
		final JSON json = xmlSerializer.read(fixture);
		System.out.println(json);
		
		final String result = xmlSerializer.write(json);
		System.out.println(result);
		
		assertXMLEqual(fixture, result);
	}		

	private org.kordamp.json.xml.XMLSerializer createXmlSerializer(String rootName ) {
		org.kordamp.json.xml.XMLSerializer xmlSerializer = new org.kordamp.json.xml.XMLSerializer();
		xmlSerializer.setEscapeLowerChars(true);
//		xmlSerializer.setForceTopLevelObject(true);
		xmlSerializer.setRootName(rootName);
		xmlSerializer.setPerformAutoExpansion(true);
		xmlSerializer.setTypeHintsEnabled(false);
//		xmlSerializer.setExpandableProperties(new String[] {"d", "e"});
		List<String> forcedArrays = new ArrayList<String>();
		forcedArrays.add("validPeriods");
		forcedArrays.add("subgroups");
		xmlSerializer.setForcedArrayElements(forcedArrays);

		List<String> forcedObjects = new ArrayList<String>();
		forcedObjects.add("timePeriod");
		forcedObjects.add("validFrom");
		forcedObjects.add("validTo");
		xmlSerializer.setForcedObjectElements(forcedObjects);
		
		xmlSerializer.setKeepArrayName(true);
		xmlSerializer.setSkipNamespaces(true);
		return xmlSerializer;
	}
	
	private String strip(String fixture) {
		return fixture.replaceAll("\\t", "").replaceAll("\\t", "").replaceAll(">(\\s+?)<", "><");
	}
		
//	public void test_strip() {
//		System.out.println(strip("<aaa b=\"1\">  <bbb><cc></bbb></cc> </aaa>"));
//	}
	
}
