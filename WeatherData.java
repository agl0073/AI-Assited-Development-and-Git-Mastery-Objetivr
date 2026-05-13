package com.weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * WeatherData - Modelo de datos meteorológicos.
 *
 * Representa la información climática de una ciudad en un instante
 * determinado, incluyendo temperatura, humedad, velocidad del viento
 * y condición general del tiempo.
 */
public class WeatherData {

    /** Nombre de la ciudad consultada. */
    private final String city;

    /** Temperatura en grados Celsius. */
    private final int temperature;

    /** Porcentaje de humedad relativa (0-100). */
    private final int humidity;

    /** Velocidad del viento en km/h. */
    private final int windSpeed;

    /** Descripción textual de la condición meteorológica. */
    private final String condition;

    /** Marca de tiempo en la que se realizó la consulta. */
    private final LocalDateTime timestamp;

    /**
     * Constructor completo de WeatherData.
     *
     * @param city        Nombre de la ciudad.
     * @param temperature Temperatura en °C.
     * @param humidity    Humedad en %.
     * @param windSpeed   Velocidad del viento en km/h.
     * @param condition   Condición meteorológica (ej. "Soleado").
     */
    public WeatherData(String city, int temperature, int humidity,
                       int windSpeed, String condition) {
        this.city        = city;
        this.temperature = temperature;
        this.humidity    = humidity;
        this.windSpeed   = windSpeed;
        this.condition   = condition;
        this.timestamp   = LocalDateTime.now(); // Registrar hora actual
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    /** @return Nombre de la ciudad. */
    public String getCity() { return city; }

    /** @return Temperatura en °C. */
    public int getTemperature() { return temperature; }

    /** @return Humedad en %. */
    public int getHumidity() { return humidity; }

    /** @return Velocidad del viento en km/h. */
    public int getWindSpeed() { return windSpeed; }

    /** @return Condición meteorológica. */
    public String getCondition() { return condition; }

    /** @return Marca de tiempo de la consulta. */
    public LocalDateTime getTimestamp() { return timestamp; }

    /**
     * Devuelve la marca de tiempo formateada como cadena legible.
     *
     * @return Fecha y hora en formato "dd/MM/yyyy HH:mm".
     */
    public String getFormattedTimestamp() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return timestamp.format(fmt);
    }

    /**
     * Representación textual compacta del objeto, útil para logs y depuración.
     *
     * @return String con los campos principales separados por comas.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s: %d°C, %d%% hum, %d km/h, %s",
                getFormattedTimestamp(), city, temperature,
                humidity, windSpeed, condition);
    }
}
