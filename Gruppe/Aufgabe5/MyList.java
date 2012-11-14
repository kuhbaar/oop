public class MyList<T> {
  class Elem<T> {
    final T value;

    Elem<T> prev = null;
    Elem<T> next = null;

    Elem(T value) {
      this.value = value;
    }
  }

  Elem<T> first = null;
  Elem<T> last = null;
  int size = 0;

  public int size() {
    return size;
  }

  public void add(T value) {
    Elem<T> e = new Elem<T>(value);

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

  public void add(int index, T value) throws IndexOutOfBoundsException {
    if(index == size)
      add(value);
    else if(index < size) {
      Elem<T> cur = first;
      for(int i = 0; i < index; i++)
        cur = cur.next;

      Elem<T> n = new Elem<T>(value);
      cur.prev.next = n;
      n.prev = cur.prev;
      n.next = cur;
      cur.prev = n;

      size += 1;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public T get(int index) throws IndexOutOfBoundsException {
    if(index >= size)
      throw new IndexOutOfBoundsException();

    Elem<T> cur = first;
    for(int i = 0; i < index; i++)
      cur = cur.next;
    return cur.value;
  }

  public T remove(int index) throws IndexOutOfBoundsException {
    if(index >= size)
      throw new IndexOutOfBoundsException();

    Elem<T> cur = first;
    for(int i = 0; i < index; i++)
      cur = cur.next;

    cur.prev.next = cur.next;
    cur.next.prev = cur.prev;

    size -= 1;

    return cur.value;
  } 

}

