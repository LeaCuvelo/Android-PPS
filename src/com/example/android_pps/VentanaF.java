package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaF extends Activity {
	private Button bttnSeF,bttnSeG,bttnSeH,bttnSeI,bttnSeJ,bttnPrSpace,bttnPrDelete;
	private TextView texto;
	private String bufferF;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Mostramos la actividad
		setContentView(R.layout.ventanaf);
		
		//Enlazamos botones con sus respectivas acciones
        bttnSeF = (Button) findViewById(R.id.bttnSeF);
        bttnSeF.setOnClickListener(controladorF);
        bttnSeG = (Button) findViewById(R.id.bttnSeG);
        bttnSeG.setOnClickListener(controladorG);
        bttnSeH = (Button) findViewById(R.id.bttnSeH);
        bttnSeH.setOnClickListener(controladorH);
        bttnSeI = (Button) findViewById(R.id.bttnSeI);
        bttnSeI.setOnClickListener(controladorI);
        bttnSeJ = (Button) findViewById(R.id.bttnSeJ);
        bttnSeJ.setOnClickListener(controladorJ);
        bttnPrSpace = (Button) findViewById(R.id.bttnPrSpace);
        bttnPrSpace.setOnClickListener(controladorEspacio);
        bttnPrDelete = (Button) findViewById(R.id.bttnPrDelete);
        bttnPrDelete.setOnClickListener(controladorBorrar);
        //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
        texto.setText(MainActivity.texto.getText());
        //Tomamos el texto del mainBuffer 
        bufferF = getIntent().getStringExtra("textBufferF") ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Evita que se vuelva a cargar la actividad cuando el telefono es rotado
	@Override public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	//Controladores de los botones, determinan la acción luego de presionar el botón
		View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
		        Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
		        // Tomamos el buffer F, le concatenamos F y se lo "enlazamos" al mainBuffer	        
		        bufferF += 'F';
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
		        VentanaF.this.startActivity(activityChangeIntent);
		        finish();
		    }
		};
			  
		View.OnClickListener controladorG = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // Tomamos el buffer F, le concatenamos G y se lo "enlazamos" al mainBuffer	        
		        bufferF += 'G';
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
			    VentanaF.this.startActivity(activityChangeIntent);
			    finish();
			}
		};
			  
		View.OnClickListener controladorH = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // Tomamos el buffer F, le concatenamos H y se lo "enlazamos" al mainBuffer	        
		        bufferF += 'H';
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
			    VentanaF.this.startActivity(activityChangeIntent);
			    finish();
			}
		};
			  
		View.OnClickListener controladorI = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // Tomamos el buffer F, le concatenamos I y se lo "enlazamos" al mainBuffer	        
		        bufferF += 'I';
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
			    VentanaF.this.startActivity(activityChangeIntent);
			    finish();
			}
		};
			  
		View.OnClickListener controladorJ = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // Tomamos el buffer F, le concatenamos J y se lo "enlazamos" al mainBuffer	        
		        bufferF += 'J';
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
			    VentanaF.this.startActivity(activityChangeIntent);
			    finish();
			}
		};
		
		View.OnClickListener controladorEspacio = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
		        activityChangeIntent.putExtra("mainBuffer", bufferF);
			    VentanaF.this.startActivity(activityChangeIntent);
			    finish();
			}
		};
		
		View.OnClickListener controladorBorrar = new View.OnClickListener() {
			public void onClick(View v) {
				    // Tomamos el buffer A, le borramos lo ultimo y se lo "enlazamos" al mainBuffer
				int longitudBuffer = bufferF.length();
				if (longitudBuffer > 0){
					if ( bufferF.charAt(longitudBuffer-1) == 'U' && bufferF.charAt(longitudBuffer-2) == 'Q'){
						bufferF = bufferF.substring(0,longitudBuffer-2);
						texto.setText(bufferF);
					}
					else{
						bufferF = bufferF.substring(0,longitudBuffer-1);
						texto.setText(bufferF);
					}
				}
			}
		};
}
