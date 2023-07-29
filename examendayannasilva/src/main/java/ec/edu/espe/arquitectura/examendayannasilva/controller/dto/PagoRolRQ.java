package ec.edu.espe.arquitectura.examendayannasilva.controller.dto;

import ec.edu.espe.arquitectura.examendayannasilva.model.EmpleadosPago;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Builder
public class PagoRolRQ {
    private String mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;

    private EmpleadosPago empleadosPagos;
}
