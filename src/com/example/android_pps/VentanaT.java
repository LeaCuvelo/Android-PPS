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
	private Button bttnSeT,bttnSeU,bttnSeV,bttnSeX,bttnSeY;
	private TextView texto;

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
	View.OnClickListener controladorT = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // TODO: Escribir la letra T en el textField
	        
	   	 // Tomamos el buffer T, le concatenamos T y se lo "enlazamos" al mainBuffer	        
	        String bufferT = getIntent().getStringExtra("textBufferT") ;
	        bufferT += 'T';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        
	        VentanaT.this.startActivity(activityChangeIntent);
	        finish();
	    }
	};
	
	View.OnClickListener controladorU = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // TODO: Escribir la letra U en el textField
	        
	     // Tomamos el buffer T, le concatenamos U y se lo "enlazamos" al mainBuffer	        
	        String bufferT = getIntent().getStringExtra("textBufferT") ;
	        bufferT += 'U';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        
	        
	        VentanaT.this.startActivity(activityChangeIntent);
	        finish();
	    }
	};
	
	View.OnClickListener controladorV = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // TODO: Escribir la letra V en el textField
	        
	     // Tomamos el buffer T, le concatenamos V y se lo "enlazamos" al mainBuffer	        
	        String bufferT = getIntent().getStringExtra("textBufferT") ;
	        bufferT += 'V';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        
	        VentanaT.this.startActivity(activityChangeIntent);
	        finish();
	    }
	};
	
	View.OnClickListener controladorX = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // TODO: Escribir la letra T en el textField
	        
	     // Tomamos el buffer T, le concatenamos X y se lo "enlazamos" al mainBuffer	        
	        String bufferT = getIntent().getStringExtra("textBufferT") ;
	        bufferT += 'X';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        
	        VentanaT.this.startActivity(activityChangeIntent);
	        finish();
	    }
	};
	
	View.OnClickListener controladorY = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
	        Intent activityChangeIntent = new Intent(VentanaT.this, MainActivity.class);
	        // TODO: Escribir la letra T en el textField
	        
	     // Tomamos el buffer T, le concatenamos Y y se lo "enlazamos" al mainBuffer	        
	        String bufferT = getIntent().getStringExtra("textBufferT") ;
	        bufferT += 'Y';
	        activityChangeIntent.putExtra("mainBuffer", bufferT);
	        
	        VentanaT.this.startActivity(activityChangeIntent);
	        finish();
	    }
	};
}
