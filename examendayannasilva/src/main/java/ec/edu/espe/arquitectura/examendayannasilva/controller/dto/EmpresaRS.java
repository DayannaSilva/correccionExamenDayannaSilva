package ec.edu.espe.arquitectura.examendayannasilva.controller.dto;

import ec.edu.espe.arquitectura.examendayannasilva.model.Empleados;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EmpresaRS {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    private List<Empleados> empleados;
}
