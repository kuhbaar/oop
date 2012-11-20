import java.lang.Iterable;
import java.util.Iterator;

public class Set<T> implements Iterable<T>{
	protected final MyList<T> list;

	public Set(){
		this.list = new MyList<T>();
	}

	public Iterator<T> iterator(){
		return this.list.iterator();
	}

	public void insert(T e){
		if(!this.list.contains(e))
			this.list.add(e);
	}

	public String toString() {
		String out = "";
		for(T e : this.list) {
      out += e + "\n";
    }
    return out;
	}
}