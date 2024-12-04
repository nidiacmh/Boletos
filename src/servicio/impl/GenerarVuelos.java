package servicio.impl;

import modelo.Vuelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GenerarVuelos {
    private static final String[] CIUDADES = {
            "Ciudad de México", "Nueva York", "Los Ángeles", "París",
            "Tokio", "Madrid", "Berlín", "Londres",
            "Roma", "Buenos Aires", "Toronto", "Sidney",
            "Dubai", "Singapur", "Sao Paulo"
    };

    public static List<Vuelo> generarVuelosAleatorios() {
        List<Vuelo> vuelos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            String origen = CIUDADES[random.nextInt(CIUDADES.length)];
            String destino;
            do {
                destino = CIUDADES[random.nextInt(CIUDADES.length)];
            } while (origen.equals(destino)); // Asegura que el destino sea diferente al origen

            // Genera una fecha aleatoria dentro del próximo mes
            long ahora = System.currentTimeMillis();
            long unMesDespues = ahora + (30L * 24 * 60 * 60 * 1000);
            long fechaAleatoria = ahora + (long) (random.nextDouble() * (unMesDespues - ahora));
            Date fecha = new Date(fechaAleatoria);

            // Genera una disponibilidad aleatoria
            int disponibilidad = random.nextInt(191);

            Vuelo vuelo = new Vuelo(origen, destino, fecha, disponibilidad);
            vuelos.add(vuelo);
        }

        return vuelos;
    }


    public static Vuelo seleccionarVueloAleatorio(List<Vuelo> vuelos) {
        if (vuelos == null || vuelos.isEmpty()) {
            throw new IllegalArgumentException("La lista de vuelos está vacía o es nula.");
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(vuelos.size());
        return vuelos.get(indiceAleatorio);
    }
}
