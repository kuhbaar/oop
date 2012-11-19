import java.util.ListIterator;

class Wrapper<T extends Shorter,U> implements Shorter{
	private T elem;
	private MyList<U> list;

	public Wrapper (T e){
		this.elem = e;
		list = new MyList<U>();
	}

	public T getElem(){ return this.elem; }

	public boolean shorter(Object o){
		return elem.shorter(o);
	}

	public ListIterator<U> iterator(){
    	return this.list.iterator();
    }

	public boolean equals(Wrapper<T,U> that) {
		if(this.elem != that.getElem())
			return false;
    	
    	ListIterator<U> thisiter = this.iterator();
    	ListIterator<U> thatiter = that.iterator();
    	while(thisiter.hasNext() && thatiter.hasNext())
      		if(thisiter.next() == thatiter.next())
        		return true;
    	return false;
    }
}

public class OrderedMap<T extends Shorter, U> extends OrderedSet<Wrapper<T, U>>{
	public OrderedMap (){
		super();
	}

	@Override
	public void insert(T e){
		Wrapper<T,U> wrap = new Wrapper<T,U>(e);
		ListIterator<Wrapper<T,U>> iter = this.list.iterator();

		if(!list.contains(e)){
			while(iter.hasNext()){
				if(!iter.next().shorter(e)){
					iter.previous();
					iter.add(e);
					return;
				}
			}
			iter.add(e);
		}
	}
}