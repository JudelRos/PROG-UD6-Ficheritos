package net.textwriter.actividad1;

import java.util.Scanner;

import net.textwriter.TextManager;

public class App1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String outputFilePath = "Actividad1/files/output/outputTextito.txt";
        TextManager manager = new TextManager("", outputFilePath);

        String inputTextito = "";
        while (true) {
            System.out.println("Introduce un texto (30 caracteres):");
            inputTextito = scanner.nextLine();

            if (inputTextito.length() >= 30) {
                break;
            } else {
                int caracteresRestantes = 30 - inputTextito.length();
                System.out.println("Escribe un texto mayor. Faltan " + caracteresRestantes + " caracteres");
            }
        }

        manager.processTextito(inputTextito);
        scanner.close();
    }
}
