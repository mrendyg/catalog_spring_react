package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.DiagramEntity;
import com.agarciao.backcatalog.service.vehicle.DiagramService;
import jakarta.validation.GroupSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e

@RestController
@RequestMapping("/auth/diagram")
@PreAuthorize("denyAll()")
public class DiagramController {

    @Autowired
    private DiagramService diagramService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('READ')")
    @ResponseStatus(HttpStatus.OK)
<<<<<<< HEAD
    public Iterable<DiagramEntity> DiagramGetId(){
=======
    public List<DiagramEntity> diagramList(){
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
        return diagramService.diagramList();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    @PreAuthorize("hasAuthorities('READ')")
    @ResponseStatus(HttpStatus.OK)
    public DiagramEntity diagramGetId(@PathVariable long id){
        return diagramService.getsIdDiagram(id);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthorities('CREATE')")
=======
    @PreAuthorize("hasAuthority('READ')")
    @ResponseStatus(HttpStatus.OK)
    public DiagramEntity getDiagram(@PathVariable Long id){
        return diagramService.getsIdDiagram(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('CREATE')")
    @ResponseStatus(HttpStatus.CREATED)
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
    public DiagramEntity createDiagram(@RequestBody DiagramEntity diagram){
        return diagramService.createsDiagram(diagram);
    }

<<<<<<< HEAD
    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAuthorities('UPDATE')")
    public DiagramEntity updateDiagram(@PathVariable long id, @RequestBody DiagramEntity diagram){
        return diagramService.updatesDiagram(id, diagram);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthorities('DELETE')")
    public void deleteDiagram(@PathVariable long id){
=======
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('CREATED')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DiagramEntity updateDiagram(@RequestBody DiagramEntity diagram, @PathVariable Long id){
        return diagramService.updatesDiagram(id, diagram);
    }

    @DeleteMapping("/delte/{id}")
    @PreAuthorize("hasRole('Admin') or hasRole('DEVELOPER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiagram(@PathVariable Long id){
>>>>>>> d3118a9d8db03d9761765bad310b87b5142f054e
        diagramService.deletesDiagram(id);
    }

}
