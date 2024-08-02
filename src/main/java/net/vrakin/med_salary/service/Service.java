package net.vrakin.med_salary.service;

import java.util.List;
import java.util.Optional;

/**
 * A generic service interface that defines common CRUD operations.
 *
 * @param <T> The type of entity this service manages.
 */
public interface Service<T> {

    /**
     * Finds an entity by its ID.
     *
     * @param id The ID of the entity to find.
     * @return An Optional containing the entity if found, or empty if not found.
     */
    Optional<T> findById(Long id);

    /**
     * Finds entities by their name.
     *
     * @param name The name to search for.
     * @return A list of entities matching the given name.
     */
    List<T> findByName(String name);

    /**
     * Retrieves all entities.
     *
     * @return A list of all entities.
     */
    List<T> findAll();

    /**
     * Saves a new entity or updates an existing one.
     *
     * @param t The entity to save or update.
     * @return The saved or updated entity.
     */
    T save(T t);

    /**
     * Deletes an entity.
     *
     * @param t The entity to delete.
     */
    void delete(T t);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     */
    void deleteById(Long id);

    /**
     * Deletes multiple entities by their IDs.
     *
     * @param ids A list of entity IDs to delete.
     */
    void deleteAllById(List<Long> ids);
}