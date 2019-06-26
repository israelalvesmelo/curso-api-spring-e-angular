package com.example.algamoney.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.algamoney.api.AlgamoneyApiApplication;

public class ResourceUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceUtil.class);
	private static final String RESOURCES_PATH = ""; //"../../../../";
	
	public static String getResourceAbsolutePath(String filename) {
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResourceAbsolutePath() status=init");
		}
		String path = getResource(RESOURCES_PATH + filename).getFile();
		LOGGER.debug(path);
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResourceAbsolutePath() status=done");
		}
		return path;
	}
	
	public static URL getResource(String filename) {
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResource() status=init");
		}
		URL url = AlgamoneyApiApplication.class.getClassLoader().getResource(filename);
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResource() status=done");
		}
		return url;
	}
	
	public static InputStream getResourceAsStream(String filename) {
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResourceAsStream() status=init");
		}
		InputStream inputStream = AlgamoneyApiApplication.class.getClassLoader().getResourceAsStream(filename);
		if (LOGGER.isTraceEnabled()){
			LOGGER.trace("function=getResourceAsStream() status=done");
		}
		return inputStream;
	}
	
	public static String readXml(String fileXML) throws IOException {  
        String linha = "";  
        StringBuilder xml = new StringBuilder();  
  
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileXML))));  
        while ((linha = in.readLine()) != null) {  
            xml.append(linha);  
        }  
        in.close();  
  
        return xml.toString();  
    }  

}
