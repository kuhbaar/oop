import java.lang.RuntimeException;

public class KeksmaschineWeihnachtsmann extends Keksbackmaschine{
  public Keks backe(){
    if(this.teig == null) throw new RuntimeException();
    return new Keks(Form.Weihnachtsmann, teig);
  }
}