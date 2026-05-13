package com.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherHistory - Historial de consultas meteorológicas.
 *
 * Almacena en memoria todas las consultas realizadas durante la sesión
 * actual. Permite imprimir el historial y borrarlo.
 *
 * Nota: La funcionalidad de limpieza (clearHistory) fue añadida
 *       en la rama 'feature-update' como mejora del proyecto original.
 */
public class WeatherHistory {

    /** Lista interna de consultas realizadas. */
    private final List<WeatherData> entries;

    /**
     * Constructor: inicializa la lista vacía.
     */
    public WeatherHistory() {
        entries = new ArrayList<>();
    }

    /**
     * Añade una nueva consulta al historial.
     *
     * @param data Datos meteorológicos de la consulta a registrar.
     */
    public void addEntry(WeatherData data) {
        entries.add(data);
    }

    /**
     * Imprime en consola todas las consultas almacenadas.
     * Si el historial está vacío, lo notifica al usuario.
     */
    public void printHistory() {
        if (entries.isEmpty()) {
            System.out.println("\n📭 El historial está vacío. Realiza al menos una consulta.");
            return;
        }

        System.out.println("\n📋 ── HISTORIAL DE CONSULTAS ──────────────────");
        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("  %2d. %s%n", i + 1, entries.get(i).toString());
        }
        System.out.println("────────────────────────────────────────────");
        System.out.printf("  Total de consultas: %d%n", entries.size());
    }

    /**
     * Elimina todas las entradas del historial.
     *
     * Esta función fue incorporada en la rama 'feature-update'
     * como mejora de usabilidad durante la práctica Git.
     */
    public void clearHistory() {
        entries.clear();
    }

    /**
     * Retorna el número de consultas registradas en el historial.
     *
     * @return Tamaño actual del historial.
     */
    public int size() {
        return entries.size();
    }
}
