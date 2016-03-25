/*
 * zadatak3
 * 
 * Unosi se suma, otpimalna isplata sume
 */
class Zad3
{
  public static void main(String[] args)
  {
    int suma;
    int[] novcanice = {100, 50, 20, 10, 5, 2, 1};
    
    Svetovid.out.println("Uesi sumu novca: ");
    suma = Svetovid.in.readInt();
   
    for(int novcanica : novcanice)
    {
      Svetovid.out.println("Novcanice od " + novcanica + " : " + suma / novcanica);
      suma %= novcanica;
    }
  }
}