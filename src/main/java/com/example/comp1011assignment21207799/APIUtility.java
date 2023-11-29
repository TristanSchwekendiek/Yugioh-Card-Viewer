package com.example.comp1011assignment21207799;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class APIUtility {

    public static APIResponse searchCards(String cardName, int page) throws IOException, InterruptedException {
        //use the replaceAll method to replace a space with %20
        cardName = cardName.replaceAll(" ","%20");

        String uri = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + cardName;

        //configure the environment to make an HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save the json response to a file call movies.json
//        HttpResponse<Path> httpResponse = client.send(httpRequest,
//                                        HttpResponse.BodyHandlers.ofFile(Paths.get("movies.json")));

        //this will save the json response to a HttpResponse object
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        //Update the pom.xml file for GSON and update module-info.java to work with GSON
        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);

    }

    public static YugiohDetails getCardDetails(String ygoID) throws IOException, InterruptedException {
        //use the replaceAll method to replace a space with %20
        ygoID = ygoID.trim().replaceAll(" ","%20");

        String uri = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + ygoID;

        //configure the environment to make a HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this will save the json response to a file call movies.json
        //this will save the json response to a HttpResponse object
        HttpResponse<String> response = client.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        //Update the pom.xml file for GSON and update module-info.java to work with GSON
        Gson gson = new Gson();
        return gson.fromJson(response.body(), YugiohDetails.class);
    }

    /**
     * This method will read from "movies.json" and create an APIResponse object
     */
    public static APIResponse getCardsFromFile(String fileName)
    {
        //Create a GSON object.  GSON is the Google library that can read and write
        //JSON
        //in order to use this library, we need to update the pom.xml and module-info.java
        //files.  Don't forget to reload the Maven dependencies
        Gson gson = new Gson();

        APIResponse apiResponse = null;

        //open the file and pass it into the Gson object to covert JSON objects
        //to Java objects
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public static YugiohCard[] getCardArrayFromFile(String fileName)
    {
        //Create a GSON object.  GSON is the Google library that can read and write
        //JSON
        //in order to use this library, we need to update the pom.xml and module-info.java
        //files.  Don't forget to reload the Maven dependencies
        Gson gson = new Gson();

        APIResponse apiResponse = null;

        //open the file and pass it into the Gson object to covert JSON objects
        //to Java objects
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            return gson.fromJson(jsonReader, YugiohCard[].class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

