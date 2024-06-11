import java.io.FileWriter;
import java.io.IOException;

public class TextManager {
    private String textito;
    private final String nombreFichero;

    public TextManager(String textito, String nombreFichero) {
        this.textito = textito;
        this.nombreFichero = nombreFichero;
    }

    public void processTextito(String inputTextito) {
        String textoEnFormato = formatearTexto(inputTextito);
        guardarTexto(textoEnFormato);
    }

    private String formatearTexto(String textito) {
        return textito.toUpperCase().replace(' ', '_');
    }

    private void guardarTexto(String textito) {
        try (FileWriter writer = new FileWriter(nombreFichero)) {
            writer.write(textito);
            System.out.println("Se ha guardado el texto en el fichero: " + nombreFichero);
        } catch (IOException e) {
            System.out.println("El texto no se pudo guardar en el fichero.");
            e.printStackTrace();
        }
    }
}
