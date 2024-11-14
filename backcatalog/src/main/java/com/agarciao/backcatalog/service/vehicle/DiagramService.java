package com.agarciao.backcatalog.service.vehicle;

import com.agarciao.backcatalog.persistence.entity.vehicle.DiagramEntity;
import com.agarciao.backcatalog.persistence.repository.DiagramRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagramService {

    @Autowired
    private DiagramRepository diagramRepository;

    public List<DiagramEntity> diagramList(){
        return diagramRepository.findAll();
    }

    public DiagramEntity getsIdDiagram(long id){
        return diagramRepository.findById(id).orElse(null);
    }

    public DiagramEntity createsDiagram(DiagramEntity diagram){
        return diagramRepository.save(diagram);
    }

    public DiagramEntity updatesDiagram(long id, DiagramEntity diagram){
        DiagramEntity updatedDiagram = diagramRepository.findById(id).get();
        updatedDiagram.setName(diagram.getName());
        updatedDiagram.setImage(diagram.getImage());
        updatedDiagram.setCategory(diagram.getCategory());
        updatedDiagram.setModel(diagram.getModel());
        return diagramRepository.save(updatedDiagram);
    }

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
