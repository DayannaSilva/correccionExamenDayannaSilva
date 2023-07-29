package ec.edu.espe.arquitectura.examendayannasilva.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadosPagoRQ {
    private String numeroCuenta;
    private String valor;
}
