package com.day4.day4;

public final class BinDecModel {
    private BinDecModel() {
        // Constructor privado para evitar instanciaciones.
    }
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static int binaryToDecimal(String binario) {
        try {
            return Integer.parseInt(binario, 2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}



