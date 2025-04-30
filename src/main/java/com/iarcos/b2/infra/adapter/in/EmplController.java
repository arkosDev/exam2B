package com.iarcos.b2.infra.adapter.in;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iarcos.b2.app.port.in.EmplUseCase;
import com.iarcos.b2.domain.Empleado;
import com.iarcos.b2.domain.EmpleadoReq;
import com.iarcos.b2.domain.MssgResp;

@RestController
@RequestMapping("/empleados")
public class EmplController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmplController.class);

	private final EmplUseCase emplUseCase;

	public EmplController(EmplUseCase emplUseCase) {
		this.emplUseCase = emplUseCase;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createEmpleado(@RequestBody List<Empleado> empleados) {

		LOGGER.info("empleados-post");

		final MssgResp response = new MssgResp();

		if (emplUseCase.createEmpleados(empleados)) {
			response.setMessage("Empleados creados");
			response.setStatusCode(1);
		} else {
			response.setStatusCode(0);
			response.setMessage("Empleados no creados");
		}

		response.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		return ResponseEntity.ok(response);
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> viewEmpleado() {
		LOGGER.info("empleados-get");
		return ResponseEntity.ok(emplUseCase.viewEmpleados());
	}

	@DeleteMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> removeEmpleado(@RequestBody EmpleadoReq emplReq) {
		LOGGER.info("empleados-delete");
		final MssgResp response = new MssgResp();
		response.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		try {
			response.setMessage("Empleado Borrado");
			response.setStatusCode(1);
			emplUseCase.removEmpleado(UUID.fromString(emplReq.getEmpleado()));
			return ResponseEntity.ok(response);
		} catch (Exception expo) {
			response.setStatusCode(0);
			response.setMessage("Error al eliminar empleado");
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(expo.getMessage());
		}
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actualEmpleado(@RequestBody Empleado empleado) {
		LOGGER.info("empleados-put");
		final MssgResp response = new MssgResp();
		response.setTimestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		try {
			if(null == empleado.getIdEmpl() ) {
				response.setMessage("Falta ID de Empleado");
				response.setStatusCode(0);
				return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(response);
			}
			
			response.setMessage("Empleado Actualizado");
			response.setStatusCode(1);
			return ResponseEntity.ok(emplUseCase.updtEmpleado(empleado));
		} catch (Exception expo) {
			response.setStatusCode(0);
			response.setMessage("Error al actualizar mensaje");
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(expo.getMessage());
		}
	}
}
