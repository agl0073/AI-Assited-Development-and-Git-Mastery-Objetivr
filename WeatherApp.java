package com.weather;

import java.util.Scanner;

/**
 * WeatherApp - Aplicación meteorológica de consola en Java.
 *
 * Permite al usuario consultar el clima simulado de distintas ciudades,
 * ver el historial de consultas y limpiar dicho historial.
 *
 * Desarrollado con asistencia de IA (Claude) como parte del proyecto
 * de control de versiones con Git.
 *
 * @author Proyecto Git - AI Pair Programming
 * @version 1.0
 */
public class WeatherApp {

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();
        WeatherHistory history = new WeatherHistory();

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   🌤  WEATHER APP v1.0 🌤    ║");
        System.out.println("╚══════════════════════════════╝");

        boolean running = true;

        // Bucle principal del menú
        while (running) {
            printMenu();
            System.out.print("Selecciona una opción: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    // Consultar el clima de una ciudad
                    System.out.print("Introduce el nombre de la ciudad: ");
                    String city = scanner.nextLine().trim();
                    WeatherData data = weatherService.getWeather(city);
                    printWeatherData(data);
                    history.addEntry(data); // Guardar en historial
                    break;

                case "2":
                    // Mostrar historial de consultas
                    history.printHistory();
                    break;

                case "3":
                    // Limpiar historial (funcionalidad añadida en feature-update)
                    history.clearHistory();
                    System.out.println("✅ Historial borrado correctamente.");
                    break;

                case "4":
                    // Salir de la aplicación
                    System.out.println("👋 ¡Hasta pronto! Cerrando Weather App...");
                    running = false;
                    break;

                default:
                    System.out.println("⚠️  Opción no válida. Por favor, elige entre 1 y 4.");
            }
        }

        scanner.close();
    }

    /**
     * Imprime el menú principal en consola.
     */
    private static void printMenu() {
        System.out.println("\n──────────────────────────────");
        System.out.println(" 1. 🔍 Consultar clima");
        System.out.println(" 2. 📋 Ver historial");
        System.out.println(" 3. 🗑️  Limpiar historial");
        System.out.println(" 4. 🚪 Salir");
        System.out.println("──────────────────────────────");
    }

    /**
     * Muestra los datos meteorológicos formateados en consola.
     *
     * @param data Objeto WeatherData con la información del clima.
     */
    private static void printWeatherData(WeatherData data) {
        System.out.println("\n┌─────────────────────────────┐");
        System.out.printf("│ 🌍 Ciudad : %-16s │%n", data.getCity());
        System.out.printf("│ 🌡️  Temp.  : %-3d°C              │%n", data.getTemperature());
        System.out.printf("│ 💧 Humedad: %-3d%%               │%n", data.getHumidity());
        System.out.printf("│ 🌬️  Viento : %-4d km/h           │%n", data.getWindSpeed());
        System.out.printf("│ ☁️  Estado : %-16s │%n", data.getCondition());
        System.out.println("└─────────────────────────────┘");
    }
}
