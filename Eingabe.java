/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

//############################################################################
/** Die Klasse Eingabe beinhaltet jegliche Methoden, die gebraucht werden, um
  * Eingaben des Nutzer über die Tastatur einzulesen.
  *
  * @author Thomas Gerlach
  */
//############################################################################
public class Eingabe
{

  private static BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

  //############################################################################
  /**
  */
  //############################################################################
  public Eingabe()
  {
  }

  //############################################################################
  /** Erfasst eine Zeichenkette des Nutzer über die Tastatur.
    * 
    * @param titel Text als Aufforderung zur Eingabe
    *
    * @return Die erfasste Zeichenkette
  */
  //############################################################################
  public static String symbole(String titel)
  {
    String symbole = new String();
    System.out.format("\n%s", titel);
    while (symbole.isEmpty()) {
      try {
        symbole = eingabe.readLine();
      } catch (IOException ioe) {
      }
    }
    return symbole;
  }

  public static String symbole()
  {
    return symbole("");
  }

  //############################################################################
  /** Erfasst eine Zeichenkette des Nutzer über die Tastatur. Die Eingabe wird 
    * auf Länge geprüft und es wird ggf. zur Wiederholung aufgefordert.
    * 
    * @param titel Text als Aufforderung zur Eingabe
    * @param limit Anzahl einzulesender Zeichen
    *
    * @return Die erfasste Zeichenkette
  */
  //############################################################################
  public static String symbole(String titel, Integer limit)
  {
    String symbole = symbole(titel);

    while (symbole.length() != limit) {

      System.out.format("\nBitte Länge beachten! -> " + limit);
      symbole = symbole(titel);
    }

    return symbole;
  }

  //############################################################################
  /** Erfasst eine Zeichenkette des Nutzer über die Tastatur. Die Eingabe wird 
    * auf Länge und Muster geprüft und es wird ggf. zur Wiederholung aufgefordert.
    * 
    * @param titel Text als Aufforderung zur Eingabe
    * @param limit Anzahl einzulesender Zeichen
    * @param format regulärer Audruck zur Prüfung der Eingabe
    *
    * @return Die erfasste Zeichenkette
  */
  //############################################################################
  public static String symbole(String titel, Integer limit, String format)
  {
    String symbole = symbole(titel, limit);
    
    while (!symbole.matches(format)) {

      System.out.format("\nBitte Format beachten! -> " + format);
      symbole = symbole(titel, limit);
    }
    
    return symbole;
  }

  //############################################################################
  /** Erfasst eine Ganzzahl des Nutzer über die Tastatur.
    *
    * @param titel Text als Aufforderung zur Eingabe
    *
    * @return Die erfasste Ganzzahl
  */
  //############################################################################
  public static int ganzzahl(String titel)
  {
    int wert = 0;

    boolean eingabeOk = false;
    while (!eingabeOk)
      try 
      {
        wert = Integer.parseInt(symbole(titel));
        eingabeOk = true;
      }
      catch (NumberFormatException nfe)
      {
      }
    return wert;
  }

  public static int ganzzahl()
  {
    return ganzzahl("");
  }
  
  //############################################################################
  /** Erfasst eine Ganzzahl des Nutzer über die Tastatur. Die Eingabe wird auf
    * einen anzugebenen Wertebereich geprüft und ggf. wiederholt.
    *
    * @param titel Text als Aufforderung zur Eingabe
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Die erfasste Ganzzahl
  */
  //############################################################################
  public static int ganzzahl(String titel, int min, int max)
  {
    int wert = ganzzahl(titel);    
    
    while (wert < min || max < wert) {
      System.out.format("Bitte Werte von '%d' bis '%d' eingeben: ", min, max);
      wert = ganzzahl(titel);
    }
    return wert;
  }
  
