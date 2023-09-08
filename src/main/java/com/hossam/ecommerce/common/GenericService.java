package com.hossam.ecommerce.common;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class GenericService <T extends GenericModel> {

    protected JpaRepository<T, Integer> repo;

    public GenericService(JpaRepository<T, Integer> repo) {
        this.repo = repo;
    }

    public T getById(int id){
        Optional<T> t = repo.findById(id);

        if (t.isPresent())
            return t.get();

        throw new RuntimeException("There is no " + t.getClass().getName() + " with id = " + id);
    }

    public List<T> getAll(){
        return repo.findAll();
    }

    public T add(T t) {
        try {
            t.setId(0); // force to save
            t.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            t.setModifiedAt(new Timestamp(System.currentTimeMillis()));
            return repo.save(t);
        } catch (DataIntegrityViolationException e) {
            System.out.println(t);
            // Handle the case where the email is duplicated
            throw new IllegalArgumentException("Email is already registered");
        }
    }

    public T update(T t) {
        System.out.println(t);
        if (t.getId() == 0) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        Optional<T> existingT = repo.findById(t.getId());
        if (existingT.isEmpty()) {
            throw new IllegalArgumentException(t.getClass().getName() + " with ID " + t.getId() + " does not exist");
        }

        t.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        return repo.save(t);
    }

    public String delete(int id){
        repo.deleteById(id);
        return "Deleted Successfully!";
    }
}
