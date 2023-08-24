package ec.edu.espe.arquitectura.examendayannasilva.controller.dto;

import ec.edu.espe.arquitectura.examendayannasilva.model.Empleados;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaRQ {

        private String ruc;
        private String razonSocial;
        private String cuentaPrincipal;
        private List<Empleados> empleados;

}
