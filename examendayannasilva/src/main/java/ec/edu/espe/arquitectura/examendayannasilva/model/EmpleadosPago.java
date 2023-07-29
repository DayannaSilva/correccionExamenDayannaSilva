package ec.edu.espe.arquitectura.examendayannasilva.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
public class EmpleadosPago {
    private String numeroCuenta;
    private BigDecimal valor;
    private String estado;
}
