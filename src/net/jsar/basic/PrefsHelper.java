package net.jsar.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PrefsHelper
{

	public static final String NAME_PREFERENCES = "CreeperCounterPreferences";
	public static final String NAME_CONFIG = "CreeperCounterConfig";
	
	
  public static final String state_player1_vida = "state_player1_vida";
  public static final String state_player2_vida = "state_player2_vida";

  private static final String state_player1_modificador = "state_player1_modificador";
  private static final String state_player2_modificador = "state_player2_modificador";
  
  private static final String state_player1_historia = "state_player1_historia";
  private static final String state_player2_historia = "state_player2_historia";
  
  
  public static String getStatePlayer1Vida(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player1_vida, "20");
  }

  public static void setStatePlayer1Vida(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player1_vida, paramString);
    localEditor.commit();
  }

  
  
  public static String getStatePlayer2Vida(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player2_vida, "20");
  }

  public static void setStatePlayer2Vida(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player2_vida, paramString);
    localEditor.commit();
  }

  
  
  public static String getStatePlayer1Modificador(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player1_modificador, "0");
  }

  public static void setStatePlayer1Modificador(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player1_modificador, paramString);
    localEditor.commit();
  }

  
  
  public static String getStatePlayer2Modificador(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player2_modificador, "0");
  }

  public static void setStatePlayer2Modificador(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player2_modificador, paramString);
    localEditor.commit();
  }

  
  
  public static String getStatePlayer1Historia(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player1_historia, "");
  }

  public static void setStatePlayer1Historia(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player1_historia, paramString);
    localEditor.commit();
  }

  

  public static String getStatePlayer2Historia(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_player2_historia, "");
  }

  public static void setStatePlayer2Historia(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_player2_historia, paramString);
    localEditor.commit();
  }

  
}