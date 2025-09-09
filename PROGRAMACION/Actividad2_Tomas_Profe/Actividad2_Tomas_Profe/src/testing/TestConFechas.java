package testing;

import java.time.LocalDate;
import java.time.LocalTime;

import javabean.FiestaConLocalDateTime;

public class TestConFechas {

	public static void main(String[] args) {
		FiestaConLocalDateTime fiesta1 = new FiestaConLocalDateTime("Cumple de Blas", "Madrid", 320, 600, 100, 
																	LocalDate.parse("2024-11-30"), LocalTime.parse("19:00:00"));
		System.out.println(fiesta1);

	}

}
