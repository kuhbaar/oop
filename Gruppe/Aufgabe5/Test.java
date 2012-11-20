import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

class OString implements Shorter<OString> {
  final String s;

  public OString(String s) {
    this.s = s;
  }

  public String toString() { return s; }
  public boolean shorter(OString e) {
    return this.toString().length() < e.toString().length();
  }
}

public class Test {
  public static void main(String[] args) {
    MyList<String> l = new MyList<String>();
    ListIterator<String> iter = l.iterator();
    iter.add("Hello");
    iter.add("world");
    iter.add("!");

    System.out.println("===== List iterator add test");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    iter = l.iterator();
    System.out.println("advanced to: " + iter.next());
    System.out.println("advanced to: " + iter.next());
    iter.set("badum");

    l.add(3, "how are you?");

    System.out.println("===== List iterator set test");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    l.remove(3);

    System.out.println("===== List remove test");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    System.out.println(l.contains("Hello"));
    System.out.println(l.contains(new String("Hello")));

    System.out.println("===== Set Test");
    Set<String> s = new Set<String>();

    s.insert("Hello");
    s.insert("world");
    s.insert("how are you?");
    s.insert("!");
    s.insert("abc");
    s.insert("def");
    s.insert("abc");
    Iterator<String> siter = s.iterator();

    System.out.println(s);

    System.out.println("===== OrderedSet Test");

    ArrayList<OString> t = new ArrayList<OString>();
    t.add(new OString("hello"));
    t.add(new OString("world"));
    t.add(new OString("how are you?"));
    t.add(new OString("abc"));
    t.add(new OString("def"));
    t.add(new OString("abc"));
    t.add(new OString("a234"));
    t.add(new OString("123456"));
    t.add(new OString("12345"));

    OrderedSet<OString> oset = new OrderedSet<OString>();

    for(OString str : t) {
      //System.out.println("Inserting '" + str + "'");
      oset.insert(str);
      //System.out.println(oset);
    }
    
    System.out.println(oset);


    System.out.println("===== OrderedMap Test");
    OrderedMap<OString, Integer> omap = new OrderedMap<OString, Integer>();


    for(OString str : t) {
      // System.out.println("Inserting '" + str + "'");
      omap.insert(str);
      // System.out.println(oset);
    }
    
    System.out.println(omap);

    MapIterator<OString, Integer> miter = omap.iterator();
    miter.next();
    miter.next();
    ListIterator<Integer> liter = miter.iterator();
    liter.add(5);

    miter.next();
    liter = miter.iterator();
    liter.add(10);
    liter.add(42);

    System.out.println(omap);

    /* 1. Erzeugen Sie eine Instanz von OrderedSet deren Elemente vom Typ 
          Description sind. Fügen Sie einige Elemente in unsortierter 
          Reihenfolge ein, lesen Sie alle Elemente der Menge über den Iterator 
          aus, und schreiben Sie die Anzahlen der Zeilen in die Standard-Ausgabe.
          Führen Sie Änderungen durch und geben Sie die Elemente erneut aus. 
          Diesen Vorgang können Sie mit unterschiedlichen Änderungen so oft
          wiederholen, wie es Ihnen als nötig erscheint.
     */

    System.out.println("===== 1. OrderedSet<Description>");
    OrderedSet<Description> oDesc = new OrderedSet<Description>();
    oDesc.insert(new Description("this is a description"));
    oDesc.insert(new Description("another description"));
    oDesc.insert(new Description("very short"));
    oDesc.insert(new Description("and this is a very verbose description"));
    oDesc.insert(new Description("a normal one"));

    int num_lines = 0;
    for(Description desc : oDesc) {   /* use iterator implicitly */
      num_lines += desc.numberOfLines();
      System.out.println(desc);
    }
    System.out.println(num_lines);

    oDesc.insert(new Description("a medium description"));
    Iterator<Description> oDescIter = oDesc.iterator();
    oDescIter.next();
    oDescIter.next();
    oDescIter.next();
    oDescIter.remove();

    System.out.println(oDesc);

    /* 2. Erzeugen Sie eine Instanz von OrderedMap, deren Elemente vom Typ  
          MeanElapsedTime sind und die auf Objekte vom Typ CompositeTime 
          verweisen – nicht sehr sinnvoll, aber gut zum Testen geeignet. Fügen 
          Sie einige Elemente und damit verbundene Objekte ein, lesen Sie alles 
          über die Iteratoren aus, und schreiben Sie jeweils den größten 
          Messwert (für Elemente) bzw. die kürzeste Einzelzeit (für Objekte, auf 
          die Elemente verweisen) in die Standard-Ausgabe. Testen Sie Änderungen
          ähnlich wie bei Punkt 1.
     */

    System.out.println("===== 2. OrderedMap<MeanElapsedTime, CompositeTime>");
    OrderedMap<MeanElapsedTime, CompositeTime> om = 
      new OrderedMap<MeanElapsedTime,CompositeTime>();
    MeanElapsedTime a = new MeanElapsedTime();
    MeanElapsedTime b = new MeanElapsedTime();
    MeanElapsedTime c = new MeanElapsedTime();
    a.add(new Double(10));
    a.add(new Double(20));
    a.add(new Double(30));
    b.add(new Double(1));
    b.add(new Double(2));
    b.add(new Double(3));
    c.add(new Double(9));
    Double[] x = new Double[]{5.0,15.0,30.0};
    CompositeTime d = new CompositeTime(x);
    Double[] y = new Double[]{15.0,115.0,130.0};
    CompositeTime e = new CompositeTime(y);
    om.insert(a);
    om.insert(b);
    om.insert(c);

    MapIterator<MeanElapsedTime, CompositeTime> mi = om.iterator();
    mi.next();
    ListIterator<CompositeTime> li = mi.iterator();
    li.add(d);
    mi.next();
    li = mi.iterator();
    li.add(e);

    miter.next();
    liter = miter.iterator();
    liter.add(10);
    liter.add(42);

    mi = om.iterator();
    while(mi.hasNext()) {
      System.out.print(mi.next());

      li = mi.iterator();
      if(li.hasNext())
        System.out.print(": " + li.next());
      while(li.hasNext())
        System.out.println(", " + li.next());
      System.out.println();
    }

    /* 3. Falls OrderedMap mit entsprechenden Typparameterersetzungen ein 
          Untertyp von OrderedSet ist, betrachten Sie die in Punkt 2 erzeugte 
          Menge als Instanz von OrderedSet, fügen Sie noch einige Elemente ein, 
          lesen Sie alle Elemente über den Iterator aus, und schreiben Sie die 
          größten Messwerte in die Standard-Ausgabe. Falls OrderedMap kein 
          Untertyp von OrderedSet ist, geben Sie anstelle der Testergebnisse 
          eine Begründung dafür aus, warum zwischen diesen Typen keine 
          Untertypbeziehung besteht. 
     */

    System.out.println("===== 3. OrderedSet<MeanElapsedTime>");
    OrderedSet<MeanElapsedTime> oMeanElapsedTime = om;
    MeanElapsedTime elapsedTime1 = new MeanElapsedTime();
    elapsedTime1.add(20.);
    elapsedTime1.add(10.);
    MeanElapsedTime elapsedTime2 = new MeanElapsedTime();
    elapsedTime1.add(35.);
    elapsedTime1.add(15.);
    oMeanElapsedTime.insert(elapsedTime1);
    oMeanElapsedTime.insert(elapsedTime2);
    for(MeanElapsedTime elapsed : oMeanElapsedTime) {
      System.out.println(elapsed.getLongest());
    }

    /* 4. Erzeugen Sie eine Instanz von OrderedSet, deren Elemente vom Typ 
          ElapsedTime sind. Lesen Sie alle Elemente der in Punkt 2 erzeugten 
          (und möglicherweise in Punkt 3 erweiterten) Menge und alle Objekte, 
          auf welche die Elemente verweisen, aus und fügen Sie diese (Instanzen 
          von MeanElapsedTime ebenso wie von CompositeTime) in die neue Menge 
          ein. Lesen Sie alle Elemente der neuen Menge aus, und schreiben Sie 
          die durch count ermittelten Werte in die Standard-Ausgabe.
     */

    System.out.println("===== 4. OrderedSet<MeanElapsedTime>");
    OrderedSet<ElapsedTime> oElapsedTime = new OrderedSet<ElapsedTime>();
    mi = om.iterator();
    while(mi.hasNext()) {
      oElapsedTime.insert(mi.next());
      li = mi.iterator();
      while(li.hasNext())
        oElapsedTime.insert(li.next());
    }

    for(ElapsedTime elapsed : oElapsedTime) {
      System.out.println(elapsed + ": " + elapsed.count());
    }

  }
}