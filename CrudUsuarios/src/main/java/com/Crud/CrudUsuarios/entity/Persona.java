package com.Crud.CrudUsuarios.entity;

// Importa las anotaciones de JPA para definir una entidad y sus atributos.
import jakarta.persistence.*;

/**
 * Marca esta clase como una entidad, es decir, un objeto que se mapeará
 * a una tabla en la base de datos.
 */
@Entity
public class Persona {

    /**
     * Define el atributo "id" como clave primaria de la tabla.
     * Utiliza @GeneratedValue con la estrategia IDENTITY para generar automáticamente el valor del ID
     * basado en el comportamiento del proveedor de base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    // Campos adicionales que representan los datos de la persona.
    private String nombre;    // Nombre de la persona.
    private String apellido;  // Apellido de la persona.

    @Column(unique = true, nullable = false)
    private String email;     // Dirección de correo electrónico.
    private String telefono;  // Número de teléfono.
    private String direccion; // Dirección física.

    /**
     * Constructor vacío requerido por JPA.
     * Es utilizado durante la serialización y deserialización de objetos.
     */
    public Persona() {
    }

    // Métodos getters y setters para acceder y modificar los atributos.
    // Son esenciales para encapsular los datos de la clase y permitir que otras
    // partes de la aplicación interactúen con el modelo.

    public Long getId() {
        return this.id; // Retorna el ID de la persona.
    }

    public void setId(Long id) {
        this.id = id; // Asigna un valor al ID de la persona.
    }

    public String getNombre() {
        return this.nombre; // Retorna el nombre de la persona.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asigna un valor al nombre de la persona.
    }

    public String getApellido() {
        return this.apellido; // Retorna el apellido de la persona.
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; // Asigna un valor al apellido de la persona.
    }

    public String getEmail() {
        return this.email; // Retorna el correo electrónico de la persona.
    }

    public void setEmail(String email) {
        this.email = email; // Asigna un valor al correo electrónico de la persona.
    }

    public String getTelefono() {
        return this.telefono; // Retorna el número de teléfono de la persona.
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono; // Asigna un valor al número de teléfono de la persona.
    }

    public String getDireccion() {
        return this.direccion; // Retorna la dirección de la persona.
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion; // Asigna un valor a la dirección de la persona.
    }
}
