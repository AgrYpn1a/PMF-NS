/*
 * Napisati program koji ucitava dva niza A i B,
 * i ispisuje sve parove (x,y) x iz A, y iz B
 * takve da je x deljivo sa y.
 */ 
class Zadatak2
{
  public static void main(String[] args)
  {
    System.out.println("Unesi duzinu prvog niza: ");
    int k = Svetovid.in.readInt();
    
    System.out.println("Unesi duzinu drugog niza: ");
    int m = Svetovid.in.readInt();
    
    int[] a = new int[k];
    int[] b = new int[m];
    
    a = scanArray(k);
    b = scanArray(m);
    
    for(int i=0; i<k; i++)
    {
      for(int j=0; j<m; j++)
      {
        if(a[i] % b[j] == 0)
        {
          System.out.println("(" + a[i] + ", " + b[j] + "),");
        }
      }
    }
  }
  
  private static int[] scanArray(int length)
  {
    int[] temp = new int[length];
    for(int i=0; i<length; i++)
    {
      temp[i] = Svetovid.in.readInt();
    }
    return temp;
  }
}