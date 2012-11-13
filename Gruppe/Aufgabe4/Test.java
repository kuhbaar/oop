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
    temp2.add(Arrays.asList(new Box(4, 2, '@', ' '), new Box(4, 2, '%', 'o')));

    Pict w = new Scaled<Box>(temp2);
    System.out.println(w);
    w.scale(2.4);
    System.out.println(w);

  }
}