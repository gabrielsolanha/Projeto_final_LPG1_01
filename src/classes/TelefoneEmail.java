package src.classes;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TelefoneEmail {
    private String id; 
    private String rotulo;
    private String valor;
    private String tipo;
    
    public TelefoneEmail(){

    }

    public TelefoneEmail(String id, String rotulo, String valor, String tipo){
        this.id=id;
        this.rotulo=rotulo;
        this.valor=valor;
        this.tipo=tipo;
    }

    public void Create(String rotulo, String valor, String tipo){
        this.tipo=tipo;
        this.rotulo=rotulo;
        this.valor=valor;

        //Executa Insert
        // String comando = "INSERT INTO...";
        // Statement Instrucao;
        // Instrucao = conexao.createStatement();
        // ResultSet result = null;
        // result = Instrucao.executeUpdate(comando);
                
    }

    public void Update(){
        //Caso a pessoa já atualizou pelos setters
        //Executa Update
    }

    public void Update(String id, String rotulo, String valor, String tipo){
        //Atualiza direto e depois salva
        this.tipo=tipo;
        this.rotulo=rotulo;
        this.valor=valor;
        //Executa Update
    }

    public void Delete(int id){
        this.id=null;
        this.tipo=null;
        this.rotulo=null;
        this.valor=null;
        //Executa Delete
    }

    public static ArrayList<TelefoneEmail> Index(){// Pode ter algum filtro aqui
        ArrayList<TelefoneEmail> list = new ArrayList<TelefoneEmail>(); 
        //Executa Select
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
        //     TelefoneEmail item = new TelefoneEmail(id, rotulo, valor, tipo);
        //     list.add(item);
        // }
        return list;
    }

    public static TelefoneEmail Show(String id){
        //executa select
        TelefoneEmail res = new TelefoneEmail(); 
        return res;
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

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String valor) {
        this.tipo = valor;
    }

}