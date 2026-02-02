package com.example.currencyconverter;

import java.lang.Math;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML ComboBox<String> convertfrom, convertto;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        convertfrom.setItems(FXCollections.observableArrayList("USD, EUR, GBP, JPY, KES, ZAR"));
        convertto.setItems(FXCollections.observableArrayList("USD, EUR, GBP, JPY, KES, ZAR"));
    }

    @FXML
    void getComboBoxInfo(ActionEvent event) {
        System.out.println(convertfrom.getValue());
        System.out.println(convertto.getValue());
    }

    private Map<String, Double> exchangeRates = new HashMap<>();

    @FXML
    public void initialize() {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.79);
        exchangeRates.put("JPY", 148.12);
        exchangeRates.put("KES", 132.50); // Kenyan Shilling example
        exchangeRates.put("ZAR", 18.95);
    }
}
