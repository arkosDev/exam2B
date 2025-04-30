package com.iarcos.b2.infra.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmplEnt {
    
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "idEmpl", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	@JdbcTypeCode(SqlTypes.UUID)
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

