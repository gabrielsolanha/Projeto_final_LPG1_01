package src.utils;

public class Valiadator {
  private Valiadator() {
  }
    
  public static boolean isValidEmail (String email) {
    String pattern = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    return email.matches(pattern);
  }
  
  public static boolean isValidTelefone (String telefone) {
    return telefone.matches("[(]?[0-9]{2}[)]?[ ]?[0-9]{4,5}[ ,-]?[0-9]{4}");
  }
}
