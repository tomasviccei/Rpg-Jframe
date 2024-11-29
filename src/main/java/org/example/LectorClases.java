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
            // Cargar el archivo JSON que contiene el arreglo de clases
            JsonNode root = mapper.readTree(new File(RUTA_JSON));

            // Recorrer el arreglo de clases
            for (JsonNode datosClase : root) {
                // Comparar el nombre de la clase con el campo "nombre" de cada objeto en el JSON
                if (datosClase.get("nombre").asText().equalsIgnoreCase(clase)) {

                    int ataque = datosClase.get("ataque").asInt();
                    int defensa = datosClase.get("defensa").asInt();
                    double vidaMax = datosClase.get("vidaMax").asDouble();
                    double manaMax = datosClase.get("manaMax").asDouble();
                    String habilidadEspecial = datosClase.get("habilidadEspecial").asText();
                    int costoManaHabilidad = datosClase.get("costoManaHabilidad").asInt();

                    // Crear y devolver el personaje con los datos obtenidos
                    return new Personaje(nombre, ataque, defensa, vidaMax, manaMax, habilidadEspecial, costoManaHabilidad);
                }
            }

            // Si no se encuentra la clase, lanzar una excepción
            throw new IllegalArgumentException("Clase no encontrada: " + clase);

        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }
}