import java.lang.Iterable;
import java.util.Iterator;

public class Set<T> implements Iterable<T>{
	protected MyList<T> list;

	public Set(){
		list = new MyList<T>();
	}

	public Iterator<T> iterator(){
		return list.iterator();
	}

	public void insert(T e){
		if(!list.contains(e))
			list.add(e);
	}

	public String toString() {
		String out = "";
		for(T e : list) {
      out += e + "\n";
    }
    return out;
	}
}