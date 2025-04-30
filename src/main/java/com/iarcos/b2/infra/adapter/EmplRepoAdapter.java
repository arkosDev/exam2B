package com.iarcos.b2.infra.adapter;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iarcos.b2.app.port.out.SaveEmplPort;
import com.iarcos.b2.domain.Empleado;
import com.iarcos.b2.expo.ExamExpo;
import com.iarcos.b2.infra.entity.EmplEnt;
import com.iarcos.b2.infra.mapper.EmpleadoMapper;
import com.iarcos.b2.infra.repository.EmplRepo;

@Component
public class EmplRepoAdapter implements SaveEmplPort {

	private final EmplRepo emplRepo;

	public EmplRepoAdapter(EmplRepo emplRepo) {
		this.emplRepo = emplRepo;
	}

	@Override
	@Transactional
	public boolean saveEmpleados(List<Empleado> empleados) {
		try {
			List<EmplEnt> emplEnts = empleados.stream().map(empleado -> {
				EmplEnt emplEnt = EmpleadoMapper.toEntity(empleado);
				// emplEnt.setIdEmpl(UUID.randomUUID());
				return emplEnt;
			}).toList();

			emplRepo.saveAll(emplEnts);
			return true;
		} catch (Exception expo) {
			throw new ExamExpo(expo.getMessage());
		}
	}

	@Override
	public List<Empleado> findEmpleados() {
		try {
			final List<EmplEnt> empleados = emplRepo.findAll();
			return empleados.stream().map(EmpleadoMapper::toDomain).toList();
		} catch (Exception expo) {
			throw new ExamExpo(expo.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delEmpleado(UUID idEmpl) {
		try {
			emplRepo.deleteById(idEmpl);
			return true;
		} catch (Exception expo) {
			throw new ExamExpo(expo.getMessage());
		}
	}

	@Override
	@Transactional
	public Empleado updEmpleado(final Empleado empleado) {
		try {
			final EmplEnt empl = emplRepo.findById(empleado.getIdEmpl())
					.orElseThrow(() -> new ExamExpo("Empleado no existe"));
			
			BeanUtils.copyProperties(empleado, empl, "idEmpl");
			emplRepo.saveAndFlush(empl);
			return EmpleadoMapper.toDomain(empl);
		} catch (Exception expo) {
			throw new ExamExpo(expo.getMessage());
		}
	}
}
