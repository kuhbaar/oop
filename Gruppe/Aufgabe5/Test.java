import java.util.Iterator;

public class Test {
  public static void main(String[] args) {
    MyList<String> l = new MyList<String>();
    MyListIterator<String> iter = l.iterator();
    iter.add("Hello");
    iter.add("world");
    iter.add("!");

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

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
  }
}