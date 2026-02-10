package com.example.currencyconverter;

import java.lang.Math;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML private TextField amountField;
    @FXML private Label resultLabel;
    @FXML ComboBox<String> convertfrom, convertto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        convertfrom.setItems(FXCollections.observableArrayList("USD","EUR","GBP","JPY","KES","ZAR"));
        convertto.setItems(FXCollections.observableArrayList("USD","EUR","GBP","JPY","KES","ZAR"));

        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.79);
        exchangeRates.put("JPY", 148.12);
        exchangeRates.put("KES", 132.50);
        exchangeRates.put("ZAR", 18.95);

        var currencies = FXCollections.observableArrayList(exchangeRates.keySet());
        convertfrom.setItems(currencies);
        convertto.setItems(currencies);
    }

    @FXML
    void getComboBoxInfo(ActionEvent event) {
        System.out.println(convertfrom.getValue());
        System.out.println(convertto.getValue());
    }

    private Map<String, Double> exchangeRates = new HashMap<>();

    @FXML
    private void performConversion(ActionEvent event) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            double fromrate = exchangeRates.get(convertfrom.getValue());
            double torate = exchangeRates.get(convertto.getValue());

            double result = amount * (torate / fromrate);
            resultLabel.setText(String.format("Result : %.2f", result));
        } catch (Exception e) {
            resultLabel.setText("Error : Check inputs");
        }
    }
}
