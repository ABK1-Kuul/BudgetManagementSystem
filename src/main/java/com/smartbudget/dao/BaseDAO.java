package com.smartbudget.dao;

import java.util.List;

import com.smartbudget.exceptions.DatabaseException;

/**
 * Generic Interface representing Data Access Object (DAO) contract patterns.
 * Demonstrates the OOP principles of Abstraction, Polymorphism, and Interface Contracts.
 *
 * @param <T> The model entity type handled by this DAO.
 */
public interface BaseDAO<T> {
    
    /**
     * Retrieve a record by its unique database identifier.
     */
    T findById(int id) throws DatabaseException;
    
    /**
     * Retrieve all records associated with a specific user.
     */
    List<T> findByUserId(int userId) throws DatabaseException;
    
    /**
     * Insert a new record into the database.
     * @return true if insertion was successful, false otherwise.
     */
    boolean insert(T entity) throws DatabaseException;
    
    /**
     * Update an existing record in the database.
     * @return true if update was successful, false otherwise.
     */
    boolean update(T entity) throws DatabaseException;
    
    /**
     * Delete a record by its unique identifier.
     * @return true if deletion was successful, false otherwise.
     */
    boolean delete(int id) throws DatabaseException;
}
