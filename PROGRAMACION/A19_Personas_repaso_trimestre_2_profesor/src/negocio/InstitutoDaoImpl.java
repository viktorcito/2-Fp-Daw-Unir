package negocio;

import java.util.ArrayList;
import java.util.List;

import javabean.AbstractPersona;
import javabean.Administrativo;
import javabean.Alumno;
import javabean.Profesor;

public class InstitutoDaoImpl implements InstitutoDao{
	
	private List<AbstractPersona> lista;
	
	public InstitutoDaoImpl() {
		lista = new ArrayList<AbstractPersona>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		Profesor profe1 = new Profesor("50987654N","Rosa","Madrid","678678678","Cobol;C++;Java;Python;PLSQL");
		Alumno alumno1 = new Alumno("50987456Q","Eva","Sevilla","678555666", "CGS DAW");
		Administrativo admon= new Administrativo("04456456S","Carlos","Cadiz","678444111", "Gestion de Becas");
		lista.add(profe1);
		lista.add(alumno1);
		lista.add(admon);
	}

	@Override
	public boolean altaPersona(AbstractPersona persona) {
		if (lista.contains(persona))
			return false;
		else
			return lista.add(persona);
	}

	@Override
	public boolean eliminarPersona(AbstractPersona persona) {
		// TODO Auto-generated method stub
		return lista.remove(persona);
	}

	@Override
	public AbstractPersona buscarPorNif(String nif) {
		for (AbstractPersona persona: lista) {
			if (persona.getNif().equals(nif))
				return persona;
		}
		return null;
	}

	@Override
	public List<AbstractPersona> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<AbstractPersona> buscarPersonasPorTipo(String tipoPersona) {
		List<AbstractPersona> aux = new ArrayList<AbstractPersona>();
		switch(tipoPersona) {
		case "Alumno":
			for (AbstractPersona persona: lista) {
				if (persona instanceof Alumno)
					aux.add(persona);
			}
			break;
		case "Profesor":
			for (AbstractPersona persona: lista) {
				if (persona instanceof Profesor)
					aux.add(persona);
			}
			break;
		case "Administrativo":
			for (AbstractPersona persona: lista) {
				if (persona instanceof Administrativo)
					aux.add(persona);
			}
			break;
		default:
			return null;
		}
		
		return aux;
	}
	
	
	
	

}
