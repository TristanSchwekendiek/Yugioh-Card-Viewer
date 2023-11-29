package com.example.comp1011assignment21207799;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CardController {
    @FXML
    private Label cardName;
    @FXML
    private Label cardLevel;
    @FXML
    private Label cardRace;
    @FXML
    private Label cardAttribute;
    @FXML
    private Label cardType;
    @FXML
    private Label cardAtk;
    @FXML
    private Label cardDef;
    @FXML
    private TextArea cardEffect;
    @FXML
    private ListView results;
    @FXML
    private TextField cardSearch;
    @FXML
    private ProgressBar progressBar;

    private ArrayList<LocalDateTime> apiCallTimes;

    private int totalNumOfCards, page;
    @FXML
    private void initialize() throws IOException, InterruptedException {
        System.out.println("initialized"); // Log the card being searched
        apiCallTimes = new ArrayList<>();
        progressBar.setVisible(false);
        searchYGO(null); // Call searchYGO method when a key is released
        // Adding a listener to the cardSearch TextField for key presses
        cardSearch.setOnKeyReleased(event -> {
            try {
                searchYGO(null); // Call searchYGO method when a key is released
            } catch (IOException | InterruptedException e) {
                e.printStackTrace(); // Handle exceptions appropriately
            }
        });
    }

    @FXML
    void searchYGO(ActionEvent event) throws IOException, InterruptedException {
        System.out.println("S"); // Log the card being searched
        String cardName = cardSearch.getText();
        clearOldTimeStamps();
        page = 1;
        if (!cardName.trim().isEmpty()) {
            apiCallTimes.add(LocalDateTime.now());
            if (apiCallTimes.size() < 20) {
                System.out.println("Searching for card: " + cardName); // Log the card being searched
                // Add more logging statements as needed for debugging purposes

                APIResponse apiResponse = APIUtility.searchCards(cardName.trim(), page);
                if (apiResponse != null) {
                    totalNumOfCards = Integer.parseInt(apiResponse.getTotalResults());
                    results.getItems().clear();
                    if (apiResponse.getCards() != null) {
                        results.getItems().addAll(apiResponse.getCards());
                        updateLabels();
                    }
                }
                else{
                    System.out.println("null");
                }
            }
        }
    }

    private void clearOldTimeStamps() {
    }
    private void updateLabels()
    {
    }

}