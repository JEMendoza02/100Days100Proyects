package com.day3.conversor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConversorController {
    @FXML
    private ComboBox<String> currencyOrigin;
    @FXML
    private ComboBox<String> currencyTarget;
    @FXML
    private TextField amountField;
    @FXML
    private TextField resultField;
    @FXML
    private Button btnClean;
    private final ConversorModel model = new ConversorModel();

    @FXML
    protected void onCleanButtonClick() {
        currencyOrigin.getSelectionModel().clearSelection();
        currencyTarget.getSelectionModel().clearSelection();
        amountField.setText("");
        resultField.setText("");
    }
    //Inicializa los valores por defecto de la interfaz
    public void initialize(){
        fillComboBoxes();
        setListeners();
    }
    private void fillComboBoxes(){
        ObservableList<String> opcionesDivisas = FXCollections.observableArrayList("USD","MXN","GBP");
        currencyOrigin.setItems(opcionesDivisas);
        currencyTarget.setItems(opcionesDivisas);
    }

    private void setListeners(){
        currencyOrigin.setOnAction(event -> convertCurrency());
        currencyTarget.setOnAction(event -> convertCurrency());
        amountField.setOnKeyReleased(event -> convertCurrency());
        btnClean.setOnAction(event -> onCleanButtonClick());
    }
    private void convertCurrency(){
        String monedaOrigen = currencyOrigin.getValue();
        String monedaDestino = currencyTarget.getValue();

        if(monedaOrigen != null && monedaDestino != null){
            try{
                double quantity = Double.parseDouble(amountField.getText());
                double result = model.converse(monedaOrigen, monedaDestino, quantity);
                resultField.setText(String.format("%.2f",result));
                resultField.getStyleClass().remove("error-field");
            }catch(NumberFormatException e){
                resultField.getStyleClass().add("error-field");
                resultField.setText("Error");
            }
        }
    }
}