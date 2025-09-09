package testing;

import javabean.AbstractPersona;
import javabean.Alumno;
import javabean.Profesor;
import negocio.InstitutoDao;
import negocio.InstitutoDaoImpl;

public class TestInstituto {
	
	private static InstitutoDao idao = new InstitutoDaoImpl();

	public static void main(String[] args) {
	 	todos();
	  	alta();
	 	eliminar();
	 	porNif();
		porTipoPersona();

	}
	
	public static void todos() {
		System.out.println("\nLISTADO DE TODAS PERSONAS\n");
		for (AbstractPersona persona: idao.buscarTodas()) {
			System.out.println(persona);
		}
		
		
	}
	
	public static void alta() {
		System.out.println("\nALTA PERSONAS\n");
		Profesor profe1 = new Profesor("51287654X","Ezequiel","Soria","678678678","C++;Java;Python");
		Profesor profe2 = new Profesor("50987654N","Rosa","Madrid","678678678","Cobol;C++;Java;Python;PLSQL");
		
		System.out.println("Prof1 true : " + idao.altaPersona(profe1));
		System.out.println("Prof1 false : " + idao.altaPersona(profe2));
		
		todos();
		
		
		
		
	}
	public static void eliminar() {
		System.out.println("\nELIMINAR PERSONAS\n");
		Profesor profe1 = new Profesor("51287654X","Ezequiel","Soria","678678678","C++;Java;Python");
		Profesor profe2 = new Profesor("44444444G","Paco","Madrid","678678678","Cobol;C++;Java;Python;PLSQL");
		
		System.out.println("Prof1 true : " + idao.eliminarPersona(profe1));
		System.out.println("Prof2 false : " + idao.eliminarPersona(profe2));
		
		todos();
		
	}
	
	public static void porNif() {
		System.out.println("\nPOR NIF\n");
		
		AbstractPersona persona = idao.buscarPorNif("33987456R");
		
//		persona = 
		
		if (persona != null)
			System.out.println(persona.getDireccion());
		else
			System.out.println("Esta persona no existe");
		
		
		
		System.out.println("EXISTE : " + idao.buscarPorNif("50987456Q"));
		System.out.println("NOOO EXISTE : " + idao.buscarPorNif("33987456R"));
		
		
	}

	public static void porTipoPersona() {
		
		System.out.println("\nPOR TIPO DE PERSONA\n");
		
		for (AbstractPersona persona: idao.buscarPersonasPorTipo("Alumno")) {
			if (persona instanceof Alumno)
				System.out.println(((Alumno) persona).getCurso());
		}
			
		
		
	}

}
