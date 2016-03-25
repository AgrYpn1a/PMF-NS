/*
 * Unosi se broj, da li je broj prost?
*/
class Zad2
{
  public static void main(String[] args)
  {
    int n;
    String resenje;
    
    Svetovid.out.println("Unesi broj: ");
    n = Svetovid.in.readInt();
    
    resenje = prost(n) ? " je prost" : " nije prost";
    Svetovid.out.println("Broj " + n + resenje);
  }
  
  private static boolean prost(int broj)
  {
    int brojac = 1;
    while (brojac < Math.sqrt(broj))
    {
      brojac++;
      if (broj % brojac == 0)
        return false;
    }
    return true;
  }
}