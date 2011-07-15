/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/**
*/
//############################################################################
public class Automat
{
  
  private static Tickets[] tickets;
  private static double[] betrag = {50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.1};

  //##########################################################################
  /**
  */
  //##########################################################################
	public Automat()
	{
    tickets = Tickets.values();
  }

  //##########################################################################
  /**
  */
  //##########################################################################
  public void starten()
  {
    int auswahl = waehlen();

    while(0 <= auswahl) {
     
      bezahlen(tickets[auswahl]);
      auswahl = waehlen();
    }

    System.out.format("\nSystem wird runter gefahren ...");
  }
  
  //##########################################################################
  /**
  */
  //##########################################################################
  public int waehlen()
  {
    System.out.format("\n\n#################################");
    System.out.format("\n# Zielorte");
    System.out.format("\n#################################\n");

    for (int i = 0; i < tickets.length; i++)
    {
      System.out.format("\n Ticket (%d): %s [%.2f]", i + 1, tickets[i].getFahrt(), tickets[i].getTarifEuro());
    }
    
    return Eingabe.ganzzahl(String.format("\nWählen sie [1 - %d] oder [-1] für Ende: ", tickets.length), -1, tickets.length) - 1;
  }
  
  //##########################################################################
  /** 
  */
  //##########################################################################
  public static String encrypt(int wert)
  {
    String ergebnis = new String();

    for (int i = 0, j = 0; i < betrag.length; i++, j = 0)
    {
      for ( ; Tickets.euroZuCent(betrag[i]) <= wert; j++)
      {
        wert -= Tickets.euroZuCent(betrag[i]);
      }
      if (0 < j)
      {
        ergebnis += String.format("%d x %.2f €%s", j, betrag[i], (i < betrag.length - 1) ? ", " : "");
      }
    }
    
    return ergebnis;
  }

  //##########################################################################
  /**
  */
  //##########################################################################
	public static void bezahlen(Tickets ticket)
	{
    int gabe = 1;
    int rest = ticket.getTarifCent();
    
    System.out.format("\nSie haben sich für %s [%.2f €] entschieden!", ticket.getFahrt(), ticket.getTarifEuro());
        
    while(0 < rest && 0 < gabe)
    {
      gabe = Tickets.euroZuCent(Eingabe.auswahl(String.format("Zahlen sie den Betrag ein [%.2f €]: ", Tickets.centZuEuro(rest)), betrag));
      rest -= gabe;
    }
    
    if (gabe <= 0)
    {
      System.out.format("\nGeldannahme abgebrochen!");
      System.out.format("\nSie bekommen %.2f € zurück", ticket.getTarifEuro() - rest);
      System.out.format("\nDas entspricht %s", encrypt(ticket.getTarifCent() - rest));
    } else {
      System.out.format("\nBitte entnehmen Sie ihre Fahrkarte ...");
      if (rest < 0)
      {
        System.out.format("\nSie bekommen %.2f € zurück", Tickets.centZuEuro(Math.abs(rest)));
        System.out.format("\nDas entspricht %s", encrypt(Math.abs(rest)));
      }
    }
  }
}
