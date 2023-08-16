# Clutch

Aplicación orientada a conocer todos los detalles del juego Valorant. 

## Tecnologías utilizadas:

- ** MVVM (Model-View-ViewModel): ** Patrón arquitectónico que separa la lógica de presentación de la lógica de negocio y los datos. Proporciona una separación clara entre las distintas capas de la aplicación.
- ** Clean Architecture: ** Enfoque arquitectónico que divide a la aplicación en capas independientes y bien definidas, como la capa de presentación, la capa de dominio y la capa de datos. Esto favorece la independendia del proyecto y facilita las pruebas unitarias.
- ** Koin: ** Un marco de inyección de dependencias para Kotlin. Maneja la creación y administración de objetos de manera eficiente.
- ** Retrofit: ** Biblioteca de Android para realizar llamadas de red de manera sencilla y eficiente. Se utiliza para consumir servicios web y manejar la comunicación con el backend.
- ** Compose: ** Marco de UI declarativo para la creación de interfaces de usuario en Android.
- ** Coroutines ** Marco para la progrmación asíncrona en Kotlin. Se utiliza para manejar tareas concurrentes y asíncronas de manera más segura y eficiente.
- ** Room: ** Biblioteca de persistencia de Android que simplifica el acceso a la base de datos SQLite. Se utiliza para manejar el almacenamiento local de datos.
- ** AVS Custom View: ** Tecnología de vistas personalizadas que permite crear componentes de UI personalizables y reutilizables.
- ** Nested Navigation: ** Navegación jerárquica en aplicaciones Android que utiliza fragmentos anidados para organizar y gestionar la navegación.
- ** Shared Preferences: ** Mecanismo de almacenamiento ligero para guardar datos clave-valor en pares en la aplicación.
- ** Bottom Navigation Bar: ** Componente de interfaz de usuario que proporciona navegación entre fragmentos a través de pestañas en la parte inferior de la pantalla.

## Estructura del proyecto:

El proyecto sigue una estructura basada en Clean Architecture, lo que significa que está dividido en capas bien definidas:

- ** presentation: ** Capa que se encarga de la interfaz de usuario y presentacion. Aquí se encuentra la implementación de la arquitectura MVVM, donde los ViewModels se comunican con los casos de uso en la capa de domain.
- ** domain: ** Capa que contiene la lógica de negocio de la aplicación. Aquí se definen los casos de uso y los modelos del dominio.
- ** di: ** Aquí se encuentra la configuración de la inyección de dependencias utilizando Koin. Se definen los módulos para crear y proporcionar las instancias necesarias para toda la aplicación.
- ** data: ** En esta capa se maneja la obtención y almacenamiento de datos. Se utilizan fuentes de datos como la red (Retrofit) y la base de datos local (Room). Los repositorios implementan el patrón repositorio para proporcionar una interfaz única para acceder a los datos.
- ** components: ** En esta capa se encuentran los componentes reutilizables de la aplicación. Pueden incluir vistas personalizadas, extensiones de funciones clases de utilidad y más. Estos componentes contribuyen a una mayor modularidad y mantenibilidad.
- ** navigation: ** Esta capa se encarga de la navegación entre destinos en la aplicación. Aquí se definen los gráficos de navegación, fragmentos y acciones para guiar al usuario a través de la interfaz de usuario.

# Configuración y uso:

1 - Clona el repositorio
2 - Abre el proyecto en Android Studio
3 - Configura las dependencias en el archivo `build.gradle`.
4 - Explora las capas y clases de la App
