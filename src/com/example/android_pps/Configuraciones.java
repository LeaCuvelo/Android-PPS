package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Configuraciones extends Activity implements OnItemSelectedListener {
	
	private Spinner spinnerVelocidad;
	private Spinner spinnerGenero;
	private Button volver;
	private TextView textVelocidades;
	private TextView textGeneros;
	
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuraciones);
		this.spinnerVelocidad = (Spinner) findViewById(R.id.spinnerVelocidad);
		this.spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
		this.volver = (Button) findViewById(R.id.volver);
		volver.setOnClickListener(controladorVolver);
		this.textGeneros = (TextView) findViewById(R.id.genero);
		this.textVelocidades = (TextView) findViewById(R.id.velocidad);
		this.loadTiposDeVoces();
		this.loadVelocidades();
		
	}
	
	/**
	 * Carga de datos del spinner de voces
	 */
	private void loadTiposDeVoces(){
		//Crea un arrayAdapter usando el string array que esta en el xml
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinnerGenero.setAdapter(adapter);
		this.spinnerGenero.setClickable(false);
		this.spinnerGenero.setFocusable(false);
		this.spinnerGenero.setFocusableInTouchMode(false);
		//this.spinnerGenero.setOnItemSelectedListener(this);
	}
	
	
	/**
	 * Carga de datos del spinner de velocidad
	 */
	private void loadVelocidades(){
		//Crea un arrayAdapter usando el string array que esta en el xml
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.velocidades, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinnerVelocidad.setAdapter(adapter);
		this.spinnerVelocidad.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
			switch (parent.getId()){
				case R.id.spinnerVelocidad:  
					if (pos==0){
						MainActivity.velocidad = 'R';
						MainActivity.getTTS().setSpeechRate(1.5f);
						Toast.makeText(this, "-Rapido- seleccionado",Toast.LENGTH_SHORT).show();
						return;
					}
					else{
						if (pos==1){
							MainActivity.velocidad = 'M';
							MainActivity.getOurTts().setSpeechRate(1.0f);
							Toast.makeText(this, "-Medio- seleccionado",Toast.LENGTH_SHORT).show();
							return;
						}
						else{
							MainActivity.velocidad = 'L';
							MainActivity.getOurTts().setSpeechRate(0.5f);
							Toast.makeText(this, "-Lento- seleccionado",Toast.LENGTH_SHORT).show();
							return;
						}
						
					}
				case R.id.spinnerGenero:  
					if (pos==0){
						Toast.makeText(this, "-Masculino- seleccionado",Toast.LENGTH_LONG).show();
						return;
					}
					else{
						Toast.makeText(this, "-Femenino- seleccionado",Toast.LENGTH_LONG).show();
						return;
					}
			}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override protected void onPause(){
		super.onPause();
	}
	
	@Override protected void onRestart(){
		super.onRestart();
	}
	
	@Override protected void onDestroy(){
		super.onDestroy();
	}
	
	@Override protected void onStop(){
		super.onStop();
	}
	
	@Override protected void onResume(){
		super.onResume();
	}
	
	View.OnClickListener controladorVolver = new View.OnClickListener() {
	    public void onClick(View v) {
	    	finish();
	    }
	};
}
