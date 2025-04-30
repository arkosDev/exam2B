package com.iarcos.b2.app.port.in;

import java.util.List;
import java.util.UUID;

import com.iarcos.b2.domain.Empleado;

public interface EmplUseCase {
    boolean createEmpleados(List<Empleado> empleados);
    
    boolean removEmpleado(UUID idEmpl);
    
    List<Empleado> viewEmpleados();
    
    Empleado updtEmpleado(Empleado empleado);
}
