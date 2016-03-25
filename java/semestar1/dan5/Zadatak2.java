class Zadatak2
{
  public static void main(String[] args)
  {
    String str1 = Svetovid.in.readLine();
    String str2 = Svetovid.in.readLine();
    
    System.out.println("String " + str1 +
                       " se u Stringu " + str2 + " ponavlja " +
                       stringInString(str1, str2) + " puta.");
  }
  
  private static int stringInString(String a, String b)
  {
    int currentSubStrId = 0;
    int subStrInStr = 0;
    
    while(b.indexOf(a, currentSubStrId) != -1)
    {
      currentSubStrId += a.length();
      subStrInStr++;
    }
    return subStrInStr;
  }
}