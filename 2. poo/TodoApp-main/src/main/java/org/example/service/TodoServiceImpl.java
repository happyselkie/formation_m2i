package org.example.service;

import org.example.model.Todo;

import java.util.List;

public class TodoServiceImpl implements TodoService{

    private static List<Todo> todoList;
    private static int cpt = 1;

    public static List<Todo> getTodoList() {
        return todoList;
    }

    @Override
    public List<Todo> getAll() {
        return todoList;
    }

    @Override
    public Todo getById(int id) {
        for(Todo todo : todoList){
            if(todo.getId() == id) return todo;
        }
        return null;
    }

    @Override
    public void add(String name, String description) {
        Todo newTodo = new Todo(cpt++, name, description);
        todoList.add(newTodo);
    }

    @Override
    public void update(int id, String name, String description, boolean done) {
        Todo todoToUpdate = this.getById(id);
        todoToUpdate.setName(name);
        todoToUpdate.setDescription(description);
        todoToUpdate.setDone(done);
    }

    @Override
    public void remove(int id) {
        Todo todoToRemove = this.getById(id);
        todoList.remove(todoToRemove);
        todoToRemove = null;
    }

    @Override
    public void toggleDone(int id) {

    }
}
