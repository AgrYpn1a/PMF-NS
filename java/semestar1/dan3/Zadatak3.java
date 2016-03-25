class Zadatak3
{
  public static void main(String[] args)
  {
    System.out.println("Unesi osnovu izmedju 2 i 10");
    int b = Svetovid.in.readInt();
    System.out.println("Unesi broj: ");
    int n = Svetovid.in.readInt();
    //Svetovid.out.println("log je: " + Math.log10(n)+1);
    Svetovid.out.println("Za unetu osnovu " + b + " uneti broj " + n + " zapisan u dekadnom brojnom sistemu je: " + prebaciNaDekadni(b, n));
  }
  
  private static int prebaciNaDekadni(int osnova, int broj)
  {
    int _brDekadni = 0;
    int limit = (int)Math.log10(broj) + 1;
    
    for(int i=0; i<=limit; i++)
    {
      _brDekadni += (int)(broj%10) * (int)Math.pow(osnova, i);
      broj /= 10;
    }
    return _brDekadni;
  }
}