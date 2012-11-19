import java.util.ListIterator;
import java.lang.ClassCastException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Wrapper<T extends Shorter,U> implements Shorter{
	private final T elem;
	private MyList<U> list;

	public Wrapper (T e){
		this.elem = e;
		list = new MyList<U>();
	}

	public T getElem(){ return this.elem; }

	public boolean shorter(Object o){
		if(getClass().equals(o.getClass())){
			Wrapper<T,U> w = (Wrapper<T,U>) o;
			return elem.shorter(w.getElem());
		}
		else
			throw new ClassCastException();
	}

	public void add(U listelem){
		list.add(listelem);
	}
	public ListIterator<U> iterator(){
    	return this.list.iterator();
    }

	public boolean equals(Wrapper<T,U> that) {
		if(this.elem != that.getElem())
			return false;
		return true;
    }
}

public class OrderedMap<T extends Shorter, U> extends OrderedSet<Wrapper<T, U>>{
	public OrderedMap (){
		super();
	}

	class MyIterator implements Iterator<T> {
	    Iterator<Wrapper<T,U>> iter;
	    Wrapper<T,U> cur;

    	MyIterator(Iterator<Wrapper<T,U>> i) {
      		this.iter = i;
    	}

    	public boolean hasNext() {
      		return iter.hasNext();
    	}

    	public T next() {
    	  cur=iter.next();
    	  return cur.getElem();
    	}

    	public void remove() {
      		iter.remove();
    	}

    	public ListIterator iterator(){
    		return cur.iterator();
    	}
    }

	private boolean contains(Wrapper<T,U> w){
		ListIterator<Wrapper<T,U>> iter = this.list.iterator();
		while(iter.hasNext())
			if(iter.next().equals(w))
				return true;
		return false;
	}

	@Override
	public void insert(T e){
		Wrapper<T,U> wrap = new Wrapper<T,U>(e);
		ListIterator<Wrapper<T,U>> iter = this.list.iterator();

		if(!list.contains(wrap)){
			while(iter.hasNext()){
				if(!iter.next().shorter(wrap)){
					iter.previous();
					iter.add(wrap);
					return;
				}
			}
			iter.add(wrap);
		}
	}

	/*public ListIterator<T> iterator(){
		ListIterator<Wrapper<T,U>> iter = this.list.iterator();

	}*/
}