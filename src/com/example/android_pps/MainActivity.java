package com.example.android_pps;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT;
	public static TextView texto;

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
        
        //Enlazamos botones con sus respectivas acciones
        bttnPrA = (Button) findViewById(R.id.bttnPrA);
        bttnPrA.setOnClickListener(controladorA);
        bttnPrF = (Button) findViewById(R.id.bttnPrF);
        bttnPrF.setOnClickListener(controladorF);
        bttnPrK = (Button) findViewById(R.id.bttnPrK);
        bttnPrK.setOnClickListener(controladorK);
        bttnPrO = (Button) findViewById(R.id.bttnPrO);
        bttnPrO.setOnClickListener(controladorO);
        bttnPrT = (Button) findViewById(R.id.bttnPrT);
        bttnPrT.setOnClickListener(controladorT);
        //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//onPause debe ser llamado justo antes de ir a otra actividad, y guardar todo
	@Override protected void onPause(){
		super.onPause();
	}
	
	@Override protected void onRestart(){
		super.onRestart();
	}
	
	@Override protected void onResume(){
		super.onResume();
	}
	
	@Override protected void onDestroy(){
		super.onDestroy();
	}
	
	//Evita que se vuelva a cargar la actividad cuando el telefono es rotado
	@Override public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	//Para salir de la apliación tocando el botón "Atrás"
	public boolean onKeyDown(int keyCode, KeyEvent event){
		finish();
		return false;
	}
	
	//Controladores de los botones, determinan la acción luego de presionar el botón
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaA.class);
            texto.setText(R.string.my_name);
            MainActivity.this.startActivity(activityChangeIntent);
            
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaF.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaK.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaO.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaT.class);
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  

}