  //############################################################################
  /** Erfasst eine Gleitzahl des Nutzer über die Tastatur.
    *
    * @param titel Text als Aufforderung zur Eingabe
    *
    * @return Die erfasste Gleitzahl
  */
  //############################################################################
  public static double gleitzahl(String titel)
  {
    double wert = 0;
    boolean eingabeOk = false;
    while (!eingabeOk)
      try 
      {
        wert = Double.parseDouble(symbole(titel));
        eingabeOk = true;
      }
      catch (NumberFormatException nfe)
      {
      }
    return wert;
  }
  
  public static double gleitzahl()
  {
    return gleitzahl("");
  }
  
  //############################################################################
  /** Erfasst eine Gleitzahl des Nutzer über die Tastatur. Die Eingabe wird auf
    * einen anzugebenen Wertebereich geprüft und ggf. wiederholt.
    *
    * @param titel Text als Aufforderung zur Eingabe
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Die erfasste Gleitzahl
  */
  //############################################################################
  public static double gleitzahl(String titel, Double min, Double max)
  {
    double wert = gleitzahl(titel);    
    
    while (wert < min || max < wert) {
      System.out.format("Bitte Werte von '%.2f' bis '%.2f' eingeben: ", min, max);
      wert = gleitzahl(titel);
    }
  
    return wert;
  }
  
  //############################################################################
  /** Erfasst die Angabe des Nutzer bei der Auswahl zwei anzugebener Ausgaben
    *
    * @param titel Titel als Aufforderung zur Eingabe
    * @param positiv Erste Angabe der Auswahl
    * @param negativ Zweite Angabe der Auswahl
    *
    * @return TRUE / FALSE entsprechend erster / zweiter Auswahl
  */
  //############################################################################
  public static Boolean auswahl(String titel, String positiv, String negativ)
  {
    String text = symbole(titel);
    
    while (!text.contains(positiv) && !text.contains(negativ)) {

      System.out.format("Bitte aus '%s' und '%s' wählen: ", positiv, negativ);
      text = symbole(titel);
    }

    return (text.contains(positiv)) ? true : false;
  }

  //############################################################################
  /** Erfasst eine Ganzzahl aus einer anzugebenen Liste als Auswahl
    *
    * @param titel Titel als Aufforderung zur Eingabe
    * @param array Liste von wählbaren Ganzzahlen
    *
    * @return Ausgewälter Wert der Liste
  */
  //############################################################################
  public static int auswahl(String titel, int[] array)
  {
    int max = Listen.maximum(array);
    int min = Listen.minimum(array);
    int wert = ganzzahl(titel, min, max);
    
    while (!Listen.isMember(array, wert))
    {
      System.out.format("Achtung! %d  Gültige Werte sind: [%s]", wert, Listen.format(array, " | "));
      wert = ganzzahl(titel, min, max);
    }

    return wert;
  }
  
  //############################################################################
  /** Erfasst eine Gleitzahl aus einer anzugebenen Liste als Auswahl
    *
    * @param titel Titel als Aufforderung zur Eingabe
    * @param array Liste von wählbaren Gleitzahlen
    *
    * @return Ausgewälter Wert der Liste
  */
  //############################################################################
  public static double auswahl(String titel, double[] array)
  {
    double max = Listen.maximum(array);
    double min = Listen.minimum(array);
    double wert = gleitzahl(titel, min, max);
    
    while (!Listen.isMember(array, wert))
    {
      System.out.format("Achtung! %f  Gültige Werte sind: [%s]", wert, Listen.format(array, " | "));
      wert = gleitzahl(titel, min, max);
    }

    return wert;
  }
  
  //############################################################################
  /** Erfasst den Index einer anzugebenen Liste als Auswahl
    *
    * @param titel Titel als Aufforderung zur Eingabe
    * @param array Liste von wählbaren Zeichenketten
    *
    * @return Index der Liste
  */
  //############################################################################
  public static int auswahl(String titel, String[] array)
  {
    for (int i = 0; i < array.length; i++)
    {
      System.out.format("\n(%d) %s", i + 1, array[i]);
    }
    return ganzzahl(titel, 1, array.length) - 1;
  }
}
