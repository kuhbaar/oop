import java.lang.Iterable;

public class OrderedSet<T extends Shorter> extends Set<T>{
	public OrderedSet(){
		super();
	}

	public void insert(T e){
		MyListIterator<T> iter = this.iterator();
		while(iter.hasNext()){
			if(!iter.next().shorter(e)){
				iter.add(e);
				return;
			}
		}
		iter.add(e);
	}
}