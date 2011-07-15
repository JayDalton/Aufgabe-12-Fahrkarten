/*############################################################################
  Kodierung: UTF-8 ohne BOM - äüö
############################################################################*/

//############################################################################
/** Methodensammlung zu Ausgabe auf der Konsole. 
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Ausgabe
{
  //############################################################################
  /**
  */
  //############################################################################
  private Ausgabe()
  {
  }

  //############################################################################
  /** Leert die Standardausgabe durch wiederholte Ausgabe von leeren Zeilen.
  */
  //############################################################################
  public static void leere()
  {
    for (int i = 0; i < 80; i++)
    {
      System.out.format("\n");
    }
  }
  
  //############################################################################
  /** Schreibt die übergebene Zeichenfolge in die Standardausgabe mit neuer Zeile
    *
    * @param symbole Die auszugebene Zeichenkette
  */
  //############################################################################
  public static void zeile(String symbole)
  {
    System.out.println(symbole);
  }

  //############################################################################
  /** Vervielfältigt eine Folge von Symbolen mittels Anzahl in der Standrdausgabe
    *
    * @param symbole Zeichenkette die zu duplizieren ist
    * @param anzahl Anzahl der Duplikate
  */
  //############################################################################
	public static void multi(String symbole, int anzahl)
	{
		for (int i = 0; i < anzahl; i++)
		{
			System.out.format("%s", symbole);
		}
	}
}
