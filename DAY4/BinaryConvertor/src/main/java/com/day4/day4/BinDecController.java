package com.day4.day4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class BinDecController {
        @FXML
        private TextField txt_dec;
        @FXML
        private TextField txt_bin;
        @FXML
        private Label lbl_dec;
        @FXML
        private Label lbl_bin;
        @FXML
        private Button btn_reset;

        @FXML
        private void initialize() {
                txt_dec.setOnKeyReleased(event -> handleConversionDecimalABinario());
                txt_bin.setOnKeyReleased(event -> handleConversionBinarioADecimal());
                btn_reset.setOnAction(event -> onResetButtonClick());
        }

        private void onResetButtonClick(){
                txt_bin.setText("");
                txt_dec.setText("");
        }

        private void handleConversionDecimalABinario() {
                try {
                        int decimal = Integer.parseInt(txt_dec.getText());
                        String binario = BinDecModel.decimalToBinary(decimal);
                        txt_bin.setText(binario);

                        // Restaurar el estilo si la conversión fue exitosa
                        txt_bin.getStyleClass().remove("error-field");
                } catch (NumberFormatException e) {
                        // Manejar la excepción si la entrada no es un número válido
                        txt_bin.setText("Error: valor ingresado no valido");

                        // Aplicar el estilo de campo de error
                        txt_bin.getStyleClass().add("error-field");
                }
        }

        private void handleConversionBinarioADecimal() {
                String binario = txt_bin.getText();
                int decimal = BinDecModel.binaryToDecimal(binario);
                if (decimal == -1) {
                        // Manejar el caso de una cadena binaria no válida
                        txt_dec.setText("Error: Cadena no valida");

                        // Aplicar el estilo de campo de error
                        txt_dec.getStyleClass().add("error-field");
                } else {
                        txt_dec.setText(Integer.toString(decimal));

                        // Restaurar el estilo si la conversión fue exitosa
                        txt_dec.getStyleClass().remove("error-field");
                }
        }
}



