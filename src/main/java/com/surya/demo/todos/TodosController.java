package com.surya.demo.todos;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TodosController {

    @Autowired
    private TodoService todoService;

    //ADD TASK
    @PostMapping("/todos")
    public Map<String, Integer> addTask(@RequestBody Map<String, String> todo) {
        // add data to DB and return the id in json format

        int todoId = todoService.addNewTodo(todo);

        System.out.println(todo);

        Map<String, Integer> map = new HashMap<>();
        map.put("id", todoId);
        return map;
    }
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Integer id){
        System.out.println("Deleting the TODO with ID : " + id);
        todoService.deleteTodo(id);
    }

    @GetMapping("todos/{id}")
    public Todo getTodoById(@PathVariable Integer id){
        Todo todo = todoService.getTodoById(id);
        System.out.println(todo);
        return todo;
    }
    @GetMapping("/alltodos")
    public ArrayList<Todo> getAllTodods(){
        //ArrayList<Todo> allToDos = new ArrayList<>();
        //allToDos = todoService.getAllTodos();
        ArrayList<Todo> allToDos = todoService.getAllTodos();
        System.out.println(allToDos);
        return allToDos;
    }

    @PatchMapping("/updatetodos/{id}")
    public void updatedTodo(@PathVariable int id, @RequestBody Map<String, String> todo){
        Todo updatedTodo = todoService.updateTodo(id, todo);
        System.out.println(updatedTodo);
    }
}


/*
* C
* S
* R
* */
