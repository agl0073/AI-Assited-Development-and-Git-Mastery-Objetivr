package com.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * WeatherService - Servicio de consulta meteorológica.
 *
 * Simula una fuente de datos climáticos para ciudades predefinidas.
 * Si la ciudad no está en la base de datos, genera valores aleatorios
 * para que la aplicación siempre devuelva una respuesta.
 *
 * En una versión de producción, este servicio podría integrarse con
 * una API real como OpenWeatherMap o WeatherAPI.
 */
public class WeatherService {

    /**
     * Base de datos en memoria con datos meteorológicos típicos
     * de ciudades conocidas. Clave: nombre en minúsculas.
     */
    private final Map<String, WeatherData> weatherDatabase;

    /** Generador de números aleatorios para ciudades desconocidas. */
    private final Random random;

    /**
     * Constructor: inicializa la base de datos con ciudades de ejemplo.
     */
    public WeatherService() {
        weatherDatabase = new HashMap<>();
        random = new Random();
        populateDatabase();
    }

    /**
     * Carga los datos meteorológicos de muestra para ciudades conocidas.
     */
    private void populateDatabase() {
        // Ciudades españolas
        weatherDatabase.put("madrid",    new WeatherData("Madrid",    28, 35, 15, "Soleado"));
        weatherDatabase.put("barcelona", new WeatherData("Barcelona", 26, 65, 20, "Parcialmente nublado"));
        weatherDatabase.put("sevilla",   new WeatherData("Sevilla",   34, 25, 10, "Despejado"));
        weatherDatabase.put("zaragoza",  new WeatherData("Zaragoza",  24, 40, 30, "Viento fuerte"));
        weatherDatabase.put("valencia",  new WeatherData("Valencia",  27, 70, 18, "Nublado"));

        // Ciudades internacionales
        weatherDatabase.put("london",    new WeatherData("London",    14, 80, 25, "Lluvioso"));
        weatherDatabase.put("paris",     new WeatherData("Paris",     18, 70, 20, "Nublado"));
        weatherDatabase.put("tokyo",     new WeatherData("Tokyo",     22, 75, 15, "Despejado"));
        weatherDatabase.put("new york",  new WeatherData("New York",  20, 60, 22, "Parcialmente nublado"));
        weatherDatabase.put("sydney",    new WeatherData("Sydney",    16, 55, 28, "Lluvias ligeras"));
    }

    /**
     * Devuelve los datos meteorológicos de la ciudad indicada.
     *
     * Si la ciudad existe en la base de datos, retorna sus datos reales.
     * En caso contrario, genera datos aleatorios para esa ciudad.
     *
     * @param city Nombre de la ciudad (no sensible a mayúsculas).
     * @return     Objeto WeatherData con la información del clima.
     */
    public WeatherData getWeather(String city) {
        String key = city.toLowerCase().trim();

        if (weatherDatabase.containsKey(key)) {
            // Ciudad encontrada: devolver datos conocidos
            return weatherDatabase.get(key);
        }

        // Ciudad desconocida: generar datos aleatorios realistas
        return generateRandomWeather(city);
    }

    /**
     * Genera un objeto WeatherData con valores aleatorios dentro de rangos realistas.
     *
     * @param city Nombre de la ciudad para la que se generan datos.
     * @return     WeatherData con temperatura, humedad y viento aleatorios.
     */
    private WeatherData generateRandomWeather(String city) {
        // Rangos realistas: temperatura 5-35°C, humedad 20-90%, viento 5-60 km/h
        int temperature = 5  + random.nextInt(31);
        int humidity    = 20 + random.nextInt(71);
        int windSpeed   = 5  + random.nextInt(56);

        // Seleccionar condición aleatoria
        String[] conditions = {
            "Soleado", "Nublado", "Lluvioso",
            "Tormenta", "Despejado", "Niebla"
        };
        String condition = conditions[random.nextInt(conditions.length)];

        // Capitalizar nombre de ciudad correctamente
        String formattedCity = formatCityName(city);

        System.out.println("ℹ️  Ciudad no encontrada en la base de datos. Mostrando datos estimados.");
        return new WeatherData(formattedCity, temperature, humidity, windSpeed, condition);
    }

    /**
     * Capitaliza la primera letra de cada palabra en el nombre de la ciudad.
     *
     * @param city Nombre de ciudad en cualquier formato.
     * @return     Nombre formateado con primera letra en mayúscula.
     */
    private String formatCityName(String city) {
        StringBuilder formatted = new StringBuilder();
        for (String word : city.trim().split("\\s+")) {
            if (!word.isEmpty()) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
            }
        }
        return formatted.toString().trim();
    }
}
