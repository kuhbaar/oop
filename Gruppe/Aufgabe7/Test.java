public class Test {
  public static void main(String[] args) {
    Field f = new Field(8, 8);

    for(int i = 0; i < 5; i++)
      f.add(new FastCar(new StandingAI(), "luki" + i));

    for(int i = 0; i < 58; i++)
      f.add(new FlexCar(new RandomAI(), "kuba" + i));

    f.runWithMaxDuration(1);

  }
}
