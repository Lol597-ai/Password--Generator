import java.util.Scanner;
import javax.crypto.SecretKey;

public class Main {
    public static void main(String [] args) {

        menu();

    try {
        // Generiere ein Passwort
        String password = PasswordGenerator.generatePassword(length, useUpperCase, useLowerCase, useDigits, useSymbols);
        System.out.println("Generiertes Passwort: " + "    " + password);

        // Erzeuge einen AES-Schlüssel
        SecretKey key = PasswordEncryption.generateKey();

        // Verschlüssle das Passwort
        String encryptedPassword = PasswordEncryption.encrypt(password, key);
        System.out.println("Verschlüsseltes Passwort: " + encryptedPassword);

        // Entschlüssle das Passwort
        String decryptedPassword = PasswordEncryption.decrypt(encryptedPassword, key);
        System.out.println("Entschlüsseltes Passwort: " + decryptedPassword);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
   // Globale Variablen für Benutzereingaben
   static int length = 0;
   static boolean useUpperCase = false;
   static boolean useLowerCase = false;
   static boolean useDigits = false;
   static boolean useSymbols = false;

public static void menu() 
{
    Scanner s = new Scanner(System.in);
    // Passwortlänge abfragen
    System.out.println("Wie groß soll ihr Passwort sein? (8-24): ");
    length = s.nextInt();
    if(length > 24) 
    {
        System.out.println(("Die Zeichenkette darf nicht über 24 sein! "));

        System.out.println("Wie groß soll ihr Passwort sein? (8-24): ");
        length = s.nextInt();
    }

    // Großbuchstaben abfragen
    System.out.println("Möchten Sie Großbuchstaben verwenden? (j/n): ");
    useUpperCase = s.next().equalsIgnoreCase("j");

    // Kleinbuchstaben abfragen
    System.out.println("Möchten Sie Kleinbuchstaben verwenden? (j/n): ");
    useLowerCase = s.next().equalsIgnoreCase("j");

    // Zahlen abfragen
    System.out.println("Möchten Sie Zahlen verwenden? (j/n): ");
    useDigits = s.next().equalsIgnoreCase("j");

    // Sonderzeichen abfragen
    System.out.println("Möchten Sie Sonderzeichen verwenden? (j/n): ");
    useSymbols = s.next().equalsIgnoreCase("j");
    
    s.close();

}   
}