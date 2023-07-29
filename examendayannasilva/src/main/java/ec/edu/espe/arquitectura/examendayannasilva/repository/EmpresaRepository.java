package ec.edu.espe.arquitectura.examendayannasilva.repository;

import ec.edu.espe.arquitectura.examendayannasilva.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmpresaRepository  extends MongoRepository<Empresa, String> {

    @Query(value = "{'ruc': ?0}", fields = "{'empleado': 1}")
    List<Empresa> findEmployeesByEmpresaRuc(String ruc );

    @Query(value = "{'empleados.numeroDeCuenta': ?0}", fields = "{'empleados.$': 1}")
    Empresa findEmpresaByEmpleados(String cedulaIdentidad);





}
