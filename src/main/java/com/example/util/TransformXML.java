package com.example.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.*;

/**
 * Created by dekanczuk on 14/03/2017.
 */
public class TransformXML {

    private static Map<String,String> xmlMap;

    static public Map<String,String> transformToMap(String xml){
        xml = Util.removeDust(xml);
        String rootName = xml.substring(1).split(" ")[0];
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new MapEntryConverter());
        xStream.alias(rootName, java.util.Map.class);
        Map<String, Object> mapper = (Map<String, Object>) xStream.fromXML(xml);

        xmlMap = new HashMap<>();
        getAllKeys(mapper.values(),null);
        return xmlMap;
    }

   static public void getAllKeys(Collection<Object> objects,String key){
        for(Object object : objects){
            if(object instanceof List){
                List<Object> listObjects = (List<Object>)object;
                getAllKeys(listObjects,key);
            }
            if(object instanceof HashMap){
                Map<String,Object> mapObject = (Map<String,Object>)object;
                getAllKeys(mapObject.values(),mapObject.keySet().iterator().next());
            }
            if(object instanceof String){
                xmlMap.put(key,object.toString());
            }
        }
    }


//    static private Map<String,Object> processMap_N(Collection<Object> objects, String toDo ,String key){
//        Map<String,String> finalMap = new HashMap<>();
//        for(Object object : objects){
//            if(object instanceof List){
//                List<Object> listObjects = (List<Object>)object;
//                processMap_N(listObjects,toDo,key);
//            }
//            if(object instanceof HashMap){
//                Map<String,Object> objectMap = (Map<String,Object>)object;
//                processMap_N(objectMap.values(),toDo,objectMap.keySet().iterator().next());
//
//                if(toDo.equals("delete") && objectMap.keySet().iterator().next().contains(key)){
//                    ((HashMap) object).clear();
//                }
//            }
//            if(object instanceof String){
//                //transformMap.put(key,object.toString());
//            }
//        }
//        return null;
//    }
}
