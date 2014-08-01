package XMLtest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTest {
	
	private static Logger log = Logger.getLogger(XMLTest.class); 
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		String path = System.getProperty("user.dir")+"\\src\\XMLTest";
		log.info(path);
		File xmlfile = new File(path,"structs_config.xml");
		if(!(xmlfile.exists())){
			log.warn("can not find xml file");
			return ;
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlfile);
		Element root = doc.getDocumentElement(); //获取根元素
		log.info("root is :  "+root.getTagName());
		NodeList children = root.getChildNodes();
		for(int k =0 ;k < children.getLength(); k++){
			Node child = children.item(k);
			if(child instanceof Element)
				printXML(child);
		}
		
		printProperties();
		
	
	}
	
	private static void printXML(Node node)
	{
		if(!(node instanceof Element))
			return;
		log.info("==="+node.getNodeName());
		if(node.hasAttributes()){   //打印属性
			NamedNodeMap attributes = node.getAttributes();
			for(int i = 0 ; i < attributes.getLength(); i++){
				Node attribute = attributes.item(i);
				String name =  attribute.getNodeName();
				String value = attribute.getNodeValue();
				log.info("======"+name + " = " + value);
			}
		}
		if(node.hasChildNodes()){   //遍历子元素
			NodeList childList = node.getChildNodes();
			for(int j = 0; j < childList.getLength(); j++){
				Node child = childList.item(j);
				if(child instanceof Element)
					printXML(child);
			}
		}
	}
	
	private static void printProperties()
	{
		System.out.println("java_vendor:" + System.getProperty("java.vendor"));     
	    System.out.println("java_vendor_url:"     
	             + System.getProperty("java.vendor.url"));     
	    System.out.println("java_home:" + System.getProperty("java.home"));     
	    System.out.println("java_class_version:"     
	             + System.getProperty("java.class.version"));     
	    System.out.println("java_class_path:"     
	            + System.getProperty("java.class.path"));     
	    System.out.println("os_name:" + System.getProperty("os.name"));     
	    System.out.println("os_arch:" + System.getProperty("os.arch"));     
	    System.out.println("os_version:" + System.getProperty("os.version"));     
	    System.out.println("user_name:" + System.getProperty("user.name"));     
	    System.out.println("user_home:" + System.getProperty("user.home"));     
	    System.out.println("user_dir:" + System.getProperty("user.dir"));     
	    System.out.println("java_vm_specification_version:"     
	            + System.getProperty("java.vm.specification.version"));     
	    System.out.println("java_vm_specification_vendor:"     
	            + System.getProperty("java.vm.specification.vendor"));     
	    System.out.println("java_vm_specification_name:"     
	            + System.getProperty("java.vm.specification.name"));     
	    System.out.println("java_vm_version:"     
	            + System.getProperty("java.vm.version"));     
	    System.out.println("java_vm_vendor:"     
	            + System.getProperty("java.vm.vendor"));     
	    System.out     
	            .println("java_vm_name:" + System.getProperty("java.vm.name"));     
	    System.out.println("java_ext_dirs:"     
	            + System.getProperty("java.ext.dirs"));     
	    System.out.println("file_separator:"     
	            + System.getProperty("file.separator"));     
	    System.out.println("path_separator:"     
	            + System.getProperty("path.separator"));     
	    System.out.println("line_separator:"     
	            + System.getProperty("line.separator"));  
	}

}
