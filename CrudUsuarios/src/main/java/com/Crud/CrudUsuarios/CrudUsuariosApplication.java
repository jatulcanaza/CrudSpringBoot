package com.Crud.CrudUsuarios;
// Importa la clase SpringApplication, utilizada para lanzar la aplicación Spring Boot.
import org.springframework.boot.SpringApplication;
// Importa la anotación SpringBootApplication, que configura automáticamente varios aspectos de la aplicación.
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudUsuariosApplication {
	// Método principal, que actúa como el punto de entrada de la aplicación Java.
	// Este método es ejecutado al iniciar el programa.
	public static void main(String[] args) {
		// Llama al método estático run() de SpringApplication para lanzar la aplicación.
		// Esto inicializa el contexto de Spring, escanea las clases anotadas para configurarlas,
		// y arranca un servidor embebido como Tomcat o Jetty si es necesario.
		SpringApplication.run(CrudUsuariosApplication.class, args);
	}

}
