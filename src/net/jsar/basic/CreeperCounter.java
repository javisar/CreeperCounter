package net.jsar.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class CreeperCounter extends Activity {
	
    private String jugador1_historia = "";
    private int jugador1_modificador = 0;
    private int jugador1_vida = 20;
    private String jugador2_historia = "";
    private int jugador2_modificador = 0;
    private int jugador2_vida = 20;
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
	}
	
	@Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.basic_activity);        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        jugador1_vida = Integer.parseInt(PrefsHelper.getStatePlayer1Vida(this));
        jugador2_vida = Integer.parseInt(PrefsHelper.getStatePlayer2Vida(this));

        jugador1_modificador = Integer.parseInt(PrefsHelper.getStatePlayer1Modificador(this));
        jugador2_modificador = Integer.parseInt(PrefsHelper.getStatePlayer2Modificador(this));

        jugador1_historia = PrefsHelper.getStatePlayer1Historia(this);
        jugador2_historia = PrefsHelper.getStatePlayer2Historia(this);

        loadUI();
    }
 
	protected void loadUI() {    	
        ((Button)findViewById(R.id.jugador1_menos5)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            jugador1_vida -= 5;          
            jugador1_historia += "/-5";
            actualizarInterface();
          }
        });
        
        ((Button)findViewById(R.id.jugador1_mas5)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            jugador1_vida += 5;
            jugador1_historia += "/+5";            
            actualizarInterface();
          }
        });
        
        ((Button)findViewById(R.id.jugador1_menos1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador1_vida -= 1;
            
            jugador1_historia += "/-1";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador1_mas1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador1_vida += 1;
            
            jugador1_historia += "/+1";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador1_modificador_menos1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador1_modificador -= 1;
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador1_modificador_mas1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador1_modificador += 1;
            actualizarInterface();
          }
        });
        
        
        ((Button)findViewById(R.id.jugador2_menos5)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_vida -= 5;
            
            jugador2_historia += "/-5";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador2_mas5)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_vida += 5;
            
            jugador2_historia += "/+5";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador2_menos1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_vida -= 1;
            
            jugador2_historia += "/-1";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador2_mas1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_vida += 1;
            
            jugador2_historia += "/+1";
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador2_modificador_menos1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_modificador -= 1;
            actualizarInterface();
          }
        });
        ((Button)findViewById(R.id.jugador2_modificador_mas1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            jugador2_modificador += 1;
            actualizarInterface();
          }
        });
        actualizarInterface(); 
	}


    public void onBackPressed()
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("Salir");
      localBuilder.setMessage("¿Esta seguro que desea salir?");
      localBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
            System.runFinalizersOnExit(true);
            System.exit(0);

        }
      });
      localBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
        }
      });
      localBuilder.show();
    }


    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
      getMenuInflater().inflate(R.menu.menu_options, paramMenu);
      return true;
    }
    

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {   
      int i = paramMenuItem.getItemId();
      if (i == R.id.reset)
      {
        jugador1_vida = 20;
        jugador2_vida = 20;
        jugador1_modificador = 0;
        jugador2_modificador = 0;
        jugador1_historia = "";
        jugador2_historia = "";
        actualizarInterface();
        return true;
      }
      if (i == R.id.clear_history)
      {
        jugador1_historia = "";
        jugador2_historia = "";
        actualizarInterface();
        return true;
      }
      return super.onOptionsItemSelected(paramMenuItem);
    }

    
    public void actualizarInterface()
    {     
      PrefsHelper.setStatePlayer1Vida(this, ""+jugador1_vida);
      PrefsHelper.setStatePlayer2Vida(this, ""+jugador2_vida);
      PrefsHelper.setStatePlayer1Modificador(this, ""+jugador1_modificador);
      PrefsHelper.setStatePlayer2Modificador(this, ""+jugador2_modificador);
      PrefsHelper.setStatePlayer1Historia(this, ""+jugador1_historia);
      PrefsHelper.setStatePlayer2Historia(this, ""+jugador2_historia);          
    	
      ((TextView)findViewById(R.id.jugador1_vida)).setText(""+jugador1_vida);
      ((TextView)findViewById(R.id.jugador2_vida)).setText(""+jugador2_vida);
      ((TextView)findViewById(R.id.jugador1_modificador)).setText(""+jugador1_modificador);
      ((TextView)findViewById(R.id.jugador2_modificador)).setText(""+jugador2_modificador);
      ((TextView)findViewById(R.id.jugador1_historia)).setText(""+jugador1_historia);
      ((TextView)findViewById(R.id.jugador2_historia)).setText(""+jugador2_historia);
      
      ((ScrollView)findViewById(R.id.jugador1_historia_scroll)).fullScroll(View.FOCUS_DOWN);
      ((ScrollView)findViewById(R.id.jugador2_historia_scroll)).fullScroll(View.FOCUS_DOWN);
    }
	
    
}
