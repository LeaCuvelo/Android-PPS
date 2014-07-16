package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaA extends Activity {
	private Button bttnSeA,bttnSeB,bttnSeC,bttnSeD,bttnSeE,bttnPrSpace,bttnPrDelete;
	private TextView texto;
	private String bufferA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Mostramos la actividad
        setContentView(R.layout.ventanaa);
        
        //Enlazamos botones con sus respectivas acciones
        bttnSeA = (Button) findViewById(R.id.bttnSeA);
        bttnSeA.setOnClickListener(controladorA);
        bttnSeB = (Button) findViewById(R.id.bttnSeB);
        bttnSeB.setOnClickListener(controladorB);
        bttnSeC = (Button) findViewById(R.id.bttnSeC);
        bttnSeC.setOnClickListener(controladorC);
        bttnSeD = (Button) findViewById(R.id.bttnSeD);
        bttnSeD.setOnClickListener(controladorD);
        bttnSeE = (Button) findViewById(R.id.bttnSeE);
        bttnSeE.setOnClickListener(controladorE);
        bttnPrSpace = (Button) findViewById(R.id.bttnPrSpace);
        bttnPrSpace.setOnClickListener(controladorEspacio);
        bttnPrDelete = (Button) findViewById(R.id.bttnPrDelete);
        bttnPrDelete.setOnClickListener(controladorBorrar);
       //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
        texto.setText(MainActivity.texto.getText());
        //Tomamos el texto del mainBuffer 
        bufferA = getIntent().getStringExtra("textBufferA") ;
       
        
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
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
	        // Tomamos el buffer A, le concatenamos A y se lo "enlazamos" al mainBuffer	        
	        bufferA += 'A';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();
	        VentanaA.this.startActivity(activityChangeIntent);
	        
	    }
	};
		  
	View.OnClickListener controladorB = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos B y se lo "enlazamos" al mainBuffer
	        bufferA += 'B';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();
		    VentanaA.this.startActivity(activityChangeIntent);
		   
		}
	};
		  
	View.OnClickListener controladorC = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos C y se lo "enlazamos" al mainBuffer
	        bufferA += 'C';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();
		    VentanaA.this.startActivity(activityChangeIntent);
		    
		}
	};
		  
	View.OnClickListener controladorD = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos D y se lo "enlazamos" al mainBuffer
	        bufferA += 'D';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();
		    VentanaA.this.startActivity(activityChangeIntent);
		   
		}
	};
		  
	View.OnClickListener controladorE = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
	        bufferA += 'E';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();;
		    VentanaA.this.startActivity(activityChangeIntent);
		   
		}
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
	        finish();
		    VentanaA.this.startActivity(activityChangeIntent);
		   
		}
	};
	
	View.OnClickListener controladorBorrar = new View.OnClickListener() {
		public void onClick(View v) {
			    // Tomamos el buffer A, le borramos lo ultimo y se lo "enlazamos" al mainBuffer
			int longitudBuffer = bufferA.length();
			if (longitudBuffer > 0){
				if ( bufferA.charAt(longitudBuffer-1) == 'U' && bufferA.charAt(longitudBuffer-2) == 'Q'){
					bufferA = bufferA.substring(0,longitudBuffer-2);
					texto.setText(bufferA);
				}
				else{
					bufferA = bufferA.substring(0,longitudBuffer-1);
					texto.setText(bufferA);
				}
			}
		}
	};
}
