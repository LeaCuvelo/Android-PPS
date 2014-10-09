package com.example.android_pps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SettingsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Toast.makeText(getBaseContext(),"DALE!!sfsdfsdfssssssssssssssssssssssssssssssssssssssss!", Toast.LENGTH_SHORT).show();
		
		//Enlazamos nuestra Activity con la vista
		setContentView(R.layout.settings_activity); 
		
		//Seteamos que no tenga "barra de título" la aplicación
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        //Seteamos el uso de "Full screen" para la aplicación
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
	}
	
	//Para salir de la apliación tocando el botón "Atrás"
		public boolean onKeyDown(int keyCode, KeyEvent event){
			 if (keyCode == KeyEvent.KEYCODE_BACK) {
				 
				Intent i = new Intent(this,MainActivity.class);
				setResult(RESULT_OK,i);
				this.finish();
				
				//startActivity (i);
		    	    return true;
		    	  }
			 else{
				 return super.onKeyDown(keyCode, event);
			 }
		}

}
