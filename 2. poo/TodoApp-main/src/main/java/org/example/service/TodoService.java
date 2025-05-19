package org.example.service;

import org.example.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();
    Todo getById(int id);
    void add(String name, String description);
    void update(int id, String name, String description, boolean done);
    void remove(int id);
    void toggleDone(int id);

}
