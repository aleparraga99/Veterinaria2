# Veterinaria2

RESUMEN

En el desarrollo de nuestro proyecto, hemos implementado el patrón de diseño Singleton para garantizar que ciertas clases críticas tengan una única instancia en todo el ciclo de vida de la aplicación, optimizando recursos y asegurando un comportamiento consistente.
Utilizamos herramientas como GitHub para el control de versiones y la colaboración en equipo, IntelliJ IDEA Community Edition como entorno de desarrollo, y Postman para realizar pruebas y verificar la funcionalidad de la API. El backend fue desarrollado con Spring Boot, mientras que los datos se almacenan en una base de datos MySQL, asegurando una arquitectura robusta y escalable. Estas herramientas nos permitieron trabajar de manera eficiente y mantener la calidad del proyecto.

Endpoints
Adoptantes:
curl http://localhost:8080/veterinaria/adoptantes/obtenerSolicitudPorId
curl http://localhost:8080/veterinaria/adoptantes/crearSolicitud
curl http://localhost:8080/veterinaria/adoptantes/eliminarSolicitud

Mascotas:
curl http://localhost:8080/veterinaria/mascotas/crearMascota
curl http://localhost:8080/veterinaria/mascotas/obtenerEstadoMascota
curl http://localhost:8080/veterinaria/mascotas/obtenerMascotaPorId
curl http://localhost:8080/veterinaria/mascotas/eliminarMascota
curl http://localhost:8080/veterinaria/mascotas/eliminarMascota
curl http://localhost:8080/veterinaria/mascotas/obtenerTodasLasMascotas

Solicitudes de adopción:
curl http://localhost:8080/veterinaria/solicitudes/crearSolicitud
curl http://localhost:8080/veterinaria/solicitudes/obtenerSolicitudPorId
curl http://localhost:8080/veterinaria/solicitudes/eliminarSolicitud
