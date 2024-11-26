package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LectorClases {
    private static final String RUTA_JSON = "src/main/java/org/example/clases/clases.json";

    public static Personaje crearPersonaje(String clase, String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(RUTA_JSON));
            JsonNode datosClase = root.get(clase);

            if (datosClase == null) {
                throw new IllegalArgumentException("Clase no encontrada: " + clase);
            }

            int ataque = datosClase.get("ataque").asInt();
            int defensa = datosClase.get("defensa").asInt();
            double vidaMax = datosClase.get("vidaMax").asDouble();

            return new Personaje(nombre, ataque, defensa, vidaMax);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }
}