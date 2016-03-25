class Zadatak1
{
  public static void main(String[] args)
  {
    String str1 = Svetovid.in.readLine();
    String str2 = Svetovid.in.readLine();
    
    String output = proveriStringove(str1, str2) ? 
      "Stringovi su jednaki" : "Stringovi nisu jednaki";
    System.out.println(output);
  }
  
  private static boolean proveriStringove(String a, String b)
  {
    if(a.length() != b.length())
    {
      return false;
    }
    for(int i=0; i<a.length(); i++)
    {
      char _a = lowerChar(a.charAt(i));
      char _b = lowerChar(b.charAt(i));
      
      if(_a != _b)
      {
        return false;
      }
    }
    return true;
  }
  
  private static char lowerChar(char c)
  {
    if(c >= 'A' && c <= 'Z')
    {
      return (char)(c+'a'-'A');
    }
    return c;
  }
}