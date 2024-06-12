package net.textwriter.actividad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String segundoTextoRuta = "Actividad1/files/input/inputTextito.txt";
        StringBuilder textoSegundoFichero = new StringBuilder();

        try (FileReader fileReader = new FileReader(segundoTextoRuta);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int character;
            while ((character = bufferedReader.read()) != -1) {
                if (textoSegundoFichero.length() > 0) {
                    textoSegundoFichero.append(", ");
                }
                textoSegundoFichero.append((char) character).append("_").append((int) character);
            }
            System.out.println(textoSegundoFichero.toString());
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + segundoTextoRuta);
            e.printStackTrace();
        }

        scanner.close();
    }
}
