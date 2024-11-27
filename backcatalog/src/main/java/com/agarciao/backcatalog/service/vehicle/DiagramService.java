package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.DiagramEntity;
import com.agarciao.backcatalog.persistence.repository.DiagramRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagramService {

    @Autowired
    private DiagramRepository diagramRepository;

    //List of Diagram
    public List<DiagramEntity> getsDiagramList(){
        return diagramRepository.findAll();
    }

    //Diagram by id
    public DiagramEntity getsIdDiagram(long id){
        return diagramRepository.findById(id).orElse(null);
    }

    //Create Diagram
    public DiagramEntity createsDiagram(DiagramEntity diagram){
        return diagramRepository.save(diagram);
    }

    //Update Diagram
    public DiagramEntity updatesDiagram(long id, @NotNull DiagramEntity diagram){
        DiagramEntity updatedDiagram = diagramRepository.findById(id).get();
        updatedDiagram.setName(diagram.getName());
        updatedDiagram.setImage(diagram.getImage());
        updatedDiagram.setCategory(diagram.getCategory());
        updatedDiagram.setModel(diagram.getModel());
        return diagramRepository.save(updatedDiagram);
    }

    //Delete Diagram
    public void deletesDiagram(long id){
        Optional<DiagramEntity> optionalDiagram = diagramRepository.findById(id);
        if (optionalDiagram.isPresent()){
            DiagramEntity deletedDiagram = optionalDiagram.get();
            diagramRepository.delete(deletedDiagram);
        }
        else {
            throw new EntityNotFoundException("Diagrama no encontrado");
        }
    }
}
