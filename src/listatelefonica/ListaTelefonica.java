package src.listatelefonica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import src.classes.Contato;
import src.classes.TelefoneEmail;
import src.classes.TelefoneEmail.Tipo;

public class ListaTelefonica {
  public static void main(String args[]) {//////////////////////////////////////////////ERRO1
    // interage por aqui
    int x;
    Scanner t = new Scanner(System.in);
    ArrayList<TelefoneEmail> telefoneEmails;
    ArrayList<Contato> contatos = new ArrayList<Contato>();
    do {
      mostraMenu();
      x = t.nextInt();
      if (x != 0) {
        switch (x) {
          case 1:
            contatos.add(adicionaContato());
            break;
          case 2:
            telefoneEmails = adicionaListadeTelMail();
            // adicionar aqui a lista ao contato
            break;
          case 3:
            imprimeTudo(contatos);
            break;
          case 4:
            atulizaContato(contatos);
            break;
          case 5:
            deleteContato(contatos);
            break;
          case 6:
            System.out.println("Digite o id do contato do telefone/e-mail a ser alterado");
            String id = t.nextLine();
            t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
        
            Contato contatou = contatos.stream()
                .filter(contato -> id.equals(contato.getId()))
                .findFirst()
                .orElse(null);
        
            if (contatou != null) {
              try {
                atulizaTelefoneEmail((contatou.getTelefoneEmails()));
              } catch (Exception error) {
                System.err.println(error);
              }
            } else {
              System.err.println("Contato inválido invalido!!");
            }
            break;
          case 7:
            System.out.println("Digite o id do contato do telefone/e-mail a ser deletado");
            id = t.nextLine();
            t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
        
            Contato contatar = contatos.stream()
                .filter(contato -> id.equals(contato.getId()))
                .findFirst()
                .orElse(null);
        
            if (contatar != null) {
              try {
                deleteTelefoneEmail(contatar.getTelefoneEmails());
              } catch (Exception error) {
                System.err.println(error);
              }
            } else {
              System.err.println("Contato inválido invalido!");
            }
            break;
          default:
            System.out.println("O valor eh invalido");
            break;
        }
      }
    } while (x != 0);
  }

  ////////////////////////////// Fim da
  ////////////////////////////// main///////////////////////////////////////
  private static void mostraMenu() {
    System.out.println("0-para sair 1-para adicionar um contato");
    System.out.println("2-para adicionar uma lista de Telefones ou e-mails do contato");
    System.out.println(" 3-para imprimir todos os contatos e suas informações");
    System.out.println("4-para auterar um contato 5-para remover um contato");
    System.out.println("6-para auterar um e-mail/telefone 7-para remover um e-mail/telefone");
  }

  private static ArrayList<TelefoneEmail> adicionaListadeTelMail() {
    Scanner t = new Scanner(System.in);
    Tipo tipo;
    int y;
    String teloumail, rotulo, valor, id, nome, sobrenome, contatoId;
    TelefoneEmail telemail;
    ArrayList<TelefoneEmail> telefoneEmails;

    telefoneEmails = new ArrayList<TelefoneEmail>();
    do {
      System.out.println("0-para sair 1-para adicionar mais a lista");
      y = t.nextInt();
      if (y != 0) {
        System.out.println("Digite \"email\" se for add um e-mail ou \"telefone\" se for add um telefone");
        teloumail = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
        if (teloumail.equals("email")) {
          tipo = Tipo.EMAIL;
        } else {
          tipo = Tipo.TELEFONE;
        }
        System.out.println("Infome o rotulo desejado: (Ex: trabalho, casa, etc..)");
        rotulo = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
        System.out.println("Infome o valor desejado: (Ex:nome.sobenm@mail.com ou (99) 99999-9999)");
        valor = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL

        // aqui vem o gerador do id

        id = "algumas coisas";
        contatoId = "alguma coisa";

        telemail = new TelefoneEmail(id, rotulo, valor, tipo, contatoId);
        telefoneEmails.add(telemail);
      }
    } while (y != 0);
    return telefoneEmails;
  }

