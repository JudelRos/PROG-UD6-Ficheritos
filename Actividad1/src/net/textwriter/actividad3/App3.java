package net.textwriter.actividad3;

import net.textwriter.TextManager;

public class App3 {
    public static void main(String[] args) {
        // Especifica las rutas completas de los archivos
        String rutaArchivo1 = "Actividad1/files/output/outputTextito.txt";
        String rutaArchivo2 = "Actividad1/files/input/inputTextitoMerge.txt";

        // Crea instancias de TextManager para cada archivo con sus respectivas rutas
        TextManager textManager1 = new TextManager(rutaArchivo1);
        TextManager textManager2 = new TextManager(rutaArchivo2);

        // Lee contenido de cada archivo
        String contenidoArchivo1 = textManager1.leerYObtenerTexto(rutaArchivo1);
        String contenidoArchivo2 = textManager2.leerYObtenerTexto(rutaArchivo2);

        // Concatenar contenido de ambos archivos
        String contenidoConcatenado = "-Contenido del fichero 1: " + contenidoArchivo1 + "\n"
                + "- Contenido del fichero 2: " + contenidoArchivo2 + "\n" + "Hecho por Julio del Rosario";

        // Guardar el contenido concatenado en un nuevo archivo
        TextManager textManagerNuevo = new TextManager(
                "Actividad1/files/output/outputTextitoMerge.txt");
        textManagerNuevo.guardarTexto(contenidoConcatenado);
    }
}