import java.util.NoSuchElementException;
import java.util.Iterator;

@AuthorClass(author="Julian Schrittwieser")
public class MyMap implements Iterable {

  /* private wrapper class to hold entries into the map */
  private class Elem {
    private final String key;
    private final Object value;

    private Elem prev = null;
    private Elem next = null;

    /* create a new map entry with key and value */
    private Elem(String key, Object value) {
      this.value = value;
      this.key = key;
    }

  }

  /* iterator over the map, next() returns the keys of the map */
  private class MyIterator implements Iterator {
    private Elem cur;
    private int curIdx = -1;

    /* create a new iterator, starting at some element (usually the first) */
    private MyIterator(Elem start) {
      Elem temp = new Elem(null, null);
      temp.next = start;
      this.cur = temp;
    }

    /* true if there are elements left to iterate over */
    public boolean hasNext() {
      return cur.next != null;
    }

    /* true if there are elements previous to the current one, only used internally */
    private boolean hasPrevious() {
      return cur.prev != null;
    }

    /* return the next element and advance the iterator. throws NoSuchElementException
       if there are no more elements */
    public String next() {
      if(!hasNext())
        throw new NoSuchElementException();

      cur = cur.next;
      curIdx += 1;
      return cur.key;
    }

    /* private method to get the value for the current element */
    private Object value() {
      return cur.value;
    }

     /* removes the current element, or throws an exception if the iterator
        hasn't been advanced yet */
    public void remove() {
      if(curIdx < 0)
        throw new IllegalStateException();

      if(curIdx == 0) {
        if(hasNext())
          first = cur.next;
        else
          first = null;
      }

      if(hasNext()) {
        cur.next.prev = cur.prev;
      } else {
        if(cur.prev == null)
          last = null;
        else
          last = cur.prev;
      }

      if(cur.prev != null)
        cur.prev.next = cur.next;

      size -= 1;
    }

    /* change the value of the current element */
    private void set(Object value) {
      Elem n = new Elem(cur.key, value);
      n.next = cur.next;
      n.prev = cur.prev;

      if(hasNext())
        cur.next.prev = n;

      if(hasPrevious())
        cur.prev.next = n;
    }
  }

  private Elem first = null;
  private Elem last = null;
  private int size = 0;

  /* returns the size of the map = number of elements */
  public int size() {
    return size;
  }

  /* returns an iterator over all the keys, starting with the first element */
  public Iterator iterator() {
    return new MyIterator(first);
  }

  /* true if the map contains a given key, false otherwise */
  public boolean contains(String key) {
    MyIterator iter = new MyIterator(first);
    while(iter.hasNext())
      if(iter.next().equals(key))
        return true;
    return false;
  }

  /* set the value for the given key to value. Overwrites the old value if the
     key already exists */
  public void put(String key, Object value) {
    MyIterator iter = new MyIterator(first);
    while(iter.hasNext()) {
      if(iter.next().equals(key)) {
        /* already have the key, change the value */
        iter.set(value);
        return;
      }
    }

    /* key not in map, add it to the end */
    Elem e = new Elem(key, value);

    if(first == null) {
      first = e;
      last = first;
    } else {
      last.next = e;
      e.prev = last;
      last = e;
    }

    size += 1;
  }

  /* get the value for the key, null if the key isn't in the map */
  public Object get(Object key) {
    MyIterator iter = new MyIterator(first);
    while(iter.hasNext())
      if(iter.next().equals(key))
        return iter.value();
    return null;
  }

  /* remove the entry for key from the map. If it isn't in the map, nothing happens */
  public void remove(Object key) {
    MyIterator iter = new MyIterator(first);
    while(iter.hasNext())
      if(iter.next().equals(key))
        iter.remove();
  }

}

