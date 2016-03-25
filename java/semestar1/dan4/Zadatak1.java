class Zadatak1
{
  public static void main(String[] args)
  {
    int n = Svetovid.in.readInt();
    int[] niz = new int[n];
    int suma = 0;
    
    for(int i=0; i<n; i++)
    {
      System.out.println("Unesi element: ");
      niz[i] = Svetovid.in.readInt();
      suma += niz[i];
    }
    float prosek = (float)suma / (float)n;
    System.out.println("Aritmeticka sredina unetih brojeva je: " + prosek);
  }
}