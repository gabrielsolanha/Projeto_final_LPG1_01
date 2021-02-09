import java.sql.Date;
import java.util.ArrayList;

public class Contato {
    private int uuid;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private ArrayList<TelefoneEmail> telefoneEmails;
    
    public void Adicionar(int uuid, String nome, String sobrenome, Date dataNascimento, TelefoneEmail e){
        this.uuid = uuid;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefoneEmails = new ArrayList<>();
        this.telefoneEmails.add(e);
    }

    public void Adicionar(TelefoneEmail e){
        this.telefoneEmails.add(e);
    }
    
    public void Atulizar(String nome, String sobrenome, Date dataNascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }
    
    public void Remover(){
        this.uuid = -1;
        this.nome = "";
        this.sobrenome = "";
        this.telefoneEmails = new ArrayList<>();
    }
    
    public ArrayList<Contato> ListarTodos(){

    }
    
    public Contato Mostrar(){
        
    }

    public ArrayList<TelefoneEmail> getTelefoneEmails() {
        return telefoneEmails;
    }
}
