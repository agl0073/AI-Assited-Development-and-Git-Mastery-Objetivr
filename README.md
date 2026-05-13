# 🌤 Weather App — Java Console

> Aplicación meteorológica de consola desarrollada en Java como proyecto práctico de control de versiones con Git.

---

## 📋 Descripción

**Weather App** es una aplicación Java que permite consultar el clima de distintas ciudades del mundo directamente desde la terminal. Incluye una base de datos simulada de ciudades conocidas y genera datos estimados para cualquier otra ciudad.

Este proyecto fue desarrollado con asistencia de IA (Claude) como parte de la asignatura de **AI-Assisted Development and Git Mastery**.

---

## 🗂 Estructura del Proyecto

```
weather-app/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── weather/
│                   ├── WeatherApp.java       # Punto de entrada y menú principal
│                   ├── WeatherData.java      # Modelo de datos meteorológicos
│                   ├── WeatherService.java   # Lógica de consulta y base de datos
│                   └── WeatherHistory.java   # Gestión del historial de consultas
├── index.html                                # GitHub Pages — landing page
└── README.md
```

---

## ✨ Funcionalidades

| Opción | Función |
|--------|---------|
| 1 | Consultar el clima de una ciudad |
| 2 | Ver historial de consultas de la sesión |
| 3 | Limpiar el historial *(añadido en `feature-update`)* |
| 4 | Salir de la aplicación |

**Ciudades con datos predefinidos:** Madrid, Barcelona, Sevilla, Zaragoza, Valencia, London, Paris, Tokyo, New York, Sydney.

---

## 🚀 Compilación y Ejecución

### Requisitos
- Java 11 o superior
- Terminal / línea de comandos

### Pasos

```bash
# 1. Entra al directorio raíz del proyecto
cd weather-app

# 2. Crea el directorio de salida
mkdir -p out

# 3. Compila todos los archivos Java
javac -d out src/main/java/com/weather/*.java

# 4. Ejecuta la aplicación
java -cp out com.weather.WeatherApp
```

---

## 🌿 Flujo Git del Proyecto

```
main
 │
 ├── commit: "Initial commit: WeatherApp base"
 │
 ├── commit: "Add WeatherData model and WeatherService"
 │
 └── feature-update (branch)
       ├── commit: "Add clearHistory feature to WeatherHistory"
       └── merge → main
```

---

## 📸 Capturas de Pantalla

*(Ver presentación PDF adjunta para capturas de terminal con cada paso Git)*

---

## 🛠 Tecnologías

- **Java 11+** — lenguaje principal
- **Git CLI** — control de versiones
- **GitHub** — repositorio remoto y GitHub Pages
- **Claude (Anthropic)** — asistente de IA para pair programming

---

## 📄 Licencia

Proyecto educativo. Libre uso con fines académicos.
