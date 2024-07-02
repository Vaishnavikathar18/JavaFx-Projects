package com.api.service;

import java.io.IOException;
import org.json.JSONObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class APIService extends Application {
    static String imgURL = "";
    public static void imageData() throws IOException{
        StringBuffer response = new DataUrls().getResponseData(); 
        if (response!=null){
            JSONObject obj = new JSONObject(response.toString());
            JSONObject urlobject = obj.getJSONObject("urls");
            imgURL=urlobject.getString("small");
        }else{
            System.out.println("Response is empty");
        }
    }

@Override
public void start(Stage primaryStage) throws Exception {
    imageData();
    Image image = new Image(imgURL);
    ImageView imageview = new ImageView(image);
    Pane imgpane = new Pane();
    imgpane.getChildren().add(imageview);
    Scene scene = new Scene(imgpane,image.getWidth(),image.getHeight());
    primaryStage.setScene(scene);
    primaryStage.setTitle("ImageView Example");
    primaryStage.show();
}
}
