package es.cursoandroid.asteroides;

import java.util.Vector;

public interface AlmacenarPuntuaciones {
	public void guardarPuntuacion(int puntos,String nombre,long fecha);
	public Vector<String> listarPuntuaciones(int cantidad);
}
