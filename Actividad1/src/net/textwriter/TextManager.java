package net.textwriter;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TextManager {

    private final String nombreFichero;

    public TextManager(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void processTextito(String inputTextito) {
        String textoEnFormato = formatearTexto(inputTextito);
        guardarTexto(textoEnFormato);
    }

    private String formatearTexto(String textito) {
        return textito.toUpperCase().replace(' ', '_');
    }

    public void guardarTexto(String textito) {
        File file = new File(nombreFichero);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(textito);
            System.out.println("Se ha guardado el texto en el fichero: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("El texto no se pudo guardar en el fichero.");
            e.printStackTrace();
        }
    }

    public void leerYMostrarTexto(String nombreFichero) {
        try (FileReader reader = new FileReader(nombreFichero);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            int character;
            StringBuilder output = new StringBuilder();
            while ((character = bufferedReader.read()) != -1) {
                if (output.length() > 0) {
                    output.append(", ");
                }
                output.append((char) character).append("_").append((int) character);
            }
            System.out.println(output.toString());
        } catch (IOException e) {
            System.out.println("El texto no funchiona.");
            e.printStackTrace();
        }
    }

    public String leerYObtenerTexto(String nombreFichero) {
        StringBuilder contenido = new StringBuilder();
        try (FileReader reader = new FileReader(nombreFichero);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            int character;
            while ((character = bufferedReader.read()) != -1) {
                contenido.append((char) character);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
            e.printStackTrace();
        }
        return contenido.toString();
    }
}
