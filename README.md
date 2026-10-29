# ᗜˬᗜ Fumo Sanctuary — Catálogo & Navegación Android App

Una aplicación nativa para Android, limpia, fluida y con un diseño impecable, desarrollada con **Kotlin** y **Jetpack Compose**. Diseñada para navegar entre pantallas de manera ágil y mostrar un catálogo interactivo de peluches y coleccionables Fumo de Touhou Project utilizando la eficiencia de `LazyColumn`.

### Tecnologías usadas
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material Design 3](https://img.shields.io/badge/Material%20Design%203-757575?style=for-the-badge&logo=materialdesign&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

### Control de versiones
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

---

## 🚀 Características

- 📱 **Interfaz Moderna:** Diseñada 100% en Jetpack Compose siguiendo las pautas de Material Design 3.
- 🧭 **Navegación Fluida:** Manejo de rutas entre la pantalla principal de bienvenida y el catálogo de coleccionables mediante `NavHost` y `NavController`.
- ⚡ **Rendimiento Optimizado (`LazyColumn`):** Renderizado dinámico y eficiente de la lista de Fumos que carga solo los elementos visibles en pantalla.
- 🖼️ **Soporte Visual Completo:** Integración de imágenes personalizadas almacenadas localmente en `drawable` mapeadas dinámicamente mediante IDs de recursos (`cirno.jpg`, `reimu.jpg`, etc.).
- 🎨 **UI Pulida:** Tarjetas (`Card`) estilizadas con elevación, bordes redondeados y una jerarquía tipográfica clara con descripciones y precios destacados en color verde.

---

## 🛠️ Tecnologías y Herramientas

- **Lenguaje:** Kotlin
- **UI Framework:** Jetpack Compose
- **Navegación:** Compose Navigation (`androidx.navigation:navigation-compose`)
- **Componentes:** Material 3 (`Card`, `LazyColumn`, `Button`, `Text`, `Image`)
- **Estructura de Datos:** Modelado orientado a objetos con `data class` (`FumoItem`)
- **Mínimo SDK:** Android 7.0 (API 24+)

---

## 📂 Estructura del Proyecto

El proyecto mantiene la arquitectura estándar de una app moderna en Jetpack Compose:

```text
Navegacion-FumoSanctuary/
 └── app/                  # Módulo principal de la aplicación
     ├── build.gradle.kts     # Configuración de dependencias (Navigation, Compose, etc.)
     └── src/
         ├── main/
         │   ├── AndroidManifest.xml          # Configuración global de la app
         │   ├── java/
         │   │   └── com/example/navegacion/
         │   │       └── MainActivity.kt      # Navegación (NavHost), vistas Composables y Data Class
         │   │
         │   └── res/                         # Recursos estáticos de la app
         │       ├── drawable/                # Imágenes de los Fumos (cirno.jpg, reimu.jpg, etc.)
         │       ├── mipmap/                  # Iconos del launcher
         │       └── values/                  # Textos y temas estáticos
         │
         ├── androidTest/                     # Pruebas de interfaz
         └── test/                            # Pruebas unitarias
```

---

## ⚙️ Configuración y Requisitos del Entorno

# Para compilar y ejecutar este proyecto en tu equipo:

- **Android Studio:** Versión Jellyfish, Koala o superior recomendada

- **JDK (Java Development Kit):** Versión 17 (incluido por defecto en Android Studio)

- **SDK de Android:** 17.0 CinnamonBun

- **Compile SDK:** Android 34 (o superior)

- **Minimum SDK:** API 24 (Android 7.0 Nougat)
        
---

## Pasos para clonar y ejecutar:

- **Clonar el repositorio:**
    
```bash 
git clone [https://github.com/Mcpapu9/Navegacion-FumoSanctuary.git]
 ```
- **Abrir el proyecto:**

Abre Android Studio, selecciona Open y elige la carpeta del proyecto clonado.

- **Sincronización de Gradle:**

Deja que Gradle sincronice las dependencias automáticas de Jetpack Compose y Navigation. Si es necesario, da clic en el icono del elefante (Sync Project with Gradle Files).

- **Ejecutar la app:**

Selecciona tu emulador o dispositivo físico con Depuración USB activa y presiona Run ▶ (Shift + F10).
