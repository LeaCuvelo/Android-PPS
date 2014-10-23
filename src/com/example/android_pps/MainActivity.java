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
        //bttnPrSpace.setBackgroundColor(Color.rgb(109, 27, 226));  //Violeta personalizado
        bttnPrDelete = (Button) findViewById(R.id.bttnPrDelete);
        bttnPrDelete.setOnClickListener(controladorBorrarCaracter);
        bttnPrDelete.setOnLongClickListener(controladorBorrarTodo);
        bttnPrPoint = (Button) findViewById(R.id.bttnPrPoint);
        bttnPrPoint.setOnClickListener(controladorPunto);
        bttnPrPoint.setOnLongClickListener(controladorGuardar);
        bttnPrSI = (Button) findViewById(R.id.bttnPrSI);
        bttnPrSI.setOnClickListener(controladorSI);
        //bttnPrSI.setBackgroundColor(Color.rgb(255, 126, 32)); //Naranja personalizado 2
        bttnPrNO = (Button) findViewById(R.id.bttnPrNO);
        bttnPrNO.setOnClickListener(controladorNO);
        //bttnPrNO.setBackgroundColor(Color.rgb(70, 164, 255)); //Celeste personalizado
        
        //Instanciamos nuestro TTS
        ourTts = new TextToSpeech(this,this);
        
        //Cargamos el texto que se presenta inicialmente en los botones
        //Y sus respectivos colores
        bttnPrA.setText("A");
        bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
        bttnPrF.setText("F");
        bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
        bttnPrK.setText("K");
        bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
        bttnPrO.setText("O");
        bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
        bttnPrT.setText("T");
        bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado

        //Tomamos la instancia para sonida
        Effects.getInstance().init(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.settings_activity, menu);
		return true;
		/*super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;*/
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.low: 
        	Toast.makeText(this, "-LENTO- seleccionado",Toast.LENGTH_LONG).show();
            return true;
		case R.id.medium:
        	Toast.makeText(this, "-MEDIO- seleccionado",Toast.LENGTH_LONG).show();
            return true;
        case R.id.high:
        	Toast.makeText(this, "-RAPIDO- seleccionado",Toast.LENGTH_LONG).show();
            return true;
        default:
        	Toast.makeText(this, "EN DESARROLLO... (Programando...)",Toast.LENGTH_LONG).show();
            return super.onOptionsItemSelected(item);
    	}
	}
	/*
	//Items que se muestran cuando el usuario quiera acceder a la tecla MENU
	private void CreateMenu(Menu menu){
		SubMenu menuAjustes = menu.addSubMenu(0, 0, 0, "Ajustes");
		{
			//method to assign a shortcut key to the menu item so that users can select an item by pressing a key on the keyboard
			//menuAjustes.setAlphabeticShortcut('a');
			//method sets an image to be displayed on the menu item.
			menuAjustes.setIcon(R.drawable.options);
			menuAjustes.add(0,1,0,"Velocidad de Voz");
			menuAjustes.add(0,2,1,"Genero de Voz");
		}
		
		MenuItem menuAcercaDe = menu.add(1, 0, 1, "Acerca de");
		{
			//menuAcercaDe.setAlphabeticShortcut('b');
			menuAcercaDe.setIcon(R.drawable.acerca);
			
		}
		
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
	}*/
	
	
	
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
	
	//CONTROLADOR DE LOS BOTONES, DETERMINAN LA ACCI�N LUEGO DE PRESIONAR EL BOT�N.
	
	View.OnClickListener controladorA = new View.OnClickListener() {
	    public void onClick(View v) {
	    	//Acci�n al hacer click 
	    	//Reproduce sonido
	    	Effects.getInstance().playSound(Effects.SOUND_1);
            switch (nroVentana){
            	case 1: bttnPrA.setTextColor(Color.rgb(0,0,255)); //Seteamos todos los botones a azul
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
                bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
                bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
                bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
                bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
                bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
    			bttnPrA.setText("A");
			   	bttnPrF.setText("F");
			   	bttnPrK.setText("K");
			   	bttnPrO.setText("O");
			   	bttnPrT.setText("T");
			   	bttnPrSpace.setText("");
            }
	    }
	  };
	  
	View.OnClickListener controladorF = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: bttnPrA.setTextColor(Color.rgb(255,0,0)); //Seteamos todos los botones a rojo
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
	            bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
	            bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
	            bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
	            bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
	            bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("");
	        }
	  }
	};
	  
	View.OnClickListener controladorK = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: bttnPrA.setTextColor(Color.rgb(0,159,1)); //Seteamos todos los botones a verde
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
	            bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
	            bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
	            bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
	            bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
	            bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("");
	        }
		}
	};
	  
    View.OnClickListener controladorO = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: bttnPrA.setTextColor(Color.rgb(0,0,0)); //Seteamos todos los botones a negro
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
	            bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
	            bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
	            bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
	            bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
	            bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
	    		bttnPrA.setText("A");
				bttnPrF.setText("F");
				bttnPrK.setText("K");
				bttnPrO.setText("O");
				bttnPrT.setText("T");
				bttnPrSpace.setText("");
	        }
		}
    };
	  
	View.OnClickListener controladorT = new View.OnClickListener() {
		    public void onClick(View v) {
		    	//Acci�n al hacer click
		    	//Reproduce sonido
		    	Effects.getInstance().playSound(Effects.SOUND_1);
	            switch (nroVentana){
            	case 1: bttnPrA.setTextColor(Color.rgb(255,147,0)); //Seteamos todos los botones a naranaja personalizado
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
	                bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
	                bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
	                bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
	                bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
	                bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
	    			bttnPrA.setText("A");
				   	bttnPrF.setText("F");
				   	bttnPrK.setText("K");
				   	bttnPrO.setText("O");
				   	bttnPrT.setText("T");
				   	bttnPrSpace.setText("");
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
            	case 6:	bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
                		bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
                		bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
                		bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
                		bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizado
            			bttnPrA.setText("A");
			   			bttnPrF.setText("F");
			   			bttnPrK.setText("K");
			   			bttnPrO.setText("O");
			   			bttnPrT.setText("T");
			   			bttnPrSpace.setText("");
			   			nroVentana = 1;
			   			break;
			   	default:bttnPrA.setTextColor(Color.rgb(0,0,255)); //Azul
			   			bttnPrF.setTextColor(Color.rgb(255,0,0)); //Rojo
			   			bttnPrK.setTextColor(Color.rgb(0,159,1)); //Verde personalizado
			   			bttnPrO.setTextColor(Color.rgb(0,0,0)); //Negro
			   			bttnPrT.setTextColor(Color.rgb(255,147,0)); //Naranja personalizadobttnPrA.setText("A");
	   					bttnPrF.setText("F");
	   					bttnPrK.setText("K");
	   					bttnPrO.setText("O");
	   					bttnPrT.setText("T");
	   					bttnPrSpace.setText("");
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
					//Comprobamos el estado de la memoria externa
					String estadoTarjeta = Environment.getExternalStorageState();
					boolean tarjetaEscritura = false;
					
					if (estadoTarjeta.equals(Environment.MEDIA_MOUNTED)){
						Toast.makeText(getBaseContext(),"HAY TARJETA!", Toast.LENGTH_LONG).show();
						tarjetaEscritura = true;
					}
					if (tarjetaEscritura) { // HAY SD en el dispositivo, por lo tanto escribimos en ella y no en la memoria interna
						try {
							//---- SD storage ----- //
							File ruta_tarjeta = Environment.getExternalStorageDirectory();
							File directory = new File (ruta_tarjeta.getAbsolutePath()+"/IntercomFiles");
							directory.mkdirs();
							File f = new File(ruta_tarjeta, "Intercom.txt");
							FileOutputStream fOut = new FileOutputStream(f);
							OutputStreamWriter osw = new OutputStreamWriter(fOut);
							//Escribe el contenido del editText al archivo
							osw.write(texto.getText().toString());
							osw.flush();
							osw.close();
							// ---- Mostramos un mensaje de guardado exitoso ---- //
							Toast.makeText(getBaseContext(),"Texto guardado en SD Card!", Toast.LENGTH_SHORT).show();
							// --- BORRAMOS EL CONTENIDO DEL editText ???
							// texto.setText(""); CONSULTAR A FLAVIO!!!
		
						}
						catch (Exception e){
							
							Toast.makeText(getBaseContext(),"ERROR al guardar archivo!", Toast.LENGTH_SHORT).show();
						}
					}
					else // ESCRIBIMOS EN LA MEMORIA INTERNA!
					{ 
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
	
}
