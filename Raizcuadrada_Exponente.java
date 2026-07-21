/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caculadorabasicaextendida;

/**
 *
 * @author jeiso
 */
public class Raizcuadrada_Exponente {

    // Calcula la raíz cuadrada de un número
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            // No existe raíz cuadrada real de un número negativo
            throw new ArithmeticException("Error: no se puede sacar raíz de un número negativo.");
        }
        return Math.sqrt(numero);
    }

    // Calcula base elevado a exponente
    public double calcularExponente(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
