package com.iarcos.b2.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    
	private UUID idEmpl;
    private String primNombre;
    private String segNombre;
    private String paterno;
    private String materno;
    private Integer edad;
    private String sexo;
    
    private java.util.Date fechaNac;
    
    private String puesto;

}

