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
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT,bttnPrSpace,bttnPrDelete,bttnPrPoint;
	public static TextView texto;
	private static MainActivity instance = null;
	public String mainBuffer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Seteamos que no tenga "barra de t�tulo" la aplicaci�n
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //Seteamos el uso de "Full screen" para la aplicaci�n
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
        bttnPrDelete.setOnClickListener(controladorBorrar1);
       // bttnPrDelete.setOnLongClickListener(controladorBorrar2);
        bttnPrPoint = (Button) findViewById(R.id.bttnPrPoint);
        bttnPrPoint.setOnClickListener(controladorPunto);
        //Enlazamos el textView
        texto = (TextView) findViewById(R.id.textView);
        
        
        
        // Tomamos el valor del buffer
         mainBuffer = getIntent().getStringExtra("mainBuffer");
         texto.setText(mainBuffer);
         
         //AL DESCOMENTAR LA L�NEA DE ABAJO, PODEMOS PROBAR SI EL TEXTVIEW SE VE COMPLETO, SCROLLEA, ETC.
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
	
	//Para salir de la apliaci�n tocando el bot�n "Atr�s"
	public boolean onKeyDown(int keyCode, KeyEvent event){
		finish();
		return false;
	}
	
	//CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCI�N LUEGO DE PRESIONAR EL BOT�N.
	
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click   
            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaA.class);
            activityChangeIntent.putExtra("textBufferA", texto.getText()+"");
            MainActivity.this.startActivity(activityChangeIntent);  
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaF.class);
	            activityChangeIntent.putExtra("textBufferF", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaK.class);
	            activityChangeIntent.putExtra("textBufferK", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaO.class);
	            activityChangeIntent.putExtra("textBufferO", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click   
	            Intent activityChangeIntent = new Intent(MainActivity.this, VentanaT.class);
	            activityChangeIntent.putExtra("textBufferT", texto.getText()+"");
	            MainActivity.this.startActivity(activityChangeIntent);
		    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
			public void onClick(View v) {
				//Acci�n al hacer click
				mainBuffer = (String) texto.getText();
				mainBuffer += ' ';
				texto.setText(mainBuffer);
			}
	};
	
	View.OnClickListener controladorBorrar1 = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click
			mainBuffer = (String) texto.getText();
			int longitudBuffer = mainBuffer.length();
			if (longitudBuffer > 0 ){
					if ( (longitudBuffer > 1) && (mainBuffer.charAt(longitudBuffer-1) == 'U') && (mainBuffer.charAt(longitudBuffer-2) == 'Q')){
						mainBuffer = mainBuffer.substring(0,longitudBuffer-2);
						texto.setText(mainBuffer);
					}
					else{
						mainBuffer = mainBuffer.substring(0,longitudBuffer-1);
						texto.setText(mainBuffer);
					}
				}
			/*if (longitudBuffer > 0){
					mainBuffer = mainBuffer.substring(0,longitudBuffer-1);
					texto.setText(mainBuffer);
					}
			}*/
		}
		
	};
	
	/*View.OnLongClickListener controladorBorrar2 = new View.OnLongClickListener() {
		public boolean onLongClick(View v){
			//Acci�n al mantener presionado
			mainBuffer = "";
			texto.setText(mainBuffer);
			return true;
		}
	};*/
	
	View.OnClickListener controladorPunto = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click
			mainBuffer = (String) texto.getText();
			mainBuffer += '.';
			texto.setText(mainBuffer);
		}
	};
}
