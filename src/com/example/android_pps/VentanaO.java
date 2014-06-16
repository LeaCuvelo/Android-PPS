package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class VentanaO extends Activity {
	private Button bttnSeO,bttnSeP,bttnSeQ,bttnSeR,bttnSeS;
	
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Controladores de los botones, determinan la acción luego de presionar el botón
	View.OnClickListener controladorO = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			// TODO: Escribir la letra K en el textField
			VentanaO.this.startActivity(activityChangeIntent);
			        
	    }
	};
	
	View.OnClickListener controladorP = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			// TODO: Escribir la letra K en el textField
			VentanaO.this.startActivity(activityChangeIntent);
			        
	    }
	};
	
	View.OnClickListener controladorQ = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			// TODO: Escribir la letra K en el textField
			VentanaO.this.startActivity(activityChangeIntent);
			        
	    }
	};
	
	View.OnClickListener controladorR = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			// TODO: Escribir la letra K en el textField
			VentanaO.this.startActivity(activityChangeIntent);
			        
	    }
	};
	
	View.OnClickListener controladorS = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaO.this, MainActivity.class);
			// TODO: Escribir la letra K en el textField
			VentanaO.this.startActivity(activityChangeIntent);
			        
	    }
	};
}
