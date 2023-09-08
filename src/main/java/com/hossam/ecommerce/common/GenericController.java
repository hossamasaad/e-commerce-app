package com.hossam.ecommerce.common;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenericController<T extends GenericModel> {

    private final GenericService<T> service;

    public GenericController(GenericService<T> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public T add(@RequestBody T t){
        return service.add(t);
    }

    @PutMapping
    public T update(@RequestBody T t){
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return service.delete(id);
    }
}
