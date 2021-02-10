package src.classes;

import java.sql.Date;
import java.util.ArrayList;
import src.utils.Valiadator;
import src.classes.TelefoneEmail.Tipo;

public class Contato {
    private String id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private ArrayList<TelefoneEmail> telefoneEmails;

    public Contato() {
    }

    public Contato(String id, String nome, String sobrenome, Date dataNascimento,
            ArrayList<TelefoneEmail> telefoneEmails) {
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
        // String id = result.getString("id");
        // String rotulo = result.getString("rotulo");
        // String tipo = result.getString("tipo");
        // String valor = result.getString("valor");
        // list.add(new TelefoneEmail(id, rotulo, valor, tipo));
        // }
        System.err.println("Listou Contatos");
        return list;
    }

    public static Contato findById(String id) {
        // executa select
        System.err.println("Mostrou Contato com id: " + id);
        return new Contato();
    }

    public void create(String nome, String sobrenome, Date dataNascimento, ArrayList<TelefoneEmail> telefoneEmails) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefoneEmails = telefoneEmails;

        // Executa Insert
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

    public void update(String nome, String sobrenome, Date dataNascimento) {
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

    public boolean validar() {
        boolean isValid = true;

        for (TelefoneEmail telefoneEmail : telefoneEmails) {
            String valor = telefoneEmail.getValor();
            if (telefoneEmail.getTipo() == Tipo.EMAIL) {
                isValid = isValid && Valiadator.isValidEmail(valor);
            } else {
                isValid = isValid && Valiadator.isValidTelefone(valor);
            }
            if (!isValid)
                System.err.println("TelefoneEmail com valor " + valor + " invalido.");
        }
        return isValid;
    }

    public void createTelefoneEmail(String rotulo, String valor, Tipo tipo) {
        TelefoneEmail newItem = new TelefoneEmail();
        if (this.id != null) {
            newItem.create(rotulo, valor, tipo, this.id);
            this.telefoneEmails.add(newItem);
        } else {
            System.err.println("Voce precisa criar o contato para executar essa acao!");
        }
    }
    
    public void updateTelefoneEmail(String telefoneEmailId, String rotulo, String valor, Tipo tipo) {
        TelefoneEmail itemToUpdate = this.telefoneEmails.stream()
            .filter(telefoneEmail -> telefoneEmailId.equals(telefoneEmail.getId()))
            .findFirst()
            .orElse(null);
        if (itemToUpdate != null) {
            itemToUpdate.update(rotulo, valor, tipo);
        } else {
            System.err.println("TelefoneEmail invalido");
        }
    }

    public void deleteTelefoneEmail(String telefoneEmailId) {
        TelefoneEmail itemToUpdate = this.telefoneEmails.stream()
            .filter(telefoneEmail -> telefoneEmailId.equals(telefoneEmail.getId()))
            .findFirst()
            .orElse(null);
        if (itemToUpdate != null) {
            itemToUpdate.delete();
            this.telefoneEmails.remove(itemToUpdate);
        } else {
            System.err.println("TelefoneEmail invalido");
        }
    }

    public String getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public ArrayList<TelefoneEmail> getTelefoneEmails() {
        return this.telefoneEmails;
    }
    public void imprimeDados(){
        System.out.println("Idcontato: "+this.id);
        System.out.println("Nome: "+this.nome);
        System.out.println("Sobrenome: "+this.sobrenome);
        for (TelefoneEmail telefoneEmail : telefoneEmails) {
            telefoneEmail.imprimeDados();
        }
    }
}
