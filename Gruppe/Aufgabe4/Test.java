import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Pict p = new Box(10, 4, '*', '.');

    System.out.println(p);

    p.scale(2.4);

    System.out.println(p);

    Pict q = new ClearBox(5, 3);
    System.out.println(q);

    /* ClearBox ist ein Untertyp von Box, da es alle Zusicherungen von Box einhält,
       und nur zusätzlich die verwendeten Zeichen festlegt und eine Funktion für
       das Seitenverhältnis einführt */

    /* DarkBox ist kein Untertyp von Box oder ClearBox, da sich das verwendete 
       Zeichen jederzeit ändern kann, und somit die Zusicherungen von Box (und 
       damit auch ClearBox) verletzt sind */

    /* Repeated<Char> und FreeBox sind äquivalent, wie auch an der Implementierung
       von Repeated<P> mit Hilfe von FreeBox zu erkennen ist. (mal angenommen 
       FreeBox wird passend initaliesert) */

    /* Ähnliches gilt damit auch für Repeated<P> und Repeated<P extends Pict>, 
       bei Repeated wird die toString() Ausgabe der einzelnen Objekte einfach mit
       Leerzeichen ausgefüllt bis alle gleich groß sind, anschließend verhält es 
       sich genau wie eine FreeBox (ist es ja intern auch) 
       Im Prinzip könnte man daher Repeated ganz weglassen und einfach als zusätzlicher
       Konstruktor in FreeBox implementieren. */

    /* Scaled<P> und Scaled<P extends Pict> verhalten sich ganz anders als die 
       übrigen Klassen hier, da alle Objekte jeweils einzeln skaliert werden, bevor
       sie in toString() verarbeitet werden. Somit kann es auch keinerlei Untertyp
       Beziehungen geben. */

    /* Freebox ist kein Untertyp von Box/Clearbox, da in dieser Klasse keine Zeichen
       für den Rand/Körper angegeben werden, sondern ein Bild übergeben wird. Dadurch
       besitzt Freebox womöglich keinen einheitlichen Rand. Somit sind die Zusicherungen
       von Box/Clearbox verletzt.

    q.scale(3.4);
    System.out.println(q);

    Pict v = new FreeBox(Arrays.asList(
        "12345",
        "67890"
    ));

    System.out.println(v);
    v.scale(1.5);
    System.out.println(v);

    List<List<String>> temp1 = new ArrayList<List<String>>();
    temp1.add(Arrays.asList("12", "34", "56\n2"));
    temp1.add(Arrays.asList("78", "90", "abc"));

    Pict u = new Repeated<String>(temp1);
    System.out.println(u);
    u.scale(3.4);
    System.out.println(u);

    List<List<Box>> temp2 = new ArrayList<List<Box>>();
    temp2.add(Arrays.asList(new Box(4, 3, '-', '.'), new Box(4, 2, '=', ',')));
    temp2.add(Arrays.asList(new ClearBox(3, 3), new Box(4, 2, '%', 'o')));

    Pict w = new Scaled<Box>(temp2);
    System.out.println(w);
    w.scale(2.4);
    System.out.println(w);

  }
}