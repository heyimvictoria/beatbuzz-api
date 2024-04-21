package org.launchcode.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AcasaController {

    @GetMapping
    public String acasa(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("/secure")
    public String secure() {return "this is secure!";}

}
