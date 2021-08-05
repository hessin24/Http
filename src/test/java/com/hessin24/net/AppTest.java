package com.hessin24.net;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class AppTest {

   private String res;
    public AppTest(){
        try {
			Http http = new Http("https:ikiosk24.de");
			http.excutePost();
		res = http.getResult();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Test
    public void shouldAnswerWithTrue()
    {
    	boolean ifTrue = res != null && res.length() > 2;
        assertTrue( ifTrue );
    }



}
