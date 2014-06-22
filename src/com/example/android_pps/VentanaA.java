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
	private Button bttnSeA,bttnSeB,bttnSeC,bttnSeD,bttnSeE;
	private TextView texto;
	
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
	
	//Controladores de los botones, determinan la acci�n luego de presionar el bot�n
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
	        // TODO: Escribir la letra A en el textField
	        //MainActivity.texto.append("A");
	        VentanaA.this.startActivity(activityChangeIntent);
	        finish();
	        
	    }
	};
		  
	View.OnClickListener controladorB = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		    // TODO: Escribir la letra B en el textField
		    VentanaA.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
		  
	View.OnClickListener controladorC = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		 // TODO: Escribir la letra C en el textField
		    VentanaA.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
		  
	View.OnClickListener controladorD = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		 // TODO: Escribir la letra D en el textField
		    VentanaA.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
		  
	View.OnClickListener controladorE = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaA.this, MainActivity.class);
		 // TODO: Escribir la letra E en el textField
		    VentanaA.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
}
