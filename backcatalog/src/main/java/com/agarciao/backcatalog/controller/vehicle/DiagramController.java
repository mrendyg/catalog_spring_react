package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.DiagramEntity;
import com.agarciao.backcatalog.service.vehicle.DiagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/diagram")
@PreAuthorize("denyAll()")
public class DiagramController {

    //The logic of each function is found in the Service
    @Autowired
    private DiagramService diagramService;

    //List of diagram
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('READ')")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<DiagramEntity> DiagramGetId(){
        return diagramService.getsDiagramList();
    }

    //Diagram by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthorities('READ')")
    @ResponseStatus(HttpStatus.OK)
    public DiagramEntity diagramGetId(@PathVariable long id){
        return diagramService.getsIdDiagram(id);
    }

    //Create Diagram
    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthorities('CREATE')")
    public DiagramEntity createDiagram(@RequestBody DiagramEntity diagram){
        return diagramService.createsDiagram(diagram);
    }

    //Update Diagram
    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAuthorities('UPDATE')")
    public DiagramEntity updateDiagram(@PathVariable long id, @RequestBody DiagramEntity diagram){
        return diagramService.updatesDiagram(id, diagram);
    }

    //Delete Diagram
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthorities('DELETE')")
    public void deleteDiagram(@PathVariable long id){
        diagramService.deletesDiagram(id);
    }

}
