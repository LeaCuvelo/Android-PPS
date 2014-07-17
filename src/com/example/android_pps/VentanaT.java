package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaT extends Activity {
	private Button bttnSeT,bttnSeU,bttnSeV,bttnSeX,bttnSeY,bttnPrSpace,bttnPrDelete;
	private TextView texto;
	private String bufferT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Mostramos la actividad
        setContentView(R.layout.ventanat);
       
        //PARA EL GIT
        
        //Enlazamos botones con sus respectivas acciones
        bttnSeT = (Button) findViewById(R.id.bttnSeT);
        bttnSeT.setOnClickListener(controladorT);
        bttnSeU = (Button) findViewById(R.id.bttnSeU);
        bttnSeU.setOnClickListener(controladorU);
        bttnSeV = (Button) findViewById(R.id.bttnSeV);
        bttnSeV.setOnClickListener(controladorV);
        bttnSeX = (Button) findViewById(R.id.bttnSeX);
        bttnSeX.setOnClickListener(controladorX);
        bttnSeY = (Button) findViewById(R.id.bttnSeY);
        bttnSeY.setOnClickListener(controladorY);
        bttnPrSpace = (Button) findViewById(R.id.bttnPrSpace);
        bttnPrSpace.setOnClickListener(controladorEspacio);
        bttnPrDelete = (Button) findViewById(R.id.bttnPrDelete);
        bttnPrDelete.setOnClickListener(controladorBorrarCaracter);
        bttnPrDelete.setOnLongClickListener(controladorBorrarTodo);
        //Enlazamos el textView        
        texto = (TextView) findViewById(R.id.textView);
        texto.setText(MainActivity.texto.getText());
        //Tomamos el texto del mainBuffer 
        bufferT = getIntent().getStringExtra("textBufferT") ;
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
	
	//Controladores de los botones, determinan la acci�n luego de presionar el bot�n
	View.OnClickListener controladorT = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	   	    // Tomamos el buffer T, le concatenamos T y se lo "enlazamos" al mainBuffer	        
	        bufferT += 'T';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish(); 
	        VentanaT.this.startActivity(activityChangeIntent);
	    }
	};
	
	View.OnClickListener controladorU = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // Tomamos el buffer T, le concatenamos U y se lo "enlazamos" al mainBuffer	        
	        bufferT += 'U';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish(); 
	        VentanaT.this.startActivity(activityChangeIntent);
	    }
	};
	
	View.OnClickListener controladorV = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // Tomamos el buffer T, le concatenamos V y se lo "enlazamos" al mainBuffer	        
	        bufferT += 'V';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish(); 
	        VentanaT.this.startActivity(activityChangeIntent);
	    }
	};
	
	View.OnClickListener controladorX = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // Tomamos el buffer T, le concatenamos X y se lo "enlazamos" al mainBuffer	        
	        bufferT += 'X';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish(); 
	        VentanaT.this.startActivity(activityChangeIntent);
	    }
	};
	
	View.OnClickListener controladorY = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // Tomamos el buffer T, le concatenamos Y y se lo "enlazamos" al mainBuffer	        
	        bufferT += 'Y';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish(); 
	        VentanaT.this.startActivity(activityChangeIntent);
	    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        finish();
		    VentanaT.this.startActivity(activityChangeIntent);
		}
	};
	
	View.OnClickListener controladorBorrarCaracter = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click
			int longitudBuffer = bufferT.length();
			if (longitudBuffer > 0 ){
					if ( (longitudBuffer > 1) && (bufferT.charAt(longitudBuffer-1) == 'U') && (bufferT.charAt(longitudBuffer-2) == 'Q')){
						bufferT = bufferT.substring(0,longitudBuffer-2);
						texto.setText(bufferT);
					}
					else{
						bufferT = bufferT.substring(0,longitudBuffer-1);
						texto.setText(bufferT);
					}
				}
		}
		
	};
	
	View.OnLongClickListener controladorBorrarTodo = new View.OnLongClickListener() {
		public boolean onLongClick(View v){
			//Acci�n al mantener presionado
			bufferT = "";
			texto.setText(bufferT);
			return true;
		}
	};
}
