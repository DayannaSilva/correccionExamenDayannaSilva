package ec.edu.espe.arquitectura.examendayannasilva.service;

import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examendayannasilva.controller.dto.EmpresaRS;
import ec.edu.espe.arquitectura.examendayannasilva.model.Empresa;
import ec.edu.espe.arquitectura.examendayannasilva.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;

    }
    public void createEmpresa(EmpresaRQ empresaRQ) {
        try{
            Empresa empresa = this.transformEmpresaRQ(empresaRQ);
            this.empresaRepository.save(empresa);
        }catch (RuntimeException rte) {
            throw new RuntimeException("Error al registrar la empresa");
        }

    }
    public Empresa transformEmpresaRQ (EmpresaRQ rq){
        Empresa empresa = Empresa
                .builder()
                .ruc(rq.getRuc())
                .razonSocial(rq.getRazonSocial())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleados(rq.getEmpleados())
                .build();
        return empresa;
    }



}
