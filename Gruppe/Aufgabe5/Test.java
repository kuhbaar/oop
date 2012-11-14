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
  }
}