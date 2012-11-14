public class Test {
  public static void main(String[] args) {
    MyList<String> l = new MyList<String>();

    l.add("Hello");
    l.add("world");
    l.add("!");

    l.add(3, "how are you?");
    System.out.println("Removed: " + l.remove(2));
    

    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }
  }
}