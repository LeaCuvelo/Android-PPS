package com.example.android_pps;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  implements OnInitListener{
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT,bttnPrSpace,bttnPrDelete,bttnPrPoint,bttnPrSI,bttnPrNO;
	private int nroVentana = 1; //1=Principal;2=ventanaA;3=ventanaF;4=ventanaK;5=ventanaO;6=ventanaT;
	public String mainBuffer;
	public static TextView texto;
	private TextToSpeech ourTts;
	

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
        bttnPrDelete.setOnClickListener(controladorBorrarCaracter);
        bttnPrDelete.setOnLongClickListener(controladorBorrarTodo);
        bttnPrPoint = (Button) findViewById(R.id.bttnPrPoint);
        bttnPrPoint.setOnClickListener(controladorPunto);
        bttnPrSI = (Button) findViewById(R.id.bttnPrSI);
        bttnPrSI.setOnClickListener(controladorSI);
        bttnPrNO = (Button) findViewById(R.id.bttnPrNO);
        bttnPrNO.setOnClickListener(controladorNO);

        //Enlazamos el textView y lo dejamos en blanco
        //TODO: Cambiar twxtView por editText tener cuidado en la activity main, y mirar todo bien aqui en el .java
        texto = (TextView) findViewById(R.id.textView);
        texto.setText("");
     
        //Instanciamos nuestro TTS
        ourTts = new TextToSpeech(this,this);
        
        //Cargamos el texto que se presenta inicialmente en los botones
        bttnPrA.setText("A");
        bttnPrF.setText("F");
        bttnPrK.setText("K");
        bttnPrO.setText("O");
        bttnPrT.setText("T");
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
		ourTts.shutdown();
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
	
	//Verificamos si se puede y seteamos idioma español a ourTts
	//TODO: Verificar si se puede cambiar ESP por ARG y mejora la voz
	@Override
	public void onInit(int status) {
		if (status==TextToSpeech.SUCCESS) {
			ourTts.setLanguage(new Locale("spa","ESP"));
		} else {
			ourTts = null;
			Toast.makeText(this, "Failed to initialize TTS engine.", Toast.LENGTH_SHORT).show();
		}
	}
	
	//CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCIÓN LUEGO DE PRESIONAR EL BOTÓN.
	
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acción al hacer click   
            switch (nroVentana){
            	case 1: bttnPrA.setText("A");
            			bttnPrF.setText("B");
            			bttnPrK.setText("C");
            			bttnPrO.setText("D");
            			bttnPrT.setText("E");
            			bttnPrSpace.setText("VOLVER ATRAS");
            			nroVentana = 2;
            			break;
            	case 2:	texto.setText(texto.getText()+"A");
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"F");
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"K");
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"O");
			   			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"T");
			   			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
            if (nroVentana == 1){
    			bttnPrA.setText("A");
			   	bttnPrF.setText("F");
			   	bttnPrK.setText("K");
			   	bttnPrO.setText("O");
			   	bttnPrT.setText("T");
			   	bttnPrSpace.setText("BARRA ESPACIADORA");
            }
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            switch (nroVentana){
            	case 1: bttnPrA.setText("F");
            			bttnPrF.setText("G");
            			bttnPrK.setText("H");
            			bttnPrO.setText("I");
            			bttnPrT.setText("J");
            			bttnPrSpace.setText("VOLVER ATRAS");
            			nroVentana = 3;
            			break;
            	case 2:	texto.setText(texto.getText()+"B");
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"G");
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"L");
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"P");
			   			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"U");
			   			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("BARRA ESPACIADORA");
	        }
	  }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            switch (nroVentana){
            	case 1: bttnPrA.setText("K");
            			bttnPrF.setText("L");
            			bttnPrK.setText("M");
            			bttnPrO.setText("N");
            			bttnPrT.setText("Ñ");
            			bttnPrSpace.setText("VOLVER ATRAS");
            			nroVentana = 4;
            			break;
            	case 2:	texto.setText(texto.getText()+"C");
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"H");
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"M");
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"QU");
			   			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"V");
			   			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("BARRA ESPACIADORA");
	        }
		}
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            switch (nroVentana){
            	case 1: bttnPrA.setText("O");
            			bttnPrF.setText("P");
            			bttnPrK.setText("Q");
            			bttnPrO.setText("R");
            			bttnPrT.setText("S");
            			bttnPrSpace.setText("VOLVER ATRAS");
            			nroVentana = 5;
            			break;
            	case 2:	texto.setText(texto.getText()+"D");
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"I");
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"N");
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"R");
			   			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"X");
			   			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("BARRA ESPACIADORA");
	        }
		}
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acción al hacer click   
	            switch (nroVentana){
            	case 1: bttnPrA.setText("T");
            			bttnPrF.setText("U");
            			bttnPrK.setText("V");
            			bttnPrO.setText("X");
            			bttnPrT.setText("Y");
            			bttnPrSpace.setText("VOLVER ATRAS");
            			nroVentana = 6;
            			break;
            	case 2:	texto.setText(texto.getText()+"E");
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"J");
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"Ñ");
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"S");
			   			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"Y");
			   			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
	            }
	            if (nroVentana == 1){
	    			bttnPrA.setText("A");
				   	bttnPrF.setText("F");
				   	bttnPrK.setText("K");
				   	bttnPrO.setText("O");
				   	bttnPrT.setText("T");
				   	bttnPrSpace.setText("BARRA ESPACIADORA");
	            }
		    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
			public void onClick(View v) {
				//Acción al hacer click
	            switch (nroVentana){
            	case 1: mainBuffer = (String) texto.getText();
						mainBuffer += ' ';
						texto.setText(mainBuffer);
            			nroVentana = 1;
            			break;
            	case 2:	case 3:	case 4:case 5:
            	case 6:	bttnPrA.setText("A");
			   			bttnPrF.setText("F");
			   			bttnPrK.setText("K");
			   			bttnPrO.setText("O");
			   			bttnPrT.setText("T");
			   			bttnPrSpace.setText("BARRA ESPACIADORA");
			   			nroVentana = 1;
			   			break;
			   	default:bttnPrA.setText("A");
	   					bttnPrF.setText("F");
	   					bttnPrK.setText("K");
	   					bttnPrO.setText("O");
	   					bttnPrT.setText("T");
	   					bttnPrSpace.setText("BARRA ESPACIADORA");
	   					nroVentana = 1;
	   					break;
	            }
			}
	};
	
	//Acción al hacer click en el botón Delete
	View.OnClickListener controladorBorrarCaracter = new View.OnClickListener() {
		public void onClick(View v) {
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
		}
		
	};
	
	//Acción al mantener presionado el botón Delete
	View.OnLongClickListener controladorBorrarTodo = new View.OnLongClickListener() {
		public boolean onLongClick(View v){
			mainBuffer = "";
			texto.setText(mainBuffer);
			return true;
		}
	};
	
	View.OnClickListener controladorPunto = new View.OnClickListener() {
		public void onClick(View v) {
			switch (nroVentana){
        	case 1: mainBuffer = (String) texto.getText();
					mainBuffer += '.';
					texto.setText(mainBuffer);
        			nroVentana = 1;
        			break;
        	case 2: case 3:	case 4:case 5:
        	case 6:ourTts.speak(mainBuffer, TextToSpeech.QUEUE_FLUSH, null);
		   	default:break;
            }
		}
	};
	
	View.OnClickListener controladorSI = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click
			final String textoSI = "si";
			switch (nroVentana){
        	case 1: case 2: case 3:	case 4:case 5:
        	case 6:ourTts.speak(textoSI, TextToSpeech.QUEUE_FLUSH, null);
		   	default:break;
            }
		}
	};
	
	View.OnClickListener controladorNO = new View.OnClickListener() {
		public void onClick(View v) {
			//Acción al hacer click
			final String textoNO = "no";
			switch (nroVentana){
        	case 1: case 2: case 3:	case 4:case 5:
        	case 6:ourTts.speak(textoNO, TextToSpeech.QUEUE_FLUSH, null);
		   	default:break;
            }
		}
	};
}
