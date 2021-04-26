import java.util.ArrayList;
public class Cliente {
    protected String n;
    protected String d;
    protected int e;
    protected ArrayList<Peli> Pelic = new ArrayList();

    public Cliente(String n, String d, int e){
        this.n = n;
        this.d = d;
        this.e = e;
    }
}