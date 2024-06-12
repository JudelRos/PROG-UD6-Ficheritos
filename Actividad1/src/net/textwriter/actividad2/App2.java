import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import net.textwriter.TextManager;

public class App {
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
