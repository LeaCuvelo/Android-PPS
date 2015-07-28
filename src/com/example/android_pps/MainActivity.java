package com.example.android_pps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;

import android.R.menu;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  implements OnInitListener{
	private Button bttnPrA,bttnPrF,bttnPrK,bttnPrO,bttnPrT,bttnPrSpace,bttnPrDelete,bttnPrPoint,bttnPrSI,bttnPrNO;
	private int nroVentana = 1; //1=Principal;2=ventanaA;3=ventanaF;4=ventanaK;5=ventanaO;6=ventanaT;
	public String mainBuffer;
	public static EditText texto;
	private TextToSpeech ourTts;

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
         
        //Enlazamos el editText y lo dejamos en blanco
        texto = (EditText) findViewById(R.id.editText);
        texto.setText("");
        
        // Anula teclado al hacer click en el edit y scrollbar horizonta obligado
        texto.setInputType(InputType.TYPE_NULL); 
        if (android.os.Build.VERSION.SDK_INT >= 11)   
        {  
            texto.setRawInputType(InputType.TYPE_CLASS_TEXT);  
            texto.setTextIsSelectable(true);  
        }

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
        bttnPrPoint.setOnLongClickListener(controladorGuardar);
        bttnPrSI = (Button) findViewById(R.id.bttnPrSI);
        bttnPrSI.setOnClickListener(controladorSI);
        bttnPrNO = (Button) findViewById(R.id.bttnPrNO);
        bttnPrNO.setOnClickListener(controladorNO);
        
        //Instanciamos nuestro TTS
        ourTts = new TextToSpeech(this,this);
        
        //Tomamos la instancia para los sonidos
        Effects.getInstance().init(this);
	}
	
	// ---------- TRABAJAR ACA! EN EL MENU! ---------- //
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Intent i = new Intent(this,Configuraciones.class);
    	startActivity(i);	
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
	/*	switch (item.getItemId()) {
		case R.id.file: 
        	Intent i = new Intent(this,Configuraciones.class);
        	startActivity(i);
            return true;
        default:
        	Toast.makeText(this, "EN DESARROLLO... (Programando...)",Toast.LENGTH_LONG).show();
           
    	}*/
		 return super.onOptionsItemSelected(item);
	}
	
	
	//Items que se muestran cuando el usuario quiera acceder a la tecla MENU
	private void CreateMenu(Menu menu){
		SubMenu menuAjustes = menu.addSubMenu(0, 0, 0, "Ajustes");
		{
			menuAjustes.setIcon(R.drawable.options);
			menuAjustes.add(0,1,0,"Velocidad de Voz");
			menuAjustes.add(0,1,1,"Genero de Voz");
			menuAjustes.add(0,1,2, "PRUEBA");
		}
		
		SubMenu menuAcercaDe = menu.addSubMenu(1, 0, 1, "Acerca de");
		{
			menuAcercaDe.setIcon(R.drawable.acerca);
		}
		
		SubMenu menuLALA = menu.addSubMenu(2, 0, 2, "TEST");
	}
	
	//Acciones que suceden cuando usuario selecciona un item del menu
	private boolean MenuChoice(MenuItem item){
		switch (item.getGroupId()) {
			case 0: 
					switch (item.getItemId()) {
						case 1:Toast.makeText(this, "-Velocidad fue- seleccionado",Toast.LENGTH_LONG).show(); 
						break; 
						case 2:Toast.makeText(this, "-Genero fue- seleccionado",Toast.LENGTH_LONG).show(); 
						break;
					}
					return true;
			case 1:
					Toast.makeText(this, "-Acerca de fue- seleccionado",Toast.LENGTH_LONG).show();
					return true;
		}
		return false;
	}

	
	
	// ---------- TRABAJAR ACA! EN EL MENU! (ARRIBA)---------- //
	
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
		 if (keyCode == KeyEvent.KEYCODE_BACK) {
			 //Si se toca el bot�n BACK, se solicita confirmaci�n de salida
			 new AlertDialog.Builder(this)
	    	      .setIcon(android.R.drawable.ic_dialog_alert)
	    	      .setTitle("ADVERTENCIA")
	    	      .setMessage("�Seguro que desea salir?")
	    	      .setPositiveButton("Si", new DialogInterface.OnClickListener() {
	    	        @Override
	    	        public void onClick(DialogInterface dialog, int which){
	    	          //Al pulsar si, finaliza aplicaci�n
	    	        	MainActivity.this.finish();
	    	        }
	    	      })
	    	      .setNegativeButton("No", null)
	    	      .show();
	    	    return true;
	    	  }
		 else{
			 return super.onKeyDown(keyCode, event);
		 }
	}
	
	//Verificamos si se puede y seteamos idioma espa�ol a ourTts
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
	
	// ----- CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCI�N LUEGO DE PRESIONAR EL BOT�N . ----- //
	
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click 
	    	//Reproduce sonido
	    	Effects.getInstance().playSound(Effects.SOUND_1);
            switch (nroVentana){
            	case 1: 
            			//Sacamos los Style boton_a y ponemos el Style boton_secundaria a todos los botones
            		    setearStylesSecundarios();
            			//Seteamos todos los botones a azul
            			setearColorAzul();
            			nroVentana = 2;
            			break;
            	case 2:	texto.setText(texto.getText()+"A");
            			texto.setSelection(texto.getText().length()); // DEJA PARADO EL CURSOR AL FINAL DE LA CADENA!
            			nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"F");
            			texto.setSelection(texto.getText().length()); 
			   			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"K");
            			texto.setSelection(texto.getText().length());
			   			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"O");
            			texto.setSelection(texto.getText().length());
            			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"T");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
            if (nroVentana == 1){
            	//Volvemos a ponerle los Style correspondientes a los botones
            	setearStylesPrimarios();
            	//Ponemos el texto en blanco para que no se pise con la imagen
            	setTextoPrimario();
            }
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1:
            			//Sacamos los Style boton_a y ponemos el Style boton_secundaria a todos los botones
            			setearStylesSecundarios();
        				//Seteamos todos los botones a rojo
            			setearColorRojo();
            			nroVentana = 3;
            			break;
            	case 2:	texto.setText(texto.getText()+"B");
            			texto.setSelection(texto.getText().length());
    				   	nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"G");
            			texto.setSelection(texto.getText().length());
            			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"L");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"P");
            			texto.setSelection(texto.getText().length());	
            			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"U");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){
	        	//Volvemos a ponerle los Style correspondientes a los botones
	        	setearStylesPrimarios();
            	//Ponemos el texto en blanco para que no se pise con la imagen
	        	setTextoPrimario();
            }
	  }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: 
            			//Sacamos los Style boton_a y ponemos el Style boton_secundaria a todos los botones
            			setearStylesSecundarios();
    					//Seteamos todos los botones a verde
            			setearColorVerde();
            			nroVentana = 4;
            			break;
            	case 2:	texto.setText(texto.getText()+"C");
            			texto.setSelection(texto.getText().length());
            			nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"H");
            			texto.setSelection(texto.getText().length());
            			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"M");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"QU");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"V");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){
	        	//Volvemos a ponerle los Style correspondientes a los botones
	        	setearStylesPrimarios();
            	//Ponemos el texto en blanco para que no se pise con la imagen
	        	setTextoPrimario();
            }
		}
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: 
            			//Sacamos los Style boton_a y ponemos el Style boton_secundaria a todos los botones
            		 	setearStylesSecundarios();
						//Seteamos todos los botones a negro
            			setearColorNegro();
            			nroVentana = 5;
            			break;
            	case 2:	texto.setText(texto.getText()+"D");
            			texto.setSelection(texto.getText().length());	   	
            			nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"I");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"N");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"R");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"X");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
            }
	        if (nroVentana == 1){  
	        	//Volvemos a ponerle los Style correspondientes a los botones
	        	setearStylesPrimarios();
            	//Ponemos el texto en blanco para que no se pise con la imagen
	        	setTextoPrimario();
            }
		}
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1:
            			//Sacamos los Style boton_a y ponemos el Style boton_secundaria a todos los botones
            		 	setearStylesSecundarios();
						//Seteamos todos los botones a naranaja personalizado
            		 	setearColorNaranja();
            			nroVentana = 6;
            			break;
            	case 2:	texto.setText(texto.getText()+"E");
            			texto.setSelection(texto.getText().length());	   	
            			nroVentana = 1;
    				   	break;
            	case 3:	texto.setText(texto.getText()+"J");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 4:	texto.setText(texto.getText()+"�");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 5:	texto.setText(texto.getText()+"S");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
            	case 6:	texto.setText(texto.getText()+"Y");
            			texto.setSelection(texto.getText().length());		
            			nroVentana = 1;
			   			break;
			   	default:nroVentana = 1;
						break;
	            }
	            if (nroVentana == 1){ 
	            	//Volvemos a ponerle los Style correspondientes a los botones
	            	setearStylesPrimarios();
	            	//Ponemos el texto en blanco para que no se pise con la imagen
	            	setTextoPrimario();
	                }
		    }
	};
	
	View.OnClickListener controladorEspacio = new View.OnClickListener() {
			public void onClick(View v) {
				//Acci�n al hacer click
				//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: mainBuffer = texto.getText().toString();
						mainBuffer += ' ';
						texto.setText(mainBuffer);
						texto.setSelection(texto.getText().length());
            			nroVentana = 1;
            			break;
            	case 2:	case 3:	case 4:case 5:
            	case 6: setTextoPrimario();
    					setearStylesPrimarios();
			   			nroVentana = 1;
			   			break;
			   	default:
			   			setTextoPrimario();
			   			setearStylesPrimarios();
			   			nroVentana = 1;
			   			break;
	            	}
			}
	};
	
	//Acci�n al hacer click en el bot�n Delete
	View.OnClickListener controladorBorrarCaracter = new View.OnClickListener() {
		public void onClick(View v) {
			//Reproduce sonido
	    	Effects.getInstance().playSound(Effects.SOUND_1);
			mainBuffer = texto.getText().toString();
			int longitudBuffer = mainBuffer.length();
			if (longitudBuffer > 0 ){
					if ( (longitudBuffer > 1) && (mainBuffer.charAt(longitudBuffer-1) == 'U') && (mainBuffer.charAt(longitudBuffer-2) == 'Q')){
						mainBuffer = mainBuffer.substring(0,longitudBuffer-2);
						texto.setText(mainBuffer);
						texto.setSelection(texto.getText().length());
					}
					else{
						mainBuffer = mainBuffer.substring(0,longitudBuffer-1);
						texto.setText(mainBuffer);
						texto.setSelection(texto.getText().length());
					}
				}
		}
	};
	
	//Acci�n al mantener presionado el bot�n Delete
	View.OnLongClickListener controladorBorrarTodo = new View.OnLongClickListener() {
		public boolean onLongClick(View v){
			//Reproduce sonido
	    	Effects.getInstance().playSound(Effects.SOUND_1);
			mainBuffer = "";
			texto.setText(mainBuffer);
			texto.setSelection(texto.getText().length());
			return true;
		}
	};
	
	View.OnClickListener controladorPunto = new View.OnClickListener() {
		public void onClick(View v) {
			switch (nroVentana){
        	case 1:
        			mainBuffer = texto.getText().toString(); 
					mainBuffer += '.';
					texto.setText(mainBuffer);
					texto.setSelection(texto.getText().length());
        			nroVentana = 1;
        			ourTts.speak(mainBuffer, TextToSpeech.QUEUE_FLUSH, null);
        			break;
        	case 2: case 3:	case 4:case 5:case 6:
		   	default:break;
            }
		}
	};
	
	
	View.OnLongClickListener controladorGuardar = new View.OnLongClickListener() { // ----- guarda el texto escrito hasta el momento en MEMORIA
		@Override
		public boolean onLongClick(View v) {
			//Reproduce sonido
	    	Effects.getInstance().playSound(Effects.SOUND_1);
			switch (nroVentana){
        	case 1:
					//Intentamos escribir en memoria PERSISTENCIA DE DATOS
					try {
						//---- INTERNAL storage ----- //
						FileOutputStream fOut = openFileOutput("Intercom.txt", MODE_WORLD_READABLE);
						OutputStreamWriter fWrite = new OutputStreamWriter (fOut); 
						//Escribe el contenido del editText al archivo
						fWrite.write(texto.getText().toString());
						fWrite.flush();
						fWrite.close();
						// ---- Mostramos un mensaje de guardado exitoso ---- //
						Toast.makeText(getBaseContext(),"Texto guardado en memoria interna!", Toast.LENGTH_SHORT).show();
						// --- BORRAMOS EL CONTENIDO DEL editText ???
						// texto.setText(""); CONSULTAR A FLAVIO!!!
					}
					catch (Exception e){
						
						Toast.makeText(getBaseContext(),"ERROR al guardar archivo!", Toast.LENGTH_SHORT).show();
					}
					break;
        	case 2: case 3:	case 4:case 5:case 6:
        	default:break;
			}
			return true;
		}
	};
	
	View.OnClickListener controladorSI = new View.OnClickListener() {
		public void onClick(View v) {
			//Acci�n al hacer click
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
			//Acci�n al hacer click
			final String textoNO = "no";
			switch (nroVentana){
        	case 1: case 2: case 3:	case 4:case 5:
        	case 6:ourTts.speak(textoNO, TextToSpeech.QUEUE_FLUSH, null);
		   	default:break;
            }
		}
	};
	
	// ----- FIN CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCI�N LUEGO DE PRESIONAR EL BOT�N . ----- //

	// --- FUNCIONES CONTROLADORAS DE LOS SET DE STYLES Y TEXTOS --- //
	
	/**
	 * Setea los styles de los botones al modo pantalla secundaria
	 */
	private void setearStylesSecundarios (){
		bttnPrA.setBackgroundResource(R.drawable.boton_secundaria); 
		bttnPrF.setBackgroundResource(R.drawable.boton_secundaria); 
		bttnPrK.setBackgroundResource(R.drawable.boton_secundaria); 
		bttnPrO.setBackgroundResource(R.drawable.boton_secundaria); 
		bttnPrT.setBackgroundResource(R.drawable.boton_secundaria);		
	}
	
	/**
	 * Setea el texto de los botones correspondientes con el primer grupo de letras. 
	 * En color AZUL
	 */
	private void setearColorAzul(){
		bttnPrA.setTextColor(Color.rgb(0,0,255)); 
		bttnPrF.setTextColor(Color.rgb(0,0,255));
		bttnPrK.setTextColor(Color.rgb(0,0,255));
		bttnPrO.setTextColor(Color.rgb(0,0,255));
		bttnPrT.setTextColor(Color.rgb(0,0,255));
		bttnPrA.setText("A");
		bttnPrF.setText("B");
		bttnPrK.setText("C");
		bttnPrO.setText("D");
		bttnPrT.setText("E");
		bttnPrSpace.setText("VOLVER ATRAS");
	}

	/**
	 * Setea el texto de los botones correspondientes con el segundo grupo de letras. 
	 * En color ROJO
	 */
	private void setearColorRojo(){
		bttnPrA.setTextColor(Color.rgb(255,0,0)); 
		bttnPrF.setTextColor(Color.rgb(255,0,0));
		bttnPrK.setTextColor(Color.rgb(255,0,0));
		bttnPrO.setTextColor(Color.rgb(255,0,0));
		bttnPrT.setTextColor(Color.rgb(255,0,0));
		bttnPrA.setText("F");
		bttnPrF.setText("G");
		bttnPrK.setText("H");
		bttnPrO.setText("I");
		bttnPrT.setText("J");
		bttnPrSpace.setText("VOLVER ATRAS");
	}
	
	/**
	 * Setea el texto de los botones correspondientes con el tercer grupo de letras. 
	 * En color VERDE
	 */
	private void setearColorVerde(){
		bttnPrA.setTextColor(Color.rgb(0,159,1)); 
		bttnPrF.setTextColor(Color.rgb(0,159,1));
		bttnPrK.setTextColor(Color.rgb(0,159,1));
		bttnPrO.setTextColor(Color.rgb(0,159,1));
		bttnPrT.setTextColor(Color.rgb(0,159,1));
		bttnPrA.setText("K");
		bttnPrF.setText("L");
		bttnPrK.setText("M");
		bttnPrO.setText("N");
		bttnPrT.setText("�");
		bttnPrSpace.setText("VOLVER ATRAS");
	}
	
	/**
	 * Setea el texto de los botones correspondientes con el cuarto grupo de letras. 
	 * En color NEGRO
	 */
	private void setearColorNegro(){
		bttnPrA.setTextColor(Color.rgb(0,0,0)); 
		bttnPrF.setTextColor(Color.rgb(0,0,0));
		bttnPrK.setTextColor(Color.rgb(0,0,0));
		bttnPrO.setTextColor(Color.rgb(0,0,0));
		bttnPrT.setTextColor(Color.rgb(0,0,0));
		bttnPrA.setText("O");
		bttnPrF.setText("P");
		bttnPrK.setText("Q");
		bttnPrO.setText("R");
		bttnPrT.setText("S");
		bttnPrSpace.setText("VOLVER ATRAS");
	}
	
	/**
	 * Setea el texto de los botones correspondientes con el quinto grupo de letras. 
	 * En color NARANJA
	 */
	private void setearColorNaranja(){
		bttnPrA.setTextColor(Color.rgb(255,147,0)); 
		bttnPrF.setTextColor(Color.rgb(255,147,0));
		bttnPrK.setTextColor(Color.rgb(255,147,0));
		bttnPrO.setTextColor(Color.rgb(255,147,0));
		bttnPrT.setTextColor(Color.rgb(255,147,0));
		bttnPrA.setText("T");
		bttnPrF.setText("U");
		bttnPrK.setText("V");
		bttnPrO.setText("X");
		bttnPrT.setText("Y");
		bttnPrSpace.setText("VOLVER ATRAS");
	}
	
	/***
	 *  Funcion que vuelve a poner los styles para la pantalla primaria
	 */
	private void setearStylesPrimarios(){
		bttnPrA.setBackgroundResource(R.drawable.boton_a); 
    	bttnPrF.setBackgroundResource(R.drawable.boton_f);
    	bttnPrK.setBackgroundResource(R.drawable.boton_k);
    	bttnPrO.setBackgroundResource(R.drawable.boton_o);
    	bttnPrT.setBackgroundResource(R.drawable.boton_t);
	}
	
	/***
	 *  Funcion que borra el texto de los botones
	 */
	private void setTextoPrimario(){
		bttnPrA.setText("");
		bttnPrF.setText("");
		bttnPrK.setText("");
		bttnPrO.setText("");
		bttnPrT.setText("");
		bttnPrSpace.setText("");
	   	bttnPrSpace.setText("");
	}
	
	// --- FIN FUNCIONES CONTROLADORAS DE LOS SET DE STYLES Y TEXTOS --- //
}
