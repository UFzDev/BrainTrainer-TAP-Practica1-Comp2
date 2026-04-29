# Brain Trainer - Juego de Agilidad Mental (BinTra) 🧠

BinTra es una aplicación móvil nativa para Android, desarrollada en Kotlin, diseñada para el entrenamiento cerebral mediante la resolución de operaciones matemáticas aleatorias. Este proyecto fue creado como parte de la Práctica 1 de la Competencia 2 para la asignatura de Tópicos Avanzados de Programación.

## 🚀 Características Principales

### Niveles de Dificultad Escalares:
*   **Fácil**: Sumas y restas con operandos entre 0 y 10.
*   **Intermedio**: Sumas, restas y multiplicaciones con operandos entre 0 y 20.
*   **Avanzado**: Sumas, restas, multiplicaciones y divisiones exactas con operandos entre 1 y 50.

### Dinámica de Juego Frenética:
Sesiones de tiempo controladas por un `CountDownTimer` donde el usuario debe responder la mayor cantidad de operaciones posible.

### Sistema de Menú Lateral (Drawer):
Navegación fluida entre la pantalla de juego, el historial de puntuaciones y los ajustes.

### Historial y Estadísticas:
Visualización de partidas previas con detalles de puntaje, nivel y fecha, incluyendo cálculos automáticos de promedios generales y por nivel (almacenamiento volátil).

### Configuración Personalizada:
Pantalla de "Settings" para ajustar el tiempo de duración de las partidas.

## 🛠️ Tecnologías Utilizadas
*   **Lenguaje**: Kotlin 1.9+
*   **Interfaz de Usuario**: XML (Layouts con `DrawerLayout`, `NavigationView`, `RecyclerView`).
*   **Recursos**: Gestión centralizada en `strings.xml` y `colors.xml` para fácil mantenimiento.
*   **SDK Mínimo**: API 24 (Android 7.0 Nougat).
*   **IDE**: Android Studio.

## 📱 Vistas de la Aplicación
*   **Selección de Dificultad**: Botones directos para iniciar el juego sin fricción.
*   **Pantalla de Preparación**: Cuenta regresiva de 3 segundos para que el usuario se concentre.
*   **Interfaz de Juego**: Muestra el tiempo restante, score actual, la operación y 4 botones de opción múltiple.
*   **Pantalla de Resultados**: Resumen del puntaje final con opción de reintento inmediato.
*   **Historial**: Tarjetas detalladas con el rendimiento de la sesión actual.

## 📥 Instalación y Uso
1.  Clona este repositorio:
    ```bash
    git clone https://github.com/UFzDev/BrainTrainer-TAP-Practica1-Comp2.git
    ```
2.  Abre el proyecto en Android Studio.
3.  Sincroniza los archivos de Gradle.
4.  Ejecuta la aplicación en un dispositivo físico o emulador con API 24 o superior.

## 🎓 Información del Proyecto
*   **Institución**: Tecnológico Nacional de México en Celaya (ITC).
*   **Asignatura**: Tópicos Avanzados de Programación.
*   **Profesor**: M.A.V.D. José Jesús Sánchez Farías.
*   **Alumno**: Uriel Flores Zarate (No. Control: 23031521).
*   **Fecha de entrega**: 28 de abril de 2026.

Desarrollado con ❤️ por **UFzDev**
