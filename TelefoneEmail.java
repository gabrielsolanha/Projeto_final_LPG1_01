import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class TelefoneEmail {
    private int uuid;
    private String rotulo;
    private String valor;
    private String tipo;
    

    public void Adicionar(int uuid, String rotulo, String valor, String tipo){
        this.uuid = uuid;
        this.tipo=tipo;
        this.rotulo=rotulo;
        this.valor=valor;
    }
    public void Atulizar(String rotulo, String valor, String tipo){
        this.tipo=tipo;
        this.rotulo=rotulo;
        this.valor=valor;
    }
    public void Remover(int uuid){
        this.uuid=-1;
        this.tipo="";
        this.rotulo="";
        this.valor="";
    }
    public ArrayList<TelefoneEmail> ListarTodos(){

    }
    public TelefoneEmail Mostrar(){
        
    }

}