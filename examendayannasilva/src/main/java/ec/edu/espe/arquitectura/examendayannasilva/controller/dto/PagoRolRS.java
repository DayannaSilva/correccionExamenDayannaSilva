package ec.edu.espe.arquitectura.examendayannasilva.controller.dto;

import ec.edu.espe.arquitectura.examendayannasilva.model.EmpleadosPago;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class PagoRolRS {
    private String mes;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private Date fechaProceso;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;
    private Integer totalTransacciones;
    private EmpleadosPago empleadosPagos;
    private Integer Errores;
}
