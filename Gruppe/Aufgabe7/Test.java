public class Test {
  public static void main(String[] args) {

    /* useful to make sure there are no deadlocks */
    System.out.println("\n\n\tCompletely full field");
    Field f = new Field(8, 8);

    for(int i = 0; i < 5; i++)
      /* add sets position and direction randomly */
      f.add(new FastCar(new StandingAI(), "luki" + i));

    for(int i = 0; i < 59; i++)
      f.add(new FlexCar(new RandomAI(), "kuba" + i));

    f.runWithMaxDuration(1);



    /* test timeout */
    System.out.println("\n\n\tSingle driver");
    f = new Field(15, 9);
    f.add(new FlexCar(new RandomAI(), "forever alone guy"));
    f.runWithMaxDuration(1);



    System.out.println("\n\n\tNormal Race");
    f = new Field(14, 12);

    for(int i = 0; i < 5; i++)
      f.add(new FlexCar(new AlwaysLeftAI(), "communist" + i));

    for(int i = 0; i < 10; i++)
      f.add(new FastCar(new RandomAI(), "kuba" + i));

    f.runWithMaxDuration(1);




    System.out.println("\n\n\tLeft-Right Race");
    f = new Field(20, 8);

    for(int i = 0; i < 5; i++)
      f.add(new FlexCar(new AlwaysLeftAI(), "communist" + i));

    for(int i = 0; i < 5; i++)
      f.add(new FastCar(new AlwaysRightAI(), "strache" + i));

    for(int i = 0; i < 5; i++)
      f.add(new FastCar(new RandomAI(), "bzoe" + i));

    f.runWithMaxDuration(1);
    


    System.out.println("\n\n\tAll circling race");
    f = new Field(30, 7);

    for(int i = 0; i < 5; i++)
      f.add(new FlexCar(new AlwaysLeftAI(), "communist" + i));

    for(int i = 0; i < 5; i++)
      f.add(new FlexCar(new AlwaysRightAI(), "strache" + i));

    for(int i = 0; i < 5; i++)
      f.add(new FlexCar(new InfinityAI(), "beyond" + i));

    f.runWithMaxDuration(1);
  }
}
