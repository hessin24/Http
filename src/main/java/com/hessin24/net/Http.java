package com.hessin24.net;

import java.io.BufferedInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import com.hessin.annotation.NotNull;
public class Http {

    private URLConnection connection;
    private IStreamReader reader;
    public Http(@NotNull URLConnection connection){
        connection.setRequestProperty("userAgent", "Mozilla/5.0 (Java; Oracle; rv:87.0) Gecko/20210401 HessinBot/1.0");
        connection.setRequestProperty("copyright", "Kheri Nassir");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        this.connection = connection;
    }

    public Http(@NotNull String url) throws MalformedURLException, IOException{
        this(new URL(url).openConnection());
    }
    public Http excutePost() throws IOException {

        if (this.connection != null) {
            InputStream iStream = this.connection.getInputStream();
            reader = new IStreamReader(iStream);
        }
        return this;

    }

    public String getResult() {
        return reader != null? reader.toString():null;
    }



    public void setOnGetResultListener(OnGetResultListener listener) throws IOException {
        String builder = getResult();
        if (listener != null && builder != null) {
            listener.onGetResult(builder);
        }
    }

    public IStreamReader getReader() throws IOException {
        return reader;
    }

    public interface OnGetResultListener{
        public void onGetResult(String resultString);
    }
    public class IStreamReader {
        private BufferedReader bufferedReader;
        public  IStreamReader(InputStream stream){
            bufferedReader =  new BufferedReader( new InputStreamReader(new BufferedInputStream(stream)));

        }

        public BufferedReader getBufferedReader() {
            return bufferedReader;
        }
        public StringBuilder getResult() throws IOException {
            StringBuilder builder = new StringBuilder();
            String line = null;

            if (bufferedReader != null) {
                while((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }
                bufferedReader.close();
            }
            return builder;
        }
        public String toString() {


            try {
                return getResult().toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            return null;

        }
    }

}