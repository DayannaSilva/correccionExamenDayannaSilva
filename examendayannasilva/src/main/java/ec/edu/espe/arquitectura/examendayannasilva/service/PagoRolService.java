package ec.edu.espe.arquitectura.examendayannasilva.service;

import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.PagoRolRS;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empresa;
import ec.edu.espe.arquitectura.examendayannasilva.model.PagoRol;
import ec.edu.espe.arquitectura.examendayannasilva.repository.EmpresaRepository;
import ec.edu.espe.arquitectura.examendayannasilva.repository.PagoRolRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;
    public PagoRolService(PagoRolRepository pagoRolRepository) {
        this.pagoRolRepository = pagoRolRepository;
    }

    public void crear (PagoRolRQ rq) {
        try {
            PagoRol pagoRol = transformPagoRolRQ(rq);
            List<PagoRol> pagoRolList = this.pagoRolRepository.getAllEmpleados();
            Integer pagosCount = 0;
            for (PagoRol pagos : pagoRolList) {
                pagosCount = pagosCount + pagos.getEmpleadosPagos().getValor().intValue();
            }
            pagoRol.setValorTotal(BigDecimal.valueOf(pagosCount.doubleValue()));
            pagoRol.setValorReal(BigDecimal.valueOf(0.0));
            pagoRol.getEmpleadosPagos().setEstado("PEN");
            this.pagoRolRepository.save(pagoRol);
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error Pago Rol");
        }
    }
    public PagoRol transformPagoRolRQ(PagoRolRQ rq) {
        PagoRol pagoRol = PagoRol
                .builder()
                .mes(rq.getMes())
                .fechaProceso(rq.getFechaProceso())
                .rucEmpresa(rq.getRucEmpresa())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleadosPagos(rq.getEmpleadosPagos())
                .build();
        return pagoRol;
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
