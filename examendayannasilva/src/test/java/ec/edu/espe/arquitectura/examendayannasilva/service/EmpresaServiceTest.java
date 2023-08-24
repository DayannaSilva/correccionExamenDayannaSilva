package ec.edu.espe.arquitectura.examendayannasilva.service;


import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empleados;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empresa;
import ec.edu.espe.arquitectura.examendayannasilva.repository.EmpresaRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceTest {
    @Mock
    private EmpresaRepository empresaRepository;
    @InjectMocks
    private EmpresaService empresaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void empresaServiceCreateEmpresaRQ() {
        Empleados empleado1 = new Empleados(
                "1725417896",
                "Dayanna",
                "123456789"
        );
        Empleados empleado2 = new Empleados(
                "1725412512",
                "Fernanda",
                "123456785"
        );
        List<Empleados> empleadosRQ = new ArrayList<>();
        empleadosRQ.add(empleado1);
        empleadosRQ.add(empleado2);

        EmpresaRQ mockEmpresaRQ = EmpresaRQ.builder()
                .ruc("12345")
                .razonSocial("Empresa 1")
                .cuentaPrincipal("123456789")
                .empleados(empleadosRQ)
                .build();
        Empresa mockEmpresa = Empresa.builder()
                .ruc("12345")
                .razonSocial("Empresa 1")
                .cuentaPrincipal("123456789")
                .empleados(empleadosRQ)
                .build();

        when(empresaRepository.save(any())).thenReturn(mockEmpresa);
        empresaService.createEmpresa(mockEmpresaRQ);
        verify(empresaRepository, times(1)).save(mockEmpresa);
    }
    @Test
    public void empresaServiceCreateEmpresaRQFail(){
        Empleados empleado1 = new Empleados(
                "1725417896",
                "Dayanna",
                "123456789"
        );
        Empleados empleado2 = new Empleados(
                "1725412512",
                "Fernanda",
                "123456785"
        );
        List<Empleados> empleadosRQ = new ArrayList<>();
        empleadosRQ.add(empleado1);
        empleadosRQ.add(empleado2);

        EmpresaRQ mockEmpresaRQ = EmpresaRQ.builder()
                .ruc("12345")
                .razonSocial("Empresa 1")
                .cuentaPrincipal("123456789")
                .empleados(empleadosRQ)
                .build();

        when(empresaRepository.save(any())).thenThrow(new RuntimeException("Error al guardar la empresa"));
        Assertions.assertThrows(RuntimeException.class, () -> {
            empresaService.createEmpresa(mockEmpresaRQ);
        });


    }


}
