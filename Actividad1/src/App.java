import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        TextManager manager = new TextManager("", "textito_guardado.txt");

        String inputTextito = "";
        while (true) {
            System.out.println("Introduce un texto (30 caracteres):");
            inputTextito = SC.nextLine();

            if (inputTextito.length() >= 30) {
                break;
            } else {
                int caracteresRestantes = 30 - inputTextito.length();
                System.out.println("Escribe un texto mayor. Faltan " + caracteresRestantes + " caracteres");
            }
        }

        manager.processTextito(inputTextito);
        SC.close();
    }
}
