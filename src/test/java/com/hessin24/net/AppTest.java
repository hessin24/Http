package com.hessin24.net;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class AppTest {

   private Http http;
    public AppTest(){
        try {
			http = new Http("https:ikiosk24.de");
			http.excutePost();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Test
    public void shouldAnswerWithTrue()
    {
    	String res = http.getResult();
    	boolean ifTrue = (res != null && res.length() > 2) : false;
        assertTrue( ifTrue );
    }



}