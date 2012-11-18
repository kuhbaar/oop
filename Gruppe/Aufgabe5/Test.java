import java.util.Iterator;
import java.util.ListIterator;

class OString implements Shorter {
  final String s;

  public OString(String s) {
    this.s = s;
  }

  public String toString() { return s; }
  public boolean shorter(Object e) {
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

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    iter = l.iterator();
    System.out.println("advanced to: " + iter.next());
    System.out.println("advanced to: " + iter.next());
    iter.set("badum");

    l.add(3, "how are you?");

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    l.remove(3);

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    System.out.println(l.contains("Hello"));
    System.out.println(l.contains(new String("Hello")));

    System.out.println("===== Set Test");
    Set<String> s = new Set<String>();

    s.insert("Hello");
    s.insert("world");
    s.insert("!");
    Iterator<String> siter = s.iterator();

    for(int i=0; i<3 ; i++){
      System.out.println(siter.next());
    }

    OrderedSet<OString> t = new OrderedSet<OString>();
    t.insert(new OString("hello"));
    t.insert(new OString("world"));
    t.insert(new OString("how are you?"));
    t.insert(new OString("abc"));
    t.insert(new OString("def"));
    t.insert(new OString("abc"));
    t.insert(new OString("123456"));
    t.insert(new OString("1234"));
    t.insert(new OString("12345"));

    System.out.println("===== ordered set test");
    for(OString str : t) {
      System.out.println(str);
    }
  }
}