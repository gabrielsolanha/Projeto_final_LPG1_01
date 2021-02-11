package src.classes;

import java.util.ArrayList;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

public class TelefoneEmail {
    public enum Tipo {
        EMAIL,
        TELEFONE
    }

    private String id;
    private String rotulo;
    private String valor;
    private Tipo tipo;
    private Contato contato;

    public TelefoneEmail() {
    }

    public TelefoneEmail(String id, String rotulo, String valor, Tipo tipo, String contatoId){
        this.id = id;
        this.rotulo = rotulo;
        this.valor = valor;
        this.tipo = tipo;

        this.contato = Contato.findById(contatoId);
    }

    public static ArrayList<TelefoneEmail> index() {// Pode ter algum filtro aqui
        ArrayList<TelefoneEmail> list = new ArrayList<TelefoneEmail>();
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
        System.err.println("Listou tefoneEmails");
        return list;
    }

    public static TelefoneEmail findById(String id) {
        // executa select
        System.err.println("Mostrou TelefoneEmail com id: "+id);
        return new TelefoneEmail();
    }

    public void create(String rotulo, String valor, Tipo tipo, String contatoId) {
        this.tipo = tipo;
        this.rotulo = rotulo;
        this.valor = valor;
        this.contato = Contato.findById(contatoId);

        // Executa Insert
        // String comando = "INSERT INTO...";
        // Statement Instrucao;
        // Instrucao = conexao.createStatement();
        // ResultSet result = null;
        // result = Instrucao.executeUpdate(comando);

        // String idFromDb = "11bf5b37-e0b8-42e0-8dcf-dc8c4aefc000";
        String idFromDb = "idfacil";
        this.id = idFromDb;

        System.err.println("Criou TelefoneEmail");
    }

    public void update() {
        // Caso a pessoa já atualizou pelos setters
        // Executa Update

        System.err.println("Updated: TelefoneEmail id: " + this.id);
    }

    public void update(String rotulo, String valor, Tipo tipo) {
        // Atualiza direto e depois salva
        this.tipo = tipo;
        this.rotulo = rotulo;
        this.valor = valor;
        // Executa Update
        System.err.println("Updated: TelefoneEmail id: " + this.id);
    }

    public void delete() {
        String deletedId = this.id;
        this.id = null;
        this.tipo = null;
        this.rotulo = null;
        this.valor = null;
        // Executa Delete
        System.err.println("Deleted: TelefoneEmail id: " + deletedId);
    }

    public String getId() {
        return this.id;
    }

    public String getRotulo() {
        return this.rotulo;
    }

    public void setRotulo(String valor) {
        this.rotulo = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo valor) {
        this.tipo = valor;
    }
    
    public Contato getContato() {
        return this.contato;
    }

}