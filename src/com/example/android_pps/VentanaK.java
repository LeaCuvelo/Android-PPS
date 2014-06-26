package com.example.android_pps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaK extends Activity {
	private Button bttnSeK,bttnSeL,bttnSeM,bttnSeN,bttnSeEnie,bttnPrSpace;
	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Mostramos la actividad
		setContentView(R.layout.ventanak);
		
		//Enlazamos botones con sus respectivas acciones
        bttnSeK = (Button) findViewById(R.id.bttnSeK);
        bttnSeK.setOnClickListener(controladorK);
        bttnSeL = (Button) findViewById(R.id.bttnSeL);
        bttnSeL.setOnClickListener(controladorL);
        bttnSeM = (Button) findViewById(R.id.bttnSeM);
        bttnSeM.setOnClickListener(controladorM);
        bttnSeN = (Button) findViewById(R.id.bttnSeN);
        bttnSeN.setOnClickListener(controladorN);
        bttnSeEnie = (Button) findViewById(R.id.bttnSeEnie);
        bttnSeEnie.setOnClickListener(controladorEnie);
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
	View.OnClickListener controladorK = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
			 // Tomamos el buffer K, le concatenamos K y se lo "enlazamos" al mainBuffer	        
	        String bufferK = getIntent().getStringExtra("textBufferK") ;
	        bufferK += 'K';
	        activityChangeIntent.putExtra("mainBuffer", bufferK);
			VentanaK.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorL = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
			 // Tomamos el buffer K, le concatenamos L y se lo "enlazamos" al mainBuffer	        
	        String bufferK = getIntent().getStringExtra("textBufferK") ;
	        bufferK += 'L';
	        activityChangeIntent.putExtra("mainBuffer", bufferK);
			VentanaK.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorM = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
			 // Tomamos el buffer K, le concatenamos M y se lo "enlazamos" al mainBuffer	        
	        String bufferK = getIntent().getStringExtra("textBufferK") ;
	        bufferK += 'M';
	        activityChangeIntent.putExtra("mainBuffer", bufferK);
			VentanaK.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorN = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
			 // Tomamos el buffer K, le concatenamos N y se lo "enlazamos" al mainBuffer	        
	        String bufferK = getIntent().getStringExtra("textBufferK") ;
	        bufferK += 'N';
	        activityChangeIntent.putExtra("mainBuffer", bufferK);
			VentanaK.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorEnie = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
			Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
			 // Tomamos el buffer K, le concatenamos enie y se lo "enlazamos" al mainBuffer	        
	        String bufferK = getIntent().getStringExtra("textBufferK") ;
	        bufferK += 'ñ';
	        activityChangeIntent.putExtra("mainBuffer", bufferK);
			VentanaK.this.startActivity(activityChangeIntent);
			finish();        
	    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click   
		    Intent activityChangeIntent = new Intent(VentanaK.this, MainActivity.class);
		    // Tomamos el buffer A, le concatenamos E y se lo "enlazamos" al mainBuffer
		    String bufferA = getIntent().getStringExtra("textBufferK") ;
	        bufferA += ' ';
	        activityChangeIntent.putExtra("mainBuffer", bufferA);
		    VentanaK.this.startActivity(activityChangeIntent);
		    finish();
		}
	};
}
