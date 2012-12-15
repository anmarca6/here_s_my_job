package es.cursoandroid.asteroides;

import java.util.Vector;

public class AlmacenarPuntuacionesArray implements AlmacenarPuntuaciones {
	
	private Vector<String> puntuaciones;
	
	public AlmacenarPuntuacionesArray() {
		puntuaciones = new Vector<String>();
		puntuaciones.add("123000 Leo Martínez");
		puntuaciones.add("111000 Angel Martínez");
		puntuaciones.add("011000 Noelia Álvarez");
	}

	public void guardarPuntuacion(int puntos, String nombre,long fecha) {
		puntuaciones.add(0,puntos + "" + nombre);
		
	}

	public Vector<String> listarPuntuaciones(int cantidad) {		
		return puntuaciones;
	}

}
