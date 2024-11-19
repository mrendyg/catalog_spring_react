package com.agarciao.backcatalog.controller.vehicle;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/brand")
@PreAuthorize("denyAll()")
public class BrandController {
}
