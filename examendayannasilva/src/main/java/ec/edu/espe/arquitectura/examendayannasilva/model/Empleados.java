package ec.edu.espe.arquitectura.examendayannasilva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleados {
    private String cedulaIdentidad;
    private String nombres;
    private String numerocuenta;
}
