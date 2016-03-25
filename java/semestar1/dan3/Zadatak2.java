class Zadatak2
{
  public static void main(String[] args)
  {
    int a = Svetovid.in.readInt();
    System.out.println("Suma brojeva od 1 do N, gde je N=" + nadjiNajveci(a) + " je manja od unetog broja " + a);
  }
  
  private static int nadjiNajveci(int a)
  {
    int _sumaDoN = 0;
    int n = 0;
    do
    {
      n++;
      _sumaDoN += n;
      
    }while(_sumaDoN < a);
    return n-1;
  }
}