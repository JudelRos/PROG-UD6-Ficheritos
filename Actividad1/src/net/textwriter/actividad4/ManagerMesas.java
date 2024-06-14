package net.textwriter.actividad4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerMesas {
    private final String nombreFichero;

    public ManagerMesas(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void guardarMesa(Mesa mesa) {
        List<Mesa> mesas = listaMesas();
        mesas.add(mesa);

        try (ObjectOutputStream ficheroMesas = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            ficheroMesas.writeObject(mesas);
            System.out.println("Mesa guardada en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar la mesa en el fichero.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Mesa> listaMesas() {
        List<Mesa> mesas = new ArrayList<>();

        if (new File(nombreFichero).exists()) {
            try (ObjectInputStream streamMesitas = new ObjectInputStream(new FileInputStream(nombreFichero))) {
                mesas = (List<Mesa>) streamMesitas.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer las mesas del fichero.");
                e.printStackTrace();
            }
        }

        return mesas;
    }
}