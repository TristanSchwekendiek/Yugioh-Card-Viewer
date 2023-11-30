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


    public static YugiohDetails[] getCardDetails(String ygoID) throws IOException, InterruptedException {
        // Formats the ID so it can be properly searched
        ygoID = ygoID.trim().replaceAll(" ","%20");

        //Sets the String Url to be that of the yugioh API
        String uri = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=" + ygoID;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //This will save the json response to a HttpResponse object
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body()); //Displays the raw json file in the console


        Gson gson = new Gson();
        YugiohDataResponse dataResponse = gson.fromJson(response.body(), YugiohDataResponse.class); //Saves as data response class to un-nest the data so that it can be accessed by YugiohDetials

        if (dataResponse != null) {
            return dataResponse.getCardDetails();
        } else {
            return null;
        }
    }
    public static APIResponse getCardsFromFile(String fileName)
    {
        //Creates the new GSON object
        Gson gson = new Gson();

        //Creates APIresponse variable
        APIResponse apiResponse = null;

        //Opens the file and passes it into the Gson object to covert JSON objects to Java objects
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
}

