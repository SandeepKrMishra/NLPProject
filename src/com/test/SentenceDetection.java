package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetection {
  void sentenceDetection(String path) throws IOException {
	
	String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
	  
    InputStream modelIn = new FileInputStream("/home/sandeep/RWORK/nlp-sandeep/src/bin/en-sent.bin");
		
    SentenceModel model = new SentenceModel(modelIn);
		
	SentenceDetectorME sentencedetector = new SentenceDetectorME(model);
		
	//String sentences[] = sentencedetector.sentDetect(" Hello HKHR. How are you? ");
	String sentences[] = sentencedetector.sentDetect(content);
	
	for(String strSen : sentences){
	  System.out.println(strSen);
	}
		
  }
  
  public static List<String> sentenceDetection2(String content) throws IOException {
		
	  List<String> sentList = new ArrayList();
	  
	    InputStream modelIn = new FileInputStream("/home/sandeep/sandeep/RWORK/nlp-sandeep/src/bin/en-sent.bin");
			
	    SentenceModel model = new SentenceModel(modelIn);
			
		SentenceDetectorME sentencedetector = new SentenceDetectorME(model);
			
		//String sentences[] = sentencedetector.sentDetect(" Hello HKHR. How are you? ");
		String sentences[] = sentencedetector.sentDetect(content);
		
		for(String strSen : sentences){
		  sentList.add(strSen);
		}
			
		return sentList;
  }
}
