package ec.edu.espe.arquitectura.examendayannasilva.service;

import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.PagoRolRS;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empleados;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empresa;
import ec.edu.espe.arquitectura.examendayannasilva.model.PagoRol;
import ec.edu.espe.arquitectura.examendayannasilva.repository.EmpresaRepository;
import ec.edu.espe.arquitectura.examendayannasilva.repository.PagoRolRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PagoValidacionesService {
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;

    public PagoValidacionesService(PagoRolRepository pagoRolRepository, EmpresaRepository empresaRepository) {
        this.pagoRolRepository = pagoRolRepository;
        this.empresaRepository = empresaRepository;
    }

    public PagoRolRS validarPago(String mes, String ruc, EmpleadosPagoRQ empleadoPagoRQ) {

        Integer totalTrans = 0;
        Integer errors = 0;
        Integer realValCount = 0;

        PagoRol pagoRolTmp = this.pagoRolRepository.findByCuentaEmpleado(empleadoPagoRQ.getNumeroCuenta());
        Empresa empresaTmp = this.empresaRepository.findEmpresaByEmpleados(empleadoPagoRQ.getNumeroCuenta());

        if (pagoRolTmp == null) {
            throw new RuntimeException("No existe el rol de pagos");
        } else {
            if (pagoRolTmp.getMes().equals(mes) && pagoRolTmp.getRucEmpresa().equals(ruc)) {
                for (Empleados empleados : empresaTmp.getEmpleados()) {
                    if (empleados.getNumerocuenta().equals(pagoRolTmp.getEmpleadosPagos().getNumeroCuenta())) {
                        pagoRolTmp.getEmpleadosPagos().setEstado("VAL");
                        totalTrans++;
                        realValCount = realValCount + pagoRolTmp.getEmpleadosPagos().getValor().intValue();
                        pagoRolTmp.setValorReal(BigDecimal.valueOf(realValCount));
                    } else {
                        pagoRolTmp.getEmpleadosPagos().setEstado("BAD");
                        errors++;
                    }
                }
                this.pagoRolRepository.save(pagoRolTmp);
                PagoRolRS response = transformPagoRolRS(pagoRolTmp);
                response.setTotalTransacciones(totalTrans);
                response.setErrores(errors);
                return response;
            } else {
                throw new RuntimeException("No existe el rol de pagos");
            }


        }


    }


    public List<PagoRol> obtenerEmpleados() {
        return this.pagoRolRepository.getAllEmpleados();
    }

    public PagoRolRS transformPagoRolRS(PagoRol pagoRol) {
        PagoRolRS pagoRolRS = PagoRolRS
                .builder()
                .mes(pagoRol.getMes())
                .fechaProceso(pagoRol.getFechaProceso())
                .rucEmpresa(pagoRol.getRucEmpresa())
                .cuentaPrincipal(pagoRol.getCuentaPrincipal())
                .valorTotal(pagoRol.getValorTotal())
                .valorReal(pagoRol.getValorReal())
                .build();
        return pagoRolRS;
    }
}
