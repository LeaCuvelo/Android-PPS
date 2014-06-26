package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaO extends Activity {
	private Button bttnSeO,bttnSeP,bttnSeQ,bttnSeR,bttnSeS,bttnPrSpace;
	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Mostramos la actividad
		setContentView(R.layout.ventanao);
		
		//Enlazamos botones con sus respectivas acciones
        bttnSeO = (Button) findViewById(R.id.bttnSeO);
        bttnSeO.setOnClickListener(controladorO);
        bttnSeP = (Button) findViewById(R.id.bttnSeP);
        bttnSeP.setOnClickListener(controladorP);
        bttnSeQ = (Button) findViewById(R.id.bttnSeQ);
        bttnSeQ.setOnClickListener(controladorQ);
        bttnSeR = (Button) findViewById(R.id.bttnSeR);
        bttnSeR.setOnClickListener(controladorR);
        bttnSeS = (Button) findViewById(R.id.bttnSeS);
        bttnSeS.setOnClickListener(controladorS);	
        bttnPrSpace = (Button) findViewById(R.id.bttnPrSpace);
        bttnPrSpace.setOnClickListener(controladorEspacio);
        //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
        texto.setText(MainActivity.texto.getText());
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
	View.OnClickListener controladorO = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			 // Tomamos el buffer O, le concatenamos O y se lo "enlazamos" al mainBuffer	        
	        String bufferO = getIntent().getStringExtra("textBufferO") ;
	        bufferO += 'O';
	        activityChangeIntent.putExtra("mainBuffer", bufferO);
			VentanaO.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorP = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			 // Tomamos el buffer O, le concatenamos P y se lo "enlazamos" al mainBuffer	        
	        String bufferO = getIntent().getStringExtra("textBufferO") ;
	        bufferO += 'P';
	        activityChangeIntent.putExtra("mainBuffer", bufferO);
			VentanaO.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorQ = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			 // Tomamos el buffer O, le concatenamos Q y se lo "enlazamos" al mainBuffer	        
	        String bufferO = getIntent().getStringExtra("textBufferO") ;
	        bufferO += 'Q';
	        activityChangeIntent.putExtra("mainBuffer", bufferO);
			VentanaO.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorR = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			 // Tomamos el buffer O, le concatenamos R y se lo "enlazamos" al mainBuffer	        
	        String bufferO = getIntent().getStringExtra("textBufferO") ;
	        bufferO += 'R';
	        activityChangeIntent.putExtra("mainBuffer", bufferO);
			VentanaO.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorS = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			 // Tomamos el buffer O, le concatenamos S y se lo "enlazamos" al mainBuffer	        
	        String bufferO = getIntent().getStringExtra("textBufferO") ;
	        bufferO += 'S';
	        activityChangeIntent.putExtra("mainBuffer", bufferO);
			VentanaO.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
		    String bufferA = getIntent().getStringExtra("textBufferO") ;
	        bufferA += ' ';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
		    VentanaO.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
}
