package com.surya.demo.todos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    // add todo -- returns id
    public int addNewTodo(Map<String, String> todoData) {
        Todo newTodo = new Todo();
        newTodo.description = todoData.get("description");

        Todo savedTodo = todoRepository.save(newTodo);
        return savedTodo.id;
    }

    // update todo
    public Todo updateTodo(int id, Map<String, String> todoData){
        Todo todoById = getTodoById(id);
        if(todoData.get("description") != null)
            todoById.description = todoData.get("description");

        if(todoData.get("status") != null)
             todoById.status = todoData.get("status");

        Todo save = todoRepository.save(todoById);

        System.out.println(save.getId());

        return save;
    }

    // delete todo
    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }

    // get all todos
    public ArrayList<Todo> getAllTodos(){
        //ArrayList<Todo> allTodos = new ArrayList();
        //allTodos = (ArrayList<Todo>) todoRepository.findAll();
        ArrayList<Todo> allTodos = (ArrayList<Todo>) todoRepository.findAll();
        return allTodos;
    }


    // get todo by id
    public Todo getTodoById(int id) {
        Todo todo = todoRepository.findById(id).get();

        return todo;
    }
}
