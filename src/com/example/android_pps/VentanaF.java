package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class VentanaF extends Activity {
	private Button bttnSeF,bttnSeG,bttnSeH,bttnSeI,bttnSeJ;

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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Controladores de los botones, determinan la acción luego de presionar el botón
		View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
		        Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
		        // TODO: Escribir la letra F en el textField
		        VentanaF.this.startActivity(activityChangeIntent);
		      //finish();
		    }
		};
			  
		View.OnClickListener controladorG = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // TODO: Escribir la letra G en el textField
			    VentanaF.this.startActivity(activityChangeIntent);
			  //finish();
			}
		};
			  
		View.OnClickListener controladorH = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // TODO: Escribir la letra C en el textField
			    VentanaF.this.startActivity(activityChangeIntent);
			  //finish();
			}
		};
			  
		View.OnClickListener controladorI = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // TODO: Escribir la letra D en el textField
			    VentanaF.this.startActivity(activityChangeIntent);
			  //finish();
			}
		};
			  
		View.OnClickListener controladorJ = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click   
			    Intent activityChangeIntent = new Intent(VentanaF.this, MainActivity.class);
			 // TODO: Escribir la letra E en el textField
			    VentanaF.this.startActivity(activityChangeIntent);
			  //finish();
			}
		};
}
