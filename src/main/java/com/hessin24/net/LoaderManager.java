package com.hessin24.net;

import java.io.IOException;

public class LoaderManager {

    private Http http;
    public LoaderManager(String url){
        try {
            this.http = new Http(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ImagesLoader(){

    }


    public  void PageLoader(){
        if (this.http != null) {
            try {
                http.excutePost();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface OnPageLoadListener{
        default void onPageLoad(){

        }
    }
    public interface OnDataLoadListener{
        default void onImagesLoad(){

        }
    }
}