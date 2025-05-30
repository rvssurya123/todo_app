package com.surya.demo.todos;

import com.surya.demo.dtos.ToDoRequestDto;
import com.surya.demo.dtos.ToDoResponseDto;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ToDoResponseDto> addTask(@RequestBody @Valid ToDoRequestDto todo) {
        // add data to DB and return the id in json format

        int todoId = todoService.addNewTodo(todo);

        System.out.println(todo);

        //ToDoRequestDto toDoRequestDto = new ToDoRequestDto();

        ToDoResponseDto toDoResponseDto = new ToDoResponseDto();
        toDoResponseDto.setId(todoId);
//        Map<String, Integer> map = new HashMap<>();
//        map.put("id", todoId);
        ResponseEntity<ToDoResponseDto> response = ResponseEntity.status(201).body(toDoResponseDto);
        return response;
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