  private static Contato adicionaContato() {
    Scanner t = new Scanner(System.in);
    int year, month, day;
    String nome, sobrenome, id;
    Date dataNascimento;
    Contato contato;
    ArrayList<TelefoneEmail> telefoneEmails;
    telefoneEmails = new ArrayList<TelefoneEmail>();

    System.out.println("Digite o nome do contato:");
    nome = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o sobrenome");
    sobrenome = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o valor do ano de nascimento do contato:");
    year = t.nextInt();
    System.out.println("Infome o valor do mês de nascimento do contato:");
    month = t.nextInt();
    System.out.println("Infome o valor do dia de nascimento do contato:");
    day = t.nextInt();
    dataNascimento = new Date(year, month, day);

    // aqui vem o gerador do id
    id = "alguma coisa";

    contato = new Contato(id, nome, sobrenome, dataNascimento, telefoneEmails);

    t.close();
    return contato;
  }

  public static void imprimeTudo(ArrayList<Contato> contatos) {
    for (Contato contato : contatos) {
      contato.imprimeDados();//////////////////////////////////////////////ERRO4
      // imprime tudo
    }
  }

  public static void atulizaContato(ArrayList<Contato> contatos) {
    Scanner t = new Scanner(System.in);
    int year, month, day;
    String nome, sobrenome, id;
    Date dataNascimento;

    System.out.println("Digite o id do contato a ser auterado");
    id = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Digite o novo nome do contato:");
    nome = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o novo sobrenome");
    sobrenome = t.nextLine();
    System.out.println("Infome o valor do ano de nascimento do contato:");
    year = t.nextInt();
    System.out.println("Infome o valor do mês de nascimento do contato:");
    month = t.nextInt();
    System.out.println("Infome o valor do dia de nascimento do contato:");
    day = t.nextInt();
    dataNascimento = new Date(year, month, day);

    Contato contatoToUpdate = contatos.stream()
    .filter(contato -> id.equals(contato.getId()))
    .findFirst()
    .orElse(null);

    if (contatoToUpdate != null) {
      try {
        contatoToUpdate.update(nome, sobrenome, dataNascimento);// atuliza do banco
      } catch (Exception error) {
        System.err.println(error);
      }
    } else {
      System.err.println("Contato inválido invalido!!!!");
    }

    t.close();
  }

  public static void deleteContato(ArrayList<Contato> contatos) {
    Scanner t = new Scanner(System.in);
    String id;
    System.out.println("Digite o id do contato a ser deletado");
    id = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL

    Contato contatoToDelete = contatos.stream()
        .filter(contato -> id.equals(contato.getId()))
        .findFirst()
        .orElse(null);

    if (contatoToDelete != null) {
      try {
        contatoToDelete.delete();// Delete do banco
        contatos.remove(contatoToDelete);// Delete da lista
      } catch (Exception error) {
        System.err.println(error);
      }
    } else {
      System.err.println("Contato inválido invalido!!!!!");
    }

    t.close();
  }

//atualiza telefone ou e-mail

  public static void atulizaTelefoneEmail(ArrayList<TelefoneEmail> telefoneEmails) {
    Scanner t = new Scanner(System.in);
    String rotulo,valor,teloumail,id;
    Tipo tipo;

    System.out.println("Digite o id do telefone ou e-mail a ser auterado");
    id = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Digite o novo rotulo do telefone ou e-mail :");
    rotulo = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o novo valor");
    valor = t.nextLine();
    System.out.println("Infome o novo tipo do telefone ou e-mail :");
    teloumail = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    if (teloumail.equals("email")) {
      tipo = Tipo.EMAIL;
    } else {
      tipo = Tipo.TELEFONE;
    }

    TelefoneEmail telmailToUpdate = telefoneEmails.stream()
        .filter(telmail -> id.equals(telmail.getId()))
        .findFirst()
        .orElse(null);

    if (telmailToUpdate != null) {
      try {
        telmailToUpdate.update(rotulo, valor, tipo);;// atualiza do banco
      } catch (Exception error) {
        System.err.println(error);
      }
    } else {
      System.err.println("Contato inválido invalido");
    }

    t.close();
  }

  //deleta telefone ou e-mail

  public static void deleteTelefoneEmail(ArrayList<TelefoneEmail> telefoneEmails) {
    Scanner t = new Scanner(System.in);
    String  id;

    System.out.println("Digite o id do telefone ou e-mail a ser deletado");
    id = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL

    TelefoneEmail telmailToDelete = telefoneEmails.stream()
        .filter(telmail -> id.equals(telmail.getId()))
        .findFirst()
        .orElse(null);

    if (telmailToDelete != null) {
      try {
        telmailToDelete.delete();// Delete do banco
        telefoneEmails.remove(telmailToDelete);// Delete da lista
      } catch (Exception error) {
        System.err.println(error);
      }
    } else {
      System.err.println("Contato inválido invalido");
    }

    t.close();
  }
}
