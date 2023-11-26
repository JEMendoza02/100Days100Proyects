package com.day3.conversor;

public class ConversorModel {
    private static final double USD2MXN = 17.12;
    private static final double USD2GBP = 0.79;
    private static final double MXN2USD = 0.058;
    private static final double MXN2GBP = 0.046;
    private static final double GBP2USD = 1.26;
    private static final double GBP2MXN = 21.57;

    public double converse(String currencyOrigin, String currencyTarget, double quantity){
        double exchangeRate = getExchangeRate(currencyOrigin, currencyTarget);
        return quantity * exchangeRate;
    }

    public double getExchangeRate(String currencyOrigin, String currencyTarget){
        return switch (currencyOrigin) {
            case "USD" -> switch (currencyTarget) {
                case "USD" -> 1.0;
                case "MXN" -> USD2MXN;
                case "GBP" -> USD2GBP;
                default -> 1.0;
            };
            case "MXN" -> switch (currencyTarget) {
                case "USD" -> MXN2USD;
                case "MXN" -> 1.0;
                case "GBP" -> MXN2GBP;
                default -> 1.0;
            };
            case "GBP" -> switch (currencyTarget) {
                case "USD" -> GBP2USD;
                case "MXN" -> GBP2MXN;
                case "GBP" -> 1.0;
                default -> 1.0;
            };
            default -> 1.0;
        };
    }
}
