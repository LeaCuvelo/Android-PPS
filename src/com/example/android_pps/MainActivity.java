package com.example.android_pps;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Seteamos que no tenga "barra de título" la aplicación
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //Seteamos el uso de "Full screen" para la aplicación
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        //Mostramos la actividad
        setContentView(R.layout.activity_main);
        
        //Enlazamos botones
        bttnPrA = (Button) findViewById(R.id.bttnPrA);
        bttnPrA.setOnClickListener(myHandlerA);
        bttnPrF = (Button) findViewById(R.id.bttnPrF);
        bttnPrF.setOnClickListener(myHandlerF);
        bttnPrK = (Button) findViewById(R.id.bttnPrK);
        bttnPrK.setOnClickListener(myHandlerK);
        bttnPrO = (Button) findViewById(R.id.bttnPrO);
        bttnPrO.setOnClickListener(myHandlerO);
        bttnPrT = (Button) findViewById(R.id.bttnPrT);
        bttnPrT.setOnClickListener(myHandlerT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Para salir de la apliación tocando el botón "Atrás"
	public boolean onKeyDown(int keyCode, KeyEvent event){
		finish();
		return false;
	}
	
	//Manejadores (Handlers) de los botones, determinan la acción luego de presionar el botón
	View.OnClickListener myHandlerA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaA.class);
            MainActivity.this.startActivity(activityChangeIntent);
	    }
	  };
	  
	View.OnClickListener myHandlerF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaF.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
	View.OnClickListener myHandlerK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaK.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
    View.OnClickListener myHandlerO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaO.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
    };
	  
	View.OnClickListener myHandlerT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaT.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  

}
