package src.listatelefonica;
import java.util.Scanner;

public class ListaTelefonica {
  public static void main(String args[]) {
    //interage por aqui
    int x;
    Scanner t = new Scanner(System.in);
    do{
      System.out.println("0-para sair 1-para ...");
      System.out.println("2-para ... 3-para ...");
      System.out.println("4-para ... 5-para ...");
      System.out.println("6-para ...");
      x = t.nextInt();
      if(x!=0){
        switch(x){
        case 1:
          
          break;
        case 2:
          
          break;
        case 3:
        default:
          System.out.println ("O valor eh invalido");
          break;
          }
      }
    }while(x!=0);
  }
}
