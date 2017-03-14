package com.example;

import com.example.entity.Mapper;
import com.example.util.MapEntryConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DemoApplicationTests {
	//mockRepository/test.txt


	@Test
	public void context_2(){
		String xml = Application.read("mockRepository/MESA-TRIAGEM/AutenticarUsuario_response.txt");
		XStream xStream = new XStream(new DomDriver());
		xStream.registerConverter(new MapEntryConverter());
		xStream.alias("soapenv:Envelope", java.util.Map.class);
		Map<String, List<Object>> map1 = (Map<String, List<Object>>) xStream.fromXML(xml);

		getAllKeys(map1.get("soapenv:Envelope"));
	}

	public List<String> getAllKeys(List<Object> objects){
		for(Object object : objects){
			Map<String,Object> mapObj = (Map<String,Object>)object;
			if(!mapObj.isEmpty()){
				List<Object> val = (List<Object>)mapObj.values();
				getAllKeys(val);
			}
		}
		if(objects.size() > 0 ){
			getAllKeys(objects);
		}else {
			System.out.println("ola");
		}
		return null;
	}

}
