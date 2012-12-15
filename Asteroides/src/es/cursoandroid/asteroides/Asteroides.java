package es.cursoandroid.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Asteroides extends Activity implements OnClickListener {
	
	// Atributos
	
	/** Botones de la actividad principal */	
	private Button acercadeButton = null;
	private Button salirButton = null;
	private Button configurarButton = null;
	private Button jugarButton = null;
	private Button puntuacionesButton = null;
	
	/** Objeto para mostrar las preferencias seleccionadas del usaurio */
	private SharedPreferences preferenciasUsuario = null;
	
	/** Objeto para almacenar las puntuaciones */
	public static AlmacenarPuntuaciones almacenPuntuaciones = new AlmacenarPuntuacionesArray();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        acercadeButton = (Button)findViewById(R.id.acercadeButton);        
        acercadeButton.setOnClickListener(this);
        salirButton = (Button)findViewById(R.id.salirButton);
        salirButton.setOnClickListener(this);
        configurarButton = (Button)findViewById(R.id.configurarButton);
        configurarButton.setOnClickListener(this);
        jugarButton = (Button)findViewById(R.id.jugarButton);
        jugarButton.setOnClickListener(this);
        puntuacionesButton = (Button)findViewById(R.id.puntuacionesButton);
        puntuacionesButton.setOnClickListener(this);
    }
    
    /** Metodo que arranca la actividad Acerca de */
    public void lanzarActividadAcerca() {    	
    	Intent i = new Intent(this,Acercade.class);
    	startActivity(i);
    }
    
    /** Metodo que arranca la actividad Salir */
    public void lanzarActividadSalir() {    	
    	finish();
    }
    
    /** Metodo que arranca la actividad Puntuaciones */
    public void lanzarPuntuaciones() {    	
    	Intent i = new Intent(this,Puntuaciones.class);
    	startActivity(i);
    }
    
    /** Metodo que arranca la actividad Preferencias */
    public void lanzarActividadPreferencias() {    	
    	Intent i = new Intent(this,Preferencias.class);
    	startActivity(i);
    }
    
    /** Muestra las preferencias seleccionadas por el usuario */
    public void mostrarPreferencias() {    	
    	preferenciasUsuario = getSharedPreferences("es.cursoandroid.asteroides_preferences",MODE_PRIVATE);
    	String s = "Musica: " +preferenciasUsuario.getBoolean("musica",true) +
    			", Gráficos: " +preferenciasUsuario.getString("graficos","?") +
    			", Fragmentos: " +preferenciasUsuario.getString("fragmentos","?") +
    			", Multijugador: " +preferenciasUsuario.getBoolean("multijugador",false) +
    			", Número jugadores: " +preferenciasUsuario.getString("jugadores","?") +
    			", Tipo conexión: " +preferenciasUsuario.getString("conexion","?");
    	Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    /** Callback al hacer click sobre un boton de la actividad principal */
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.acercadeButton:
			lanzarActividadAcerca();			
			break;
		case R.id.salirButton:
			lanzarActividadSalir();			
			break;
		case R.id.configurarButton:			
			lanzarActividadPreferencias();			
			break;
		case R.id.jugarButton:			
			mostrarPreferencias();			
			break;
		case R.id.puntuacionesButton:			
			lanzarPuntuaciones();			
			break;
		default:
			break;
		}		   			
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu,menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.acercaDe:
			lanzarActividadAcerca();
			break;
		case R.id.config:
			lanzarActividadPreferencias();
			break;
		default:
			break;
		}
		return true;
	}
}