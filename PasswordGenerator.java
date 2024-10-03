import java.security.SecureRandom;
public class PasswordGenerator
 
{
    private final static String UpperCase  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String LowerCase  = "abcdefghijklmnopqrstuvwxyz";
    private final static String Digits     = "1234567890";
    private final static String Symbols    = "!@#$%^&*()-_=+<>?";

   private static final SecureRandom random = new SecureRandom();


public static String generatePassword(int length, boolean useUpperCase, boolean useLowerCase, boolean useDigits, boolean useSymbols) 
   {
    String charPool = "";
    if(useUpperCase)  charPool += UpperCase;
    if(useLowerCase) charPool += LowerCase;
    if(useDigits) charPool += Digits;
    if(useSymbols) charPool += Symbols;

    if(charPool.isEmpty()) 
    {
        throw new IllegalArgumentException("Es müssen mindestens eine Zeichengruppe ausgewählt werden.");
    }
    StringBuilder password = new StringBuilder(length);
    for(int i = 0; i < length; i++)
    {
        int index = random.nextInt(charPool.length());
        password.append(charPool.charAt(index));
    }
    return password.toString();

   }

}
