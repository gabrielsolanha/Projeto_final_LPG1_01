package src.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;
import java.util.ArrayList;
import src.utils.Valiadator;

public class Contato {
    private String id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private ArrayList<TelefoneEmail> telefoneEmails;

    public Contato() {
    }
        
    public Contato(
        String id, 
        String nome, 
        String sobrenome, 
        Date dataNascimento, 
        ArrayList<TelefoneEmail> telefoneEmails
    ){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefoneEmails = telefoneEmails;
    }

    public static ArrayList<Contato> index() {// Pode ter algum filtro aqui
        ArrayList<Contato> list = new ArrayList<Contato>();
        // Executa Select
        // String comando = "SELECT * FROM ...";
        // Statement Instrucao;
        // Instrucao = conexao.createStatement();
        // ResultSet result = null;
        // result = Instrucao.executeQuery(comando);

        // while(result.next()){
        //     String id = result.getString("id");
        //     String rotulo = result.getString("rotulo");
        //     String tipo = result.getString("tipo");
        //     String valor = result.getString("valor");
        //     list.add(new TelefoneEmail(id, rotulo, valor, tipo));
        // }
        System.err.println("Listou Contatos");
        return list;
    }

    public static Contato findById(String id) {
        // executa select
        System.err.println("Mostrou Contato com id: "+id);
        return new Contato();
    }

    public void create(
        String nome,
        String sobrenome,
        Date dataNascimento,
        ArrayList<TelefoneEmail> telefoneEmails
    ){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefoneEmails = telefoneEmails;

        //Executa Insert
        // String comando = "INSERT INTO...";
        // Statement Instrucao;
        // Instrucao = conexao.createStatement();
        // ResultSet result = null;
        // result = Instrucao.executeUpdate(comando);

        String idFromDb = "11bf5b37-e0b8-42e0-8dcf-dc8c4aefc000";
        this.id = idFromDb;

        System.err.println("Criou Contato");
    }

    public void update() {
        // Caso a pessoa já atualizou pelos setters
        // Executa Update

        System.err.println("Updated: Contato id: " + this.id);
    }

    public void update(
        String nome,
        String sobrenome,
        Date dataNascimento,
        ArrayList<TelefoneEmail> telefoneEmails
    ) {
        // Atualiza direto e depois salva
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefoneEmails = telefoneEmails; 
        // Executa Update
        System.err.println("Updated: Contato id: " + this.id);
    }

    public void delete() {
        String deletedId = this.id;

        this.id = null;
        this.nome = null;
        this.sobrenome = null;
        this.dataNascimento = null;
        this.telefoneEmails = null;
        
        // Executa Delete
        System.err.println("Deleted: Contato id: " + deletedId);
    }


    public boolean validar(){
        boolean isValid = true;
 
        for (TelefoneEmail telefoneEmail : telefoneEmails) {
            String valor = telefoneEmail.getValor();
            if(telefoneEmail.getTipo() == Tipo.EMAIL){
                isValid = isValid && Valiadator.isValidEmail(valor);
            }else{
                isValid = isValid && Valiadator.isValidTelefone(valor);
            }
            if(!isValid) System.err.println("TelefoneEmail com valor "+valor+" invalido.");
        }
        return isValid;
    }

    
    public String getid (){
        return this.id;
    }

    public void setNome (String nome){
        this.nome = nome; 
    }

    public String getNome (){
        return this.nome;
    }

    public void setSobrenome (String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String getSobrenome (){
        return this.sobrenome;
    }

    public void setDataNascimento (Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }   

    public Date getDataNascimento (){
        return this.dataNascimento;
    }   
    
    public ArrayList<TelefoneEmail> getTelefoneEmails() {
        return this.telefoneEmails;
    }
}
