package com.example;

import com.example.util.TransformXML;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.util.*;

public class DemoApplicationTests {
	//mockRepository/test.txt

	XStream xStream = new XStream(new DomDriver());

	@Test
	public void context_2(){
		String xml = Application.read("C:/Ambientes_Inteli/mockServices/mockRepository/MESA-TRIAGEM/processUserLoginBackoffice_request.xml");
		TransformXML.transformToMap(xml);
	}

	public List<String> getAllKeys(Collection<Object> objects){
		for(Object object : objects){
			if(object instanceof List){
				List<Object> listObjects = (List<Object>)object;
				getAllKeys(listObjects);
			}
			if(object instanceof HashMap){
				Map<String,Object> listObjects = (Map<String,Object>)object;
				getAllKeys(listObjects.values());
			}
			if(object instanceof String){
				System.out.println(object.toString());
			}
		}
		return null;
	}

	@Test
	public void main(){
		Map<String,String> map1 = new HashMap<>();
		Map<String,String> map2 = new HashMap<>();
		map1.put("ola","daniel");
		map1.put("amor","amigos");
		map2.put("amor","amigos");
		map2.put("ola","daniel");
		System.out.println(map1.equals(map2));
	}

}
