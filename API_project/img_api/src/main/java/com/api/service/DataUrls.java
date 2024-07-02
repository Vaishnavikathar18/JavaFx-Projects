package com.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataUrls {
    public StringBuffer getResponseData() throws IOException {
        
        String url = "https://api.unsplash.com/photos/random/?client_id=ufT7x6pU4D5GDQEHImjDWTI4KvU9nnd596NQY6ojYJo";

        
        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");

        int responseCode = httpClient.getResponseCode();
        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) {
          
            BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
           
            throw new RuntimeException("GET request failed with response code " + responseCode);
        }

        return response;
    }
}
