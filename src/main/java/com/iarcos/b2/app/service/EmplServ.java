package com.iarcos.b2.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.iarcos.b2.app.port.in.EmplUseCase;
import com.iarcos.b2.app.port.out.SaveEmplPort;
import com.iarcos.b2.domain.Empleado;

@Service
public class EmplServ implements EmplUseCase {
    
	private final SaveEmplPort savEmplPort;

    public EmplServ(SaveEmplPort savEmplPort) {
        this.savEmplPort = savEmplPort;
    }

	@Override
	public boolean createEmpleados(List<Empleado> empleados) {
		return savEmplPort.saveEmpleados(empleados);
	}

	@Override
	public boolean removEmpleado(UUID idEmpl) {
		return savEmplPort.delEmpleado(idEmpl);
	}

	@Override
	public List<Empleado> viewEmpleados() {
		return savEmplPort.findEmpleados();
	}

	@Override
	public Empleado updtEmpleado(Empleado empleado) {
		return savEmplPort.updEmpleado(empleado);
	}
}