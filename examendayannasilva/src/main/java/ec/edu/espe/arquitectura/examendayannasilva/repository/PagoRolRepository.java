package ec.edu.espe.arquitectura.examendayannasilva.repository;

import ec.edu.espe.arquitectura.examendayannasilva.model.PagoRol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PagoRolRepository extends MongoRepository <PagoRol, String> {
    @Query(value = "{}", fields = "{'empleadoPago': 1}")
    List<PagoRol> getAllEmpleados();

    @Query(value = "{'empleadoPago.numeroCuenta': ?0}", fields = "{'mes': 1, 'rucEmpresa': 1, 'fechaProceso': 1, 'cuentaPrincipal': 1,'valorTotal': 1,'empleadoPago': 1}")
    PagoRol findByCuentaEmpleado(String numeroCuenta);





}
