package src.listatelefonica;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import src.classes.Contato;
import src.classes.TelefoneEmail;
import src.classes.TelefoneEmail.Tipo;

public class ListaTelefonica {
  //INTERFACE DO USUÁRIO VIA TERMINAL
  public static void main(String args[]) {
    int x;
    Scanner t = new Scanner(System.in);
    ArrayList<Contato> contatos = new ArrayList<Contato>();

    //MENU GERAL
    do {
      mostraMenu();
      x = t.nextInt();
      if (x != 0) {
        //CASOS DE INTERAÇÃO
        switch (x) {
          case 1:
            contatos.add(adicionaContato());
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
  //end main
  
  //Funções para interações:
  private static void mostraMenu() {
    System.out.println("Escolha uma das opcoes abaixo:");
    System.out.println("");
    System.out.println("0-para sair");
    System.out.println("1-para adicionar um contato");
    System.out.println("3-para imprimir todos os contatos e suas informações");
    System.out.println("4-para auterar um contato 5-para remover um contato");
    System.out.println("6-para auterar um e-mail/telefone 7-para remover um e-mail/telefone");
  }

  //INTERAÇÕES COM TELEFONE OU EMAIL
  
  //Adicionar
  private static void adicionaListadeTelMail(Contato contato) {
    Scanner t = new Scanner(System.in);
    Tipo tipo;
    int y;
    String teloumail, rotulo, valor;
    
    do {
      System.out.println("0-para sair 1-para adicionar mais a lista");
      y = t.nextInt();
      if (y != 0) {// valida 
        System.out.println("Digite \"email\" se for add um e-mail ou \"telefone\" se for add um telefone");
        teloumail = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL

        tipo = teloumail.equals("email") ? Tipo.EMAIL : Tipo.TELEFONE;

        System.out.println("Infome o rotulo desejado: (Ex: trabalho, casa, etc..)");
        rotulo = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
        System.out.println("Infome o valor desejado: (Ex:nome.sobenm@mail.com ou (99) 99999-9999)");
        valor = t.nextLine();
        t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL

        contato.createTelefoneEmail(rotulo, valor, tipo);
      }
    } while (y != 0);
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

  }
  
  //FIM DAS INTERAÇÕES COM TELEFONE OU EMAIL

  //INTERAÇÕES COM O CONTATO
  
  //Pegar dados somente do contato
  private static Contato inputContato() {
    Scanner t = new Scanner(System.in);
    int year, month, day;
    String nome, sobrenome;
    Date dataNascimento;
    ArrayList<TelefoneEmail> telefoneEmails;
    telefoneEmails = new ArrayList<TelefoneEmail>();

    System.out.println("Digite o nome do contato:");
    nome = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome o sobrenome");
    sobrenome = t.nextLine();
    t.nextLine();// deve-se adicionar sempre esse comando antes para consumir o NL
    System.out.println("Infome a data de nascimento:");
    
    System.out.print("Dia:");
    day = t.nextInt();

    System.out.print("\nMes:");
    month = t.nextInt();
    
    System.out.print("\nAno:");
    year = t.nextInt();

    dataNascimento = new Date(year, month, day);

    t.close();
    return new Contato(nome, sobrenome, dataNascimento, telefoneEmails);
  }

  //Adiciona um contato completo
  private static Contato adicionaContato() {
    Contato contato = inputContato();
    contato.create();
    adicionaListadeTelMail(contato);
    return contato;
  }

  public static void imprimeTudo(ArrayList<Contato> contatos) {
    for (Contato contato : contatos) {
      System.out.println("Contato com id: "+contato.getId());
      System.out.println("Nome completo: "+contato.getNome()+" "+contato.getSobrenome());
      Date currentDataNasc = contato.getDataNascimento(); 
      System.out.println("Data de nascimento:"+currentDataNasc.getDate()+"/"+currentDataNasc.getMonth()+"/"+currentDataNasc.getYear());
      System.out.println("Contatos:");
      System.out.println("\tTipo\tRotulo\tValor");

      contato.getTelefoneEmails().forEach(item -> {
        System.out.println("\t"+item.getTipo().name()+"\t"+item.getRotulo()+"\t"+item.getValor());
      });
    }
  }

  public static void atulizaContato(ArrayList<Contato> contatos) {
    Scanner t = new Scanner(System.in);
    String id;

    System.out.println("Digite o id do contato a ser auterado");
    id = t.nextLine();

    Contato newContato = inputContato();

    Contato contatoToUpdate = contatos.stream()
    .filter(contato -> id.equals(contato.getId()))
    .findFirst()
    .orElse(null);

    if (contatoToUpdate != null) {
      try {
        contatoToUpdate.update(newContato.getNome(), newContato.getSobrenome(), newContato.getDataNascimento());// atuliza do banco
      } catch (Exception error) {
        System.err.println(error);
      }
    } else {
      System.err.println("Contato inválido invalido!");
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

  }
}
