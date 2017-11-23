package com.qianjin.java.soa.xml;

import java.io.File;
import java.io.*;

import javax.xml.bind.*;
import javax.xml.transform.stream.*;

import org.apache.commons.io.FileUtils;


public class SimpleJAXB2 {

	public static void main(String[] args) {
		try {
			JAXBContext jcon = JAXBContext.newInstance("com.qianjin.java.soa.xml");
			Unmarshaller unmarshaller = jcon.createUnmarshaller();
			String xml = FileUtils.readFileToString(new File("C:/work/getHSR/res.xml"), "utf-8");
			StreamSource stream = new StreamSource(new StringReader(xml));
			GetHSRDetailsResponse hsr = (GetHSRDetailsResponse)unmarshaller.unmarshal(stream);
            System.out.println("rrr");
			
			System.out.println(hsr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
