/* 
 zadatak 2 
 Unosi se karakter, da li je slovo, broj ili znk 
*/

class Zad2
{
  public static void main(String[] args)
  {
    char c;
    
    Svetovid.out.println("Uesi karakter: ");
    c = Svetovid.in.readChar();
    
    if(c >= '0' && c <= '9')
    {
      Svetovid.out.println("Input je broj " + c);
    }
    else if ( (Character.toUpperCase(c) >= 'A' && Character.toUpperCase(c) <= 'Z') ) 
    {
      Svetovid.out.println("Input je slovo " + c);
    }
    else
    {
      Svetovid.out.println("Input je special character " + c);
    }
  }
  
}