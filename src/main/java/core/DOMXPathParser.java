package core;
//BEGIN
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

public class DOMXPathParser {

	public static void main(String[] args) throws Throwable, Exception,
			ParserConfigurationException {

		String url = "http://learn2test.net/sdc.xml";

		String xpath_element_01 = "//deals/deal/description";
		String xpath_element_02 = "//deals/deal/impact-score";
		String xpath_element_03 = "//deals/deal/price";
		String xpath_element_04 = "//deals/deal/orig-price";

		String xpath_attribute_01 = "//deals/@count";

		// Get the DOM Builder Factory
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder b = f.newDocumentBuilder();

		// Load and Parse the XML document contains the complete XML as a Tree.
		Document d = b.parse(url);

		// Optional
		d.getDocumentElement().normalize();

		// xPath
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();

		String element_01 = xpath.compile(xpath_element_01).evaluate(d);
		String element_02 = xpath.compile(xpath_element_02).evaluate(d);
		String element_03 = xpath.compile(xpath_element_03).evaluate(d);
		String element_04 = xpath.compile(xpath_element_04).evaluate(d);
		String attribute_01 = xpath.compile(xpath_attribute_01).evaluate(d);

		System.out.println("description: " + element_01);
		System.out.println("impact-score: " + element_02);
		System.out.println("price: " + element_03);
		System.out.println("orig-price: " + element_04);
		System.out.println("Number of deals: " + attribute_01);

	}
}
//END