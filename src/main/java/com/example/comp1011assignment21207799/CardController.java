package com.example.comp1011assignment21207799;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CardController {

    @FXML
    private Label errorMsg;
    @FXML
    private ImageView imgCard;
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
    private TextField cardSearch;
    @FXML
    private Button btnSearch;

    @FXML
    private void initialize() {
        errorMsg.setVisible(false);
    }

    @FXML
    void searchYGO(ActionEvent event) {
        try {
            //Retrieve the entered card name from the search bar
            String cardName = cardSearch.getText();

            //Retrieve Yugioh card details using an API utility
            YugiohDetails[] cardDetails = APIUtility.getCardDetails(cardName);

            //If the cardDetails is not null, it prints some debugging infomation and sets the errorMsg label to not be visible
            if (cardDetails != null) {
                    errorMsg.setVisible(false);
                    System.out.println("Received Card Details:");
                    System.out.println("Name: " + cardDetails[0].getName());
                    System.out.println("Level: " + cardDetails[0].getLevel());
                    updateLabels(cardDetails[0]); //calls updateLabels
            } else {
                errorMsg.setVisible(true); //Sets the error message to be visible if no card is found
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateLabels(YugiohDetails cardDetails) throws IOException, InterruptedException {
        //Gets card image
        List<CardImage> cardImage = cardDetails.getCardImages();
        String imageUrl = cardImage.get(0).getUrl();
        //provided the details are not null, the labels are updated to display the card information
        if (cardDetails != null) {
            cardName.setText("Name:" + cardDetails.getName());
            cardLevel.setText("Level:" +cardDetails.getLevel());
            cardRace.setText("Type:" +cardDetails.getRace());
            cardAttribute.setText("Attribute:" +cardDetails.getAttribute());
            cardType.setText("Card Type:" +cardDetails.getType());
            cardAtk.setText("Atk:" +cardDetails.getAtk());
            cardDef.setText("Def:" +cardDetails.getDef());
            cardEffect.setText(cardDetails.getEffect());
            imgCard.setImage(loadImage(imageUrl));//Calls loadImage to get the card url
        }
    }

    //Converts the image URL to an actual image that can be loaded
    private Image loadImage(String imageUrl) throws MalformedURLException {
        System.out.println(imageUrl);
        URL url = new URL(imageUrl);
        try {
            InputStream stream = url.openStream();
            return new Image(stream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}