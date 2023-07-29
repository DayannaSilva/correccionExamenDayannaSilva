package ec.edu.espe.arquitectura.examendayannasilva.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
public class Empleados {
    private String cedulaIdentidad;
    private String nombres;
    private String numerocuenta;
}
