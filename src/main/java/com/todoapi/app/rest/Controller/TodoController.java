package com.todoapi.app.rest.Controller;

import com.todoapi.app.rest.Model.Task;
import com.todoapi.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
     @Autowired //instancia repo en la clase
     private TodoRepository todoRepository;

    @GetMapping(value = "/") // pagina principal
    public String holaMundo() {
        return "HOLA MUNDO!!";
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }


    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task) {
        todoRepository.save(task);
        return "Saved Task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        // rastreamos la tarea que queremos actualizar
        Task updatedTask = todoRepository.findById(id).get();
        // actualizamos la tarea que estaba guardada seteandole los valores nuevos del objeto "task" que recibe el endpoint
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        // guardamos esta tarea actualizada
        todoRepository.save(updatedTask);
        // retornamos al usuario que salio con exito
        return "Updated Task";
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "Deleted Task";
    }
}
