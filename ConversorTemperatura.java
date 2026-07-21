/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caculadorabasicaextendida;

/**
 *
 * @author jeiso
 */
public class ConversorTemperatura {

    // Convierte de Fahrenheit a Celsius
    public double fahrenheitACelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    // Convierte de Celsius a Fahrenheit
    public double celsiusAFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }
}
