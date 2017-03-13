package com.example;

import com.example.controller.MainController;
import com.example.entity.FileDTO;
import com.example.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
@PropertySource("file:mock.properties")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		final File folder = new File("mockRepository");
		Map<String,FileDTO> files = listFilesForFolder(folder);
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Map<String,String> requestMap = readAndStorageFiles(files);
		context.getBean(MainController.class).setRequestMap(requestMap);

	}

	static public Map<String,FileDTO> listFilesForFolder(final File folder) {
		Map<String,FileDTO> mapList = new HashMap<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				return listFilesForFolder(fileEntry);
			} else {
				String[] strSplitted = fileEntry.getName().split("_|\\.");
				String name = strSplitted[0];
				String type = strSplitted[1];
				String path = fileEntry.getPath();
				if(type.equals("request")){
					if(mapList.containsKey(name)){
						mapList.get(name).setRequestPath(path);
					}else {
						FileDTO fileDTO = new FileDTO();
						fileDTO.setRequestPath(path);
						mapList.put(name,fileDTO);
					}
				}
				if(type.equals("response")){
					if(mapList.containsKey(name)){
						mapList.get(name).setResponsePath(path);
					}else {
						FileDTO fileDTO = new FileDTO();
						fileDTO.setResponsePath(path);
						mapList.put(name,fileDTO);
					}
				}

			}
		}
		return mapList;
	}

	static public Map<String,String> readAndStorageFiles(Map<String,FileDTO> files){
		System.out.println("SERVICES LOADED:");
		Map<String,String> mapRequestResponse = new HashMap<>();
		files.forEach((key,file)->{
			String requestPath = file.getRequestPath();
			String responsePath = file.getResponsePath();
			if(requestPath != null && responsePath != null){
				String request = Util.regexAll(read(requestPath));
				String response = read(responsePath);
				mapRequestResponse.put(request,response);
				System.out.println("-"+key);
			}
		});
		return mapRequestResponse;
	}

	static public String read(String file){
		StringBuilder message = new StringBuilder();
		try {
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String msg = "";
			while ((msg = inputStream.readLine()) != null){
				message.append(msg);
			}
			return message.toString();
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}


}
