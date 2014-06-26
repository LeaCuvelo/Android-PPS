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
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT,bttnPrSpace, bttnPrDelete;
	public TextView texto;
	private static MainActivity instance = null;
	public String mainBuffer;

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
        bttnPrSpace = (Button) findViewById(R.id.bttnPrSpace);
        bttnPrSpace.setOnClickListener(controladorEspacio);
        bttnPrDelete = (Button) findViewById(R.id.bttnPrDelete);
        bttnPrDelete.setOnClickListener(controladorBorrar);
        //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
        
        
        
        // Tomamos el valor del buffer
         mainBuffer = getIntent().getStringExtra("mainBuffer");
         texto.setText(mainBuffer);
         
         //AL DESCOMENTAR LA LÍNEA DE ABAJO, PODEMOS PROBAR SI EL TEXTVIEW SE VE COMPLETO, SCROLLEA, ETC.
         //texto.setText("AAAAAAAAAAAAAAAAAAAAAAAAAF FFSDGSDFDG                             DGSDGSGSDGSDGSDGSDGSDGSDGSDGSGSDGSDJFGJGHJGH11 dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
	}
	
	public static MainActivity getInstance(){
		if (instance == null)
						instance = new MainActivity();
		return instance;
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
	
	
	@Override protected void onDestroy(){
		super.onDestroy();
	}
	
	// Cuando hay un cambio de activity
	@Override protected void onStop(){
		super.onStop();
	}
	
	@Override protected void onResume(){
		super.onResume();
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
	
	//CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCIÓN LUEGO DE PRESIONAR EL BOTÓN.
	
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaA.class);
            activityChangeIntent.putExtra("textBufferA", texto.getText()+"");
            MainActivity.this.startActivity(activityChangeIntent);  
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaF.class);
	            activityChangeIntent.putExtra("textBufferF", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaK.class);
	            activityChangeIntent.putExtra("textBufferK", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaO.class);
	            activityChangeIntent.putExtra("textBufferO", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaT.class);
	            activityChangeIntent.putExtra("textBufferT", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click
				mainBuffer = (String) texto.getText();
				mainBuffer += ' ';
				texto.setText(mainBuffer);
			}
	};
	
	View.OnClickListener controladorBorrar = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click
			mainBuffer = (String) texto.getText();
			mainBuffer = mainBuffer.substring(0, mainBuffer.length()-1);
			texto.setText(mainBuffer);
		}
	};
	  

}
