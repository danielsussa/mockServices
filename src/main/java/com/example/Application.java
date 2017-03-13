package com.example;

import com.example.controller.MainController;
import com.example.entity.FileDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		final File folder = new File("toRead");
		Map<String,FileDTO> files = listFilesForFolder(folder);
		Map<String,String> requestMap = readAndStorageFiles(files);

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
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
		Map<String,String> mapRequestResponse = new HashMap<>();
		files.forEach((key,file)->{
			String requestPath = file.getRequestPath();
			String responsePath = file.getResponsePath();
			if(requestPath != null && responsePath != null){
				String request = read(requestPath);
				String response = read(responsePath);
				mapRequestResponse.put(request,response);
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
