class OverloadedMethods
{
  /*
   * Primer: http://www.tutorialspoint.com/java/java_string_indexof.htm
   */ 
  public static void main(String[] args)
  {
    System.out.println("Unesi broj a: ");
    int a = Svetovid.in.readInt();
    System.out.println("Unesi broj b: ");
    int b = Svetovid.in.readInt();
    System.out.println(f(a, b));
    System.out.println(f(a));
  }
  
  private static int f(int x, int y)
  {
    return x + y;
  }
  
  private static int f(int x)
  {
    return -x;
  }
}