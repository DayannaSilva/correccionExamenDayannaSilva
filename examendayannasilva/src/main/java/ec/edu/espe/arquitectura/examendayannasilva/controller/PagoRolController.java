package ec.edu.espe.arquitectura.examendayannasilva.controller;

import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examendayannasilva.service.PagoRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pagoRol")

public class PagoRolController {

    private final PagoRolService pagoRolService;

    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PagoRolRQ rq) {
        this.pagoRolService.crear(rq);
        return ResponseEntity.ok("Pago Rol generado");
    }



}