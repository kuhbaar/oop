public class Test {
  public static void main(String[] args) {
    Pict p = new Box(10, 4, '*', '.');

    System.out.println(p);

    p.scale(2.4);

    System.out.println(p);

    Pict q = new ClearBox(5, 3);
    System.out.println(q);


    q.scale(3.4);
    System.out.println(q);

  }
}