package tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;
import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;
import oop.MusicGroup;

// tests the class Song and the methods in Musicgroup regarding playlist and current_playlist

public class PlaylistTest extends AbstractTest {
  List<String> l;
  Date a, b, c,d;

  @BeforeClass
  public void initializeCommonValues() {
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

 // returns true if the addSong() Method of MusicGroup is working correctly
  @UnitTest
  public void testAddSong() {
    MusicGroup m = new MusicGroup("Onkelz");
  
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
  // returns true if the deleteSong() Method of MusicGroup is working correctly
   @UnitTest
  public void testRemoveSong() {
    MusicGroup m = new MusicGroup("Rammstein");
    
    m.addSong("Ueber den Wolken",150);
    m.addSong("Tanzen im Regen",170);
    m.addSong("Rote Lippen",147);
    m.deleteSong("Rote Lippen");
    assertEqual(m.getCurrentPlaylist().toString(), "[Ueber den Wolken - 2:30, Tanzen im Regen - 2:50]");
  }
  
  //returns true if the getPlayList(Date begin, Date end) Method of MusicGroup works correctly
  @UnitTest
  public void testGetPlaylist() {
    MusicGroup m = new MusicGroup("Musikantenstadl");

    m.addSong("Ueber den Wolken",150,a);
    m.addSong("Tanzen im Regen",170,c);
    m.addSong("Rote Lippen",147,b);
    assertEqual(m.getPlaylist(a,d).toString(), "[Ueber den Wolken - 2:30, Rote Lippen - 2:27]");
  }
}