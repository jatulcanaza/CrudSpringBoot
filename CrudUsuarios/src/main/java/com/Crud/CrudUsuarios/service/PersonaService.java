package com.Crud.CrudUsuarios.service;

import com.Crud.CrudUsuarios.entity.Persona;
import com.Crud.CrudUsuarios.repository.PersonaRepository;
import java.util.List; // Importa la clase List para manejar listas de objetos Persona.
import org.springframework.beans.factory.annotation.Autowired; // Permite la inyección de dependencias.
import org.springframework.stereotype.Service; // Marca esta clase como un componente de servicio.

/**
 * Clase PersonaService.
 * Proporciona métodos para gestionar operaciones relacionadas con Personas.
 * Se comunica con el repositorio PersonaRepository.
 *
 * @author MyVICTIUS
 */
@Service // Marca esta clase como un servicio dentro del contenedor Spring.
public class PersonaService {

    @Autowired // Inyección de dependencias del repositorio PersonaRepository.
    private PersonaRepository personaRepository;

    /**
     * Constructor vacío de la clase PersonaService.
     * No realiza acciones adicionales, pero permite inicializar el servicio si es necesario.
     */
    public PersonaService() {
    }

    /**
     * Método para listar todas las personas.
     *
     * @return Lista de todas las personas en la base de datos.
     */
    public List<Persona> listarPersonas() {
        return this.personaRepository.findAll(); // Llama al método findAll() del repositorio.
    }

    /**
     * Método para guardar una nueva persona o actualizar una existente.
     *
     * @param persona La entidad Persona a guardar o actualizar.
     * @return La entidad Persona guardada, incluyendo su ID asignado.
     */
    public Persona guardar(Persona persona) {
        return this.personaRepository.save(persona); // Llama al método save() del repositorio.
    }

    /**
     * Método para obtener una persona por su ID.
     *
     * @param id El ID de la persona a buscar.
     * @return La entidad Persona encontrada o null si no existe.
     */
    public Persona obtenerPorId(Long id) {
        return this.personaRepository.findById(id).orElse(null); // Busca por ID y devuelve null si no se encuentra.
    }

    /**
     * Método para eliminar una persona por su ID.
     *
     * @param id El ID de la persona a eliminar.
     */
    public void eliminar(Long id) {
        this.personaRepository.deleteById(id); // Llama al método deleteById() del repositorio.
    }
}