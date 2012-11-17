import java.lang.Iterable;

public class Set<T> implements Iterable<T>{
	private MyList<T> list;

	public Set(){
		list = new MyList<T>();
	}

	public MyListIterator<T> iterator(){
		return list.iterator();
	}

	public void insert(T e){
		if(!list.contains(e))
			list.add(e);
	}
}