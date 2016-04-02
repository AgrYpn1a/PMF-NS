class Recursion
{
  public int factorial(int n)
  {
    if(n == 1)
      return 1;

    return n*factorial(n-1);
  }
}

class Rekurzija
{
  public static void main(String[] args)
  {
    Recursion r = new Recursion();
    System.out.println(r.factorial(Svetovid.in.readInt("n=")));
  }
}
