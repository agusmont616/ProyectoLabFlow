package ucu.edu.aed.tda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        // ########## Ejercicio 19 ##########
        String rutaArchivo = "parentesis.txt";  // Archivo que contiene la secuencia de paréntesis a evaluar
        Pila<String> pila = new Pila<>(); // Creo la pila
        boolean esBalanceado = true;    // Bandera que determina si la secuencia es balanceada

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            
            int caracter;   // Variable para almacenar el código ASCII del carácter leído
            while ((caracter = br.read()) != -1){   // Lee el archivo carácter por carácter hasta el final del archivo
                String s = String.valueOf((char) caracter);// Convierte el código ASCII a un carácter y luego a una cadena

                if (s.equals("(")) {    
                    pila.mete(s);
                } else if (s.equals(")")) {
                    if (!pila.esVacio()) {
                        pila.saca();
                    } else {
                        System.out.println("El arreglo no es balanceado");
                        esBalanceado = false;
                        break;
                    }
                }

            }
        } catch (IOException e) { // Mensaje en caso de excepción
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }
        
        if (esBalanceado) { // Imprime un mensaje con el resultado
            if (pila.esVacio()) {
                System.out.println("Balanceado");
            } else {
                System.out.println("No balanceado");

            }
        }
}
}