import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;

// all test classes should extend AbstractTest to get useful utility methods
public class PlayListTest extends AbstractTest {
  List<String> l;
  Date a, b, c,d;

  @BeforeClass
  public void initializeCommonValues() {
    // provide some common values
    Calendar cal = Calendar.getInstance();
    cal.set(2012, 9, 15);
    a = cal.getTime();

    cal.set(2012, 10, 4);
    b = cal.getTime();

    cal.set(2012, 10, 10);
    c = cal.getTime();
  
    cal.set(2012, 10, 5);
    d = cal.getTime();
  }

 
  @UnitTest
  public void testAddSong() {
    Musikgruppe m = new Musikgruppe();
  
    Song test = new Song("Ueber den Wolken",150);
  
    Song rest = new Song("Tanzen im Regen",170);
    Song west = new Song("Rote Lippen",147);
  
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
   @UnitTest
  public void testRemoveSong() {
    Musikgruppe m = new Musikgruppe();
  
    Song test = new Song("Ueber den Wolken",150);
  
    Song rest = new Song("Tanzen im Regen",170);
    Song west = new Song("Rote Lippen",147);
    
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    m.addSong("Rote Lippen",147);
    m.deleteSong("Rote Lippen");
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
  @UnitTest
  public void testGetPlaylist() {
    Musikgruppe m = new Musikgruppe();

    Song test = new Song("Ueber den Wolken",150);

    Song rest = new Song("Tanzen im Regen",170);
    Song west = new Song("Rote Lippen",147);

    m.addSong("Ueber den Wolken",150,a);
    m.addSong("Tanzen im Regen",170,c);
    m.addSong("Rote Lippen",147,b);
    assertEqual(m.getPlaylist(a,d).toString(), "[Ueber den Wolken - 2:30, Rote Lippen - 2:27]");
  }
  
/*
  @UnitTest
  public void getCurrentPlayList() {
    Musikgruppe m = new Musikgruppe();

    m.newAuftritt("wien", a, b, new BigDecimal("100.10"));
    m.newAuftritt("salzburg", a, b, new BigDecimal("500.0"));
    m.newProbe("tirol", b, c, new BigDecimal("20.16"));

    List<Probe> ps = m.getProben(a, c);
    assertEqual(ps.size(), 1);
    assertEqual(ps.get(0).getOrt(), "tirol");

    assertEqual(m.getAuftritte(a, c).size(), 2);
    assertEqual(m.getEvents(a, c).size(), 3);

    assertEqual(m.getEvents(b, c).size(), 1);
    assertEqual(m.getEvents(a, b).size(), 2);
  }

  @UnitTest
  public void testCostSums() {
    Musikgruppe m = new Musikgruppe();

    m.newAuftritt("wien", a, b, new BigDecimal("100.10"));
    m.newAuftritt("salzburg", b, c, new BigDecimal("500.0"));
    m.newProbe("tirol", b, c, new BigDecimal("20.16"));

    assertEqual(new BigDecimal("-20.16"), m.getCostsProben(a, c));
    assertEqual(new BigDecimal("600.1"), m.getGageAuftritte(a, c));
    assertEqual(new BigDecimal("479.84"), m.getCostsEvents(c, c));

  }
*/
}