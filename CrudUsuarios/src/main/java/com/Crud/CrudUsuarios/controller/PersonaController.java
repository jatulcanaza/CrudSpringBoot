package com.Crud.CrudUsuarios.controller;


import com.Crud.CrudUsuarios.entity.Persona;
import com.Crud.CrudUsuarios.service.PersonaService;

// Importa anotaciones y clases necesarias para manejar controladores y modelos en Spring MVC.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controlador principal para manejar las operaciones relacionadas con "Persona".
 * Se utiliza en el contexto de un CRUD para gestionar la entidad Persona.
 *
 * @author MyVICTIUS
 */
@Controller // Indica que esta clase es un controlador de Spring MVC.
@RequestMapping("/personas") // Define la URL base para todas las rutas de este controlador.
public class PersonaController {

    @Autowired // Inyección de dependencia automática para el servicio de personas.
    private PersonaService personaService;

    // Constructor de la clase. Aunque no realiza acciones específicas,
    // Spring lo utiliza para inicializar la clase.
    public PersonaController() {
    }

    /**
     * Maneja solicitudes GET para listar todas las personas.
     * Agrega la lista de personas al modelo y devuelve la vista "persona-list".
     *
     * @param model Objeto para enviar datos a la vista.
     * @return Nombre de la vista que muestra la lista de personas.
     */
    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", this.personaService.listarPersonas());
        return "persona-list"; // Devuelve la vista que muestra la lista de personas.
    }

    /**
     * Maneja solicitudes GET para mostrar la página de inicio.
     *
     * @return Nombre de la vista principal "index".
     */
    @GetMapping({"/"})
    public String mostrarPaginaInicio() {
        return "index"; // Devuelve la vista principal.
    }

    /**
     * Maneja solicitudes GET para mostrar el formulario para registrar una nueva persona.
     * Agrega un objeto vacío de Persona al modelo.
     *
     * @param model Objeto para enviar datos a la vista.
     * @return Nombre de la vista "persona-form".
     */
    @GetMapping({"/nuevo"})
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona()); // Se envía un objeto Persona vacío a la vista.
        return "persona-form"; // Devuelve la vista del formulario.
    }

    /**
     * Maneja solicitudes POST para guardar una nueva persona o actualizar una existente.
     * Redirige a la lista de personas después de guardar.
     *
     * @param persona Objeto Persona con los datos enviados desde el formulario.
     * @return Redirección a la lista de personas.
     */
    @PostMapping
    public String guardarPersona(Persona persona, RedirectAttributes redirectAttributes) {
        try {
            this.personaService.guardar(persona); // Guarda o actualiza la persona en la base de datos.
            redirectAttributes.addFlashAttribute("mensajeExito", "Persona guardada exitosamente.");
            return "redirect:/personas"; // Redirige a la lista de personas.
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("mensajeError", "El correo ya está en uso. Intente con otro correo.");
            return "redirect:/personas/nuevo"; // Redirige de nuevo al formulario de creación.
        }
    }
    /**
     * Maneja solicitudes GET para mostrar el formulario de edición de una persona.
     * Recupera la persona por ID y la agrega al modelo.
     *
     * @param id    ID de la persona a editar.
     * @param model Objeto para enviar datos a la vista.
     * @return Nombre de la vista "persona-form".
     */
    @GetMapping({"/editar/{id}"})
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", this.personaService.obtenerPorId(id)); // Recupera la persona por ID.
        return "persona-form"; // Devuelve la vista del formulario.
    }

    /**
     * Maneja solicitudes DELETE para eliminar una persona por su ID.
     * Redirige a la lista de personas después de eliminar.
     *
     * @param id ID de la persona a eliminar.
     * @return Redirección a la lista de personas.
     */
    @GetMapping({"/eliminar/{id}"})
    public String eliminarPersona(@PathVariable Long id) {
        this.personaService.eliminar(id);
        return "redirect:/personas";
    }
}
