class Fibonacci
{
  public static void main(String[] args)
  {
    int n = Svetovid.in.readInt("n=");
    System.out.println("Fibbonaci1(" + n + "): " + fibb4(n));
  }

  private static int fibb1(int n)
  {
    if(n >= 0)
     return _fibb1(n);
    else
     return -1; 
  }

  private static int _fibb1(int n)
  {
    if(n <= 1)
      return n;
    else
      return _fibb1(n-1) + _fibb1(n-2);
  }

  private static int fibb3(int n)
  {
    if(n >= 0)
      return _fibb3(1, 0, n);
    else
      return -1;
  }

  private static int _fibb3(int b, int a, int n)
  {
    if(n == 0)
      return a;
    else
      return _fibb3(b+a, b, n-1);
  }

  private static int fibb4(int n)
  {
    if(n >= 0)
    {
      int p1 = 0, p2 = 1, g1 = 1, g2 = 2, temp;
      boolean choice = (n%2 == 1);
      n /= 2;
      while(n > 0)
      {
        if(n%2 == 1) // P = P * G
        {
          temp = p1*g1;
          p1 = p1*g2 + p2*g1 - temp;
          p2 = p2*g2 + temp;
        }
        n /= 2;
        if(n > 0) // G = G * G
        {
          temp = g1*g2;
          g1 = 2*g1*g2 - temp;
          g2 = g2*g2 + temp;
        }
      }
      if(choice) return p2; else return p1;
    }
    return -1;
  }
}
