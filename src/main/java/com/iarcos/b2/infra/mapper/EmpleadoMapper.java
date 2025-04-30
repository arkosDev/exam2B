package com.iarcos.b2.infra.mapper;

import org.springframework.beans.BeanUtils;

import com.iarcos.b2.domain.Empleado;
import com.iarcos.b2.infra.entity.EmplEnt;

public class EmpleadoMapper {
	
    public static Empleado toDomain(EmplEnt entity) {
    	final Empleado emp = new Empleado();
    	BeanUtils.copyProperties(entity, emp);
        return emp;
    }

    public static EmplEnt toEntity(Empleado domain) {
    	final EmplEnt entity = new EmplEnt();
    	BeanUtils.copyProperties(domain, entity);
        return entity;
    }

}
