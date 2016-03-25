class Zadatak3
{
  public static void main(String[] args)
  {
    String str1 = Svetovid.in.readLine();
    String str2 = Svetovid.in.readLine();
    System.out.println(compareStringLength(str1, str2));
  }
  
  private static String compareStringLength(String a, String b)
  {
    int length = (a.length()>b.length()) ? b.length() : a.length();
    int i;
    int lengthFirst = 0;
    int lengthSecond = 0;
    
    for(i=0; i<length; i++)
    {
      
      lengthFirst += (int)a.charAt(i);
      lengthSecond += (int)a.charAt(i);
    }
    
    if(lengthFirst == lengthSecond)
    {
      return "Stringovi su jendaki!";
    }
    if(lengthFirst > lengthSecond)
    {
      return "String \"" + a + "\"" + "je veci od \"" + b + "\""; 
    }
    else
    {
      return "String \"" + b + "\" "+ " je veci od \"" + a + "\"";
    }
    
  }
}