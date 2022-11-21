package src;
import java.util.EventObject;
public class KoliseuEvent extends EventObject{
    private int mudanca;
    public KoliseuEvent(Object source, int mudanca){
        super(source);
        this.mudanca = mudanca;
    }
    public int mudanca(){
        return mudanca;
    }
}
