class Zadatak1
{
  public static void main(String[] args)
  {
    int n = Svetovid.in.readInt();
    System.out.println("zbir cifara broja " + n + " je " + zbirCifara(n));
  }
   
  private static int zbirCifara(int broj)
  {
    int _zbirCif = 0;
    while(broj != 0)
    {
      _zbirCif += broj % 10;
      broj /= 10;
    }
    return _zbirCif;
  }
}