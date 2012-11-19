import java.lang.Iterable;
import java.util.ListIterator;

public class OrderedSet<T extends Shorter> extends Set<T>{
	public OrderedSet(){
		super();
	}

	public void insert(T e){
		ListIterator<T> iter = this.list.iterator();
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