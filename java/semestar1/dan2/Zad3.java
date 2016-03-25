
class Zad3
{
  static int[] prosteCifre = {1, 3, 5, 7};
  
  public static void main(String[] args)
  {
    int n;
    
    Svetovid.out.println("Unesi broj: ");
    n = Svetovid.in.readInt();
    
    Svetovid.out.println("Broj prostih cifara ucitanog broja je: " + brProstihCifara(n));
  }
  
  private static int brProstihCifara(int n)
  {
    int brProstih = 0;
    
    while(n != 0)
    {
      for(int cif : prosteCifre)
      {
        if (n % 10 == cif)
        {
          brProstih++;
          break;
        }
      }
      n /= 10;
    }
    return brProstih;
  }
}