package src.listatelefonica;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import src.classes.Contato;
import src.classes.TelefoneEmail;

public class ListaTelefonica {
  public static void main(String args[]) {
    //interage por aqui
    int x, year,month,day;
    Scanner t = new Scanner(System.in);
    String teloumail, rotulo,valor,uuid,nome,sobrenome, contatoId;
    Date dataNascimento;
    Contato contato;
    ArrayList<TelefoneEmail> telefoneEmails;
    ArrayList<Contato> contatos = new ArrayList<Contato>();
    do{
      mostraMenu();
      x = t.nextInt();
      if(x!=0){
        switch(x){
        case 1:
        telefoneEmails = adicionaListadeTelMail();
          break;
        case 2:
          adicionaContato();
          break;
        case 3:
          imprimeTudo();
          break;
        case 4:
          atulizaContato();
          break;
        case 5:
          deleteContato();
          break;
        default:
          System.out.println ("O valor eh invalido");
          break;
          }
      }
    }while(x!=0);
  }
  //////////////////////////////Fim da main///////////////////////////////////////
  private static void mostraMenu(){
    System.out.println("0-para sair 1-para adicionar uma lista de Telefones ou e-mails do contato");
    System.out.println("2-para adicionar um contato 3-para imprimir todos os contatos e suas informações");
    System.out.println("4-para auterar um contato 5-para remover um contato");
  }
  private static ArrayList<TelefoneEmail> adicionaListadeTelMail(){
    Tipo tipo;
    int y;
    String teloumail, rotulo,valor,uuid,nome,sobrenome, contatoId;
    TelefoneEmail telemail;
    ArrayList<TelefoneEmail> telefoneEmails;
    
    telefoneEmails = new ArrayList<TelefoneEmail>();
    do{
      System.out.println("0-para sair 1-para adicionar mais a lista");
      y = t.nextInt();
      if(y!=0){
        System.out.println("Digite \"email\" se for add um e-mail ou \"telefone\" se for add um telefone");
        teloumail = t.nextLine();
        t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
        if(telemail.equals("email")){
          tipo = Tipo.EMAIL;
        }else{
          tipo = Tipo.TELEFONE;
        }
        System.out.println("Infome o rotulo desejado: (Ex: trabalho, casa, etc..)");
        rotulo = t.nextLine();
        t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
        System.out.println("Infome o valor desejado: (Ex:nome.sobenm@mail.com ou (99) 99999-9999)");
        valor = t.nextLine();
        t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL

        //aqui vem o gerador do uuid

        uuid="alguma coisa";
        contatoId = "alguma coisa";

        telemail = new TelefoneEmail(uuid, rotulo, valor, tipo,contatoId);
        telefoneEmails.add(telemail);
      }
    }while(y!=0);
    return telefoneEmails;
  }
  private static void adicionaContato() {
    
    System.out.println("Digite o nome do contato:");
    nome = t.nextLine();
    t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o sobrenome");
    sobrenome = t.nextLine();
    t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o valor do ano de nascimento do contato:");
    year = t.nextInt();
    System.out.println("Infome o valor do mês de nascimento do contato:");
    month = t.nextInt();
    System.out.println("Infome o valor do dia de nascimento do contato:");
    day = t.nextInt();
    dataNascimento = new Date(year, month, day);

    //aqui vem o gerador do uuid
    uuid="alguma coisa";


    contato = new Contato(uuid, nome, sobrenome, dataNascimento, telefoneEmails);
    contatos.add(contato);
  }
  public static void imprimeTudo() {
    for (Contato contato2 : contatos) {
      contato2.imprimeDados();
      //imprime tudo
    }
  }
  public static void atulizaContato() {
    System.out.println("Digite o UUID do contato a ser auterado");
    uuid = t.nextLine();
    t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Digite o novo nome do contato:");
    nome = t.nextLine();
    t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o novo sobrenome");
    sobrenome = t.nextLine();
    System.out.println("Infome o valor do ano de nascimento do contato:");
    year = t.nextInt();
    System.out.println("Infome o valor do mês de nascimento do contato:");
    month = t.nextInt();
    System.out.println("Infome o valor do dia de nascimento do contato:");
    day = t.nextInt();
    dataNascimento = new Date(year, month, day);
    for (Contato contato2 : contatos) {
      if(contato2.getId().equals(uuid)){
        this.contatos.update(nome, sobrenome, dataNascimento);
      }
    }
  }
  public static void deleteContato() {
    System.out.println("Digite o UUID do contato a ser deletado");
    uuid = t.nextLine();
    t.nextLine();//deve-se adicionar sempre esse comando antes para consumir o NL
    for (Contato contato2 : contatos) {
      if(contato2.getId().equals(uuid)){
        this.contatos.delete();
      }
    }
  }
}
