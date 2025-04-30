package com.iarcos.b2.app.port.out;

import java.util.List;
import java.util.UUID;

import com.iarcos.b2.domain.Empleado;

public interface SaveEmplPort {
    
	boolean saveEmpleados(final List<Empleado> empleados);
	
	List<Empleado> findEmpleados();
	
	boolean delEmpleado(final UUID idEmpl);
	
	Empleado updEmpleado(final Empleado empleado);
}
