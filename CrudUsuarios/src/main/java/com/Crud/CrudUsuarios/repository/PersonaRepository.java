package com.Crud.CrudUsuarios.repository;

import com.Crud.CrudUsuarios.entity.Persona;
// Importa JpaRepository, una interfaz que proporciona métodos CRUD predeterminados.
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz PersonaRepository.
 * Extiende JpaRepository para heredar funcionalidad básica de persistencia.
 * Proporciona acceso a métodos predefinidos para trabajar con la base de datos.
 // @param Persona La entidad con la que trabajará el repositorio.
 // @param Long El tipo de dato del ID de la entidad Persona.
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // No se requiere agregar métodos adicionales para operaciones básicas,
    // ya que JpaRepository proporciona funcionalidades CRUD y de paginación/límite.
}