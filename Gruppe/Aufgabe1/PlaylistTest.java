import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;

// all test classes should extend AbstractTest to get useful utility methods
public class PlaylistTest extends AbstractTest {
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
    MusicGroup m = new MusicGroup("Onkelz");
  
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
   @UnitTest
  public void testRemoveSong() {
    MusicGroup m = new MusicGroup("Rammstein");
    
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    m.addSong("Rote Lippen",147);
    m.deleteSong("Rote Lippen");
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
  @UnitTest
  public void testGetPlaylist() {
    MusicGroup m = new MusicGroup("Musikantenstadl");

    m.addSong("Ueber den Wolken",150,a);
    m.addSong("Tanzen im Regen",170,c);
    m.addSong("Rote Lippen",147,b);
    assertEqual(m.getPlaylist(a,d).toString(), "[Ueber den Wolken - 2:30, Rote Lippen - 2:27]");
  }
}