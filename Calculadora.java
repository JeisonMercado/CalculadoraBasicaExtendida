/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caculadorabasicaextendida;

/**
 *
 * @author jeiso
 */
public class Calculadora {

    // Suma dos números
    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    // Resta dos números
    public double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    // Multiplica dos números
    public double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    // Divide dos números, validando que no se divida entre cero
    public double dividir(double numero1, double numero2) {
        if (numero2 == 0) {
            // Si el divisor es 0, lanzamos un error con mensaje claro
            throw new ArithmeticException("Error: no se puede dividir entre cero.");
        }
        return numero1 / numero2;
    }
}
