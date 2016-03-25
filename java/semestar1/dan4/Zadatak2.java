class Zadatak2
{
  public static void main(String[] args)
  {
    String str1 = Svetovid.in.readLine();
    String str2 = Svetovid.in.readLine();
    String output = compareStrings(str1, str2) ? "Uneti stringovi su jednaki!" : "Uneti stringovi nisu jednaki";
    System.out.println(output);
  }
  
  private static boolean compareStrings(String a, String b)
  {
    int length = (a.length()>b.length()) ? b.length() : a.length();
    int i = 0;
    for(i=0; i<length; i++)
    {
      char c = a.charAt(i);
      
      if(c >= 'A' && c<= 'Z')
      {
        c += (char)('a' - 'A');
      }
      
      if(c != b.charAt(i) && c != (char)(b.charAt(i) + 'a' - 'A'))
      {
        return false;
      }
    }
    if(a.length() == i && b.length() == i)
    {
          return true;
    }
    else
    {
      return false;
    }
  }
}