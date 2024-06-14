package net.textwriter.actividad4;

import java.util.List;
import java.util.Scanner;

public class App4 {
    public static void main(String[] args) {
        ManagerMesas mesaManager = new ManagerMesas("mesas.dat");
        Scanner SC = new Scanner(System.in);
        final String MENU = """
                ***** Bienvenido al creador de mesas oficial de mi casa *****
                --SELECCIONA UNA OPCIÓN--
                1.- Crear nueva mesa
                2.- Mostrar lista de mesas
                3.- Salir
                """;

        boolean continuar = true;

        while (continuar) {
            System.out.println(MENU);
            String eleccionMenu = SC.nextLine();

            switch (eleccionMenu) {
                case "1":
                    System.out.println("De qué color es su nueva mesa.");
                    String colorMesa = SC.nextLine();
                    System.out.println("Cuántas patas tiene su mesa");
                    int patasMesa = SC.nextInt();
                    SC.nextLine();
                    Mesa nuevaMesa = new Mesa(colorMesa, patasMesa);
                    mesaManager.guardarMesa(nuevaMesa);
                    System.out.println("Mesa creada y guardada: " + nuevaMesa);
                    break;

                case "2":
                    List<Mesa> todasLasMesas = mesaManager.listaMesas();
                    if (todasLasMesas.isEmpty()) {
                        System.out.println("No hay mesas guardadas.");
                    } else {
                        System.out.println("Lista de mesas guardadas:");
                        for (Mesa mesa : todasLasMesas) {
                            System.out.println(mesa);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Saliendo del programa.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                    break;
            }
        }
        SC.close();
    }
}
