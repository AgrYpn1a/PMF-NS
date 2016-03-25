/*
 * Za unetu matricu celih brojeva formata N x N, ispitati da li je
 * heterogena ili poluhomogena.
 * Matrica je poluhomogena ukoliko su joj svi elementi na glavnoj
 * dijagonali jednaki nekom broju A, a svi elementi van glavne
 * dijagonale jednaki nekom broju B, i pri tome A != B
 * 
 * Ako je A = B matrica je homogena, tj svi elementi su jednaki
 * 
 * Matrica je heterogena ako nije ni homogena ni poluhomomgena.
 * 
 * Matrica koja sadrzi tacno jedan element je homogena
 * 
 */ 
class Zadatak1
{
  public static void main(String[] args) 
  {
    String output = "";
    
    System.out.println("Unesi velicinu matrice (nemoj preterivati, nije kul):");
    int n = Svetovid.in.readInt();
    int[][] matrix = new int[n][n];
    matrix = scanMatrix(n);
    System.out.println("Unesi A: ");
    int a = Svetovid.in.readInt();
    System.out.println("Unesi B: ");
    int b = Svetovid.in.readInt();
    
    if(n == 1)
    {
      output = " je homogena.";
    }
    else if(a == b)
    {
      // ako je a == b onda proveravamo
      // da li je matrica homogena
      if(checkHomoMatrix(matrix, a))
      {
        output = " je homogena.";
      }
    }
    else if(checkHalfHomoMatrix(matrix, a, b))
    {
      // ako nije homogena, tada je verovatno polu-homogena
      output = " je polu-homogena.";
    }
    else
    {
      // na kraju ako nije ni jedna od prethodnih
      // onda je heterogena
      output = " je heterogena.";
    }
    
    System.out.println("Uneta matrica " + output);
  }
  
  private static int[][] scanMatrix(int n)
  {
    int[][] tempMatrix = new int[n][n];
    for(int i=0; i<n; i++)
    {
      for(int j=0; j<n; j++)
      {
        tempMatrix[i][j] = Svetovid.in.readInt();
      }
    }
    return tempMatrix;
  }
  
  private static boolean checkHomoMatrix(int[][] m, int n)
  {
    int length = m.length;
    for(int i=0; i<length; i++)
    {
      for(int j=0; j<length; j++)
      {
        if(m[i][j] != n)
        {
          // ako naidjemo na makar jedan koji nije jednak A ili B, tj n
          // jer su A i B jednaki u ovom slucaju, matrica nije homogena
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean checkHalfHomoMatrix(int[][] m, int a, int b)
  {
    int length = m.length;
    
    for(int i=0; i<length; i++)
    {
      for(int j=0; j<length; j++)
      {
        // glavna dijagonala
        if(i == j)
        {
          if(m[i][j] != a)
          {
            // ako nadjemo makar jedan koji je razlicit od prvog
            // matrica nije polu-homogena
            return false;
          }
        }
        // sve ostalo
        else
        {
          if(m[i][j] != b)
          {
            // isto kao u prethodnom slucaju
            return false;
          }
        }
      }
    }
    // ako nismo nasli niti jedan element koji je nejednak A ili nejednak B 
    // po uslovu zadatka, matrica je poluhomogena
    return true;
  }  
}
