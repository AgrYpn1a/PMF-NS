
class Zad1
{
  public static void main(String[] args)
  {
    int n;
    
    Svetovid.out.println("Unesi broj: ");
    n = Svetovid.in.readInt();
    nadjiDelioce(n, (int)(n/2), 0);
  }
  
  private static void nadjiDelioce(int broj, int limit, int brojac)
  {
    brojac++;
    if (brojac < limit+1)
    {
      if (broj % brojac == 0)
        Svetovid.out.println(brojac);
      nadjiDelioce(broj, limit, brojac);
    }
    else
      Svetovid.out.println(broj);
  }
}