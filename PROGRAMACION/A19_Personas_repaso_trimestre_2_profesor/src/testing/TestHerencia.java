package testing;

import java.util.ArrayList;
import java.util.List;

import javabean.AbstractPersona;
import javabean.Administrativo;
import javabean.Alumno;
import javabean.Profesor;

public class TestHerencia {

	public static void main(String[] args) {
		Profesor profe1 = new Profesor("50987654N","Rosa","Madrid","678678678","Cobol;C++;Java;Python;PLSQL");
		Alumno alumno1 = new Alumno("50987456Q","Eva","Sevilla","678555666", "CGS DAW");
		Administrativo admon= new Administrativo("04456456S","Carlos","Cadiz","678444111", "Gestion de Becas");
		
		System.out.println("PROFESOR\n");
		System.out.println(profe1.llamar(admon));
		System.out.println(profe1.ponerNotas());
		System.out.println(profe1.trabajar());
		
		System.out.println("\nALUMNO\n");
		System.out.println(alumno1.llamar(profe1));
		System.out.println(alumno1.hacerExamen());
		System.out.println(alumno1.trabajar());
		
		System.out.println("\nADMINISTRATIVO\n");
		System.out.println(admon.llamar(profe1));
		System.out.println(admon.gestionarMatricula());
		System.out.println(admon.trabajar());
		
		List<AbstractPersona> personas = new ArrayList<AbstractPersona>();
		personas.add(profe1);
		personas.add(alumno1);
		personas.add(admon);
		
		System.out.println("\nLISTADO DE PERSONAS\n");
		
		for (AbstractPersona persona: personas) {
			System.out.println(persona);
			System.out.println(persona.trabajar());
			System.out.println(persona.llamar(admon));
			System.out.println(persona.getDireccion());
			
			if (persona instanceof Profesor) {
				System.out.println(((Profesor)persona).ponerNotas());
			} else if (persona instanceof Alumno) {
					System.out.println(((Alumno) persona).hacerExamen());
				} else if (persona instanceof Administrativo) {
					System.out.println(((Administrativo)persona).gestionarMatricula());
				}
			
			
		}
		
		

	}

}
