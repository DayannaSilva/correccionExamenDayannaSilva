package ec.edu.espe.arquitectura.examendayannasilva.controller;

import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.PagoRolRS;

import ec.edu.espe.arquitectura.examendayannasilva.service.PagoValidacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pagoValidaciones")

public class PagoValidaciones {
  private final PagoValidacionesService pagoValidacionesService;

    public PagoValidaciones(PagoValidacionesService pagoValidacionesService) {
        this.pagoValidacionesService = pagoValidacionesService;
    }


    @PutMapping("/validar")
    public ResponseEntity<PagoRolRS> validatePayRolePayment(@RequestParam String mes, @RequestParam String ruc , @RequestBody EmpleadosPagoRQ empleadoPagoRQ) {
        PagoRolRS rs = this.pagoValidacionesService.validarPago(mes, ruc, empleadoPagoRQ);
        return ResponseEntity.ok(rs);
    }
}
