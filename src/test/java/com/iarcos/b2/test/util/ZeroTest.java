package com.iarcos.b2.test.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iarcos.b2.domain.Empleado;
import com.iarcos.b2.expo.ExamExpo;
import com.iarcos.b2.util.FecAdapt;

@SpringBootTest
public class ZeroTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZeroTest.class);
	
	@Test
    public void zeroTest() throws ExamExpo {
		
		final List<Empleado> empleados = new ArrayList<>();
		empleados.add(getEmplA());
		empleados.add(getEmplB());
		
        Gson gson =  new GsonBuilder()
                .registerTypeAdapter(Date.class, new FecAdapt())
                .create();
        String json = gson.toJson(empleados);
		
        LOGGER.info(json);
    	
    }
	
	final Empleado getEmplA() {
		final Empleado empl = new Empleado();
		empl.setEdad(35);
		empl.setMaterno("Materno");
		empl.setPaterno("Paterno");
		empl.setPrimNombre("Alejandro");
		empl.setPuesto("Vendedor");
		empl.setSexo("M");
		LocalDate localDate = LocalDate.of(1990, 1, 1);
        long milliseconds = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		empl.setFechaNac(new Date(milliseconds));
		
		return empl;
	}
	
	final Empleado getEmplB() {
		final Empleado empl = new Empleado();
		empl.setEdad(25);
		empl.setMaterno("Materno");
		empl.setPaterno("Paterno");
		empl.setPrimNombre("Ana");
		empl.setSegNombre("Laura");
		empl.setPuesto("Cajera");
		empl.setSexo("F");
		LocalDate localDate = LocalDate.of(2000, 1, 1);
        long milliseconds = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		empl.setFechaNac(new Date(milliseconds));
		
		return empl;
	}
	

}
