import java.util.Date;

public class Record<T> {
  public Record(T value, Date begin, Date end) {
    this.value = value;
    this.begin = begin;
    this.end = end;
  }

  public long getDuration() { 
    return end.getTime() - begin.getTime();
  }
  public Date getBegin() { return begin; }
  public Date getEnd() { return end; }
  public T getValue() { return value; }

  protected T value;
  protected Date begin;
  protected Date end;
}