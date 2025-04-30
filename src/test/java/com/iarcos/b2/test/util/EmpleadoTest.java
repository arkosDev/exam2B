package com.iarcos.b2.test.util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iarcos.b2.domain.Empleado;
import com.iarcos.b2.domain.EmpleadoReq;
import com.iarcos.b2.expo.ExamExpo;
import com.iarcos.b2.util.FecAdapt;

@SpringBootTest
@AutoConfigureMockMvc
public class EmpleadoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void saveTest() throws ExamExpo {

		final List<Empleado> empleados = new ArrayList<>();
		empleados.add(getEmplA());
		empleados.add(getEmplB());

		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new FecAdapt()).create();
		String json = gson.toJson(empleados);

		LOGGER.info(json);
		try {
			this.mockMvc.perform(post("/empleados").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk());

		} catch (Exception expo) {
			LOGGER.error(expo.getMessage());
		}
	}

	@Test
	public void viewTest() throws ExamExpo {

		try {
			this.mockMvc.perform(get("/empleados").accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
					.andExpect(status().isOk());

		} catch (Exception expo) {
			LOGGER.error(expo.getMessage());
		}
	}
	
	@Test
	public void removTest() throws ExamExpo {

		try {
			final EmpleadoReq empl = new EmpleadoReq();
			empl.setEmpleado("35bed770-c3df-40f3-b6e8-572c5e28baf9");
			
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new FecAdapt()).create();
			String json = gson.toJson(empl);
			
			this.mockMvc.perform(delete("/empleados").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk());

		} catch (Exception expo) {
			LOGGER.error(expo.getMessage());
		}
	}
	
	@Test
	public void actTest() throws ExamExpo {

		try {
			final Empleado empl = getEmplA();
			empl.setIdEmpl(UUID.fromString("f4f8261d-1149-4412-b248-1033e37dce10"));
			empl.setSegNombre("Update");
			
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new FecAdapt()).create();
			String json = gson.toJson(empl);
			
			this.mockMvc.perform(put("/empleados").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk());

		} catch (Exception expo) {
			LOGGER.error(expo.getMessage());
		}
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
