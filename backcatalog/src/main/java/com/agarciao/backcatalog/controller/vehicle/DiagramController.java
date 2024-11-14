package com.agarciao.backcatalog.controller.vehicle;

import com.agarciao.backcatalog.service.vehicle.DiagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/diagram")
@PreAuthorize("denyAll()")
public class DiagramController {

    @Autowired
    private DiagramService diagramService;
}
