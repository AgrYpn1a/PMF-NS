/*
 * Napisati program koji ucitava kvadrantu matricu NxN
 * i ispituje da li je matriica simetricna po glavnoj i
 * sporednoj dijagonali
 */ 
class Zadatak1
{
  public static void main(String[] args)
  {
    int n;
    do
    {
      System.out.println("Unesi velicinu matrice: ");
      n = Svetovid.in.readInt();
    }while(n > 20 || n < 2);
    int[][] matrix = scanSquareMatrix(n);
    
    if(matrixMainDiagonalSimetry(matrix))
    {
      System.out.println("Matrica je simetricna po glavnoj dijagonali!");
    }
    else
    {
      System.out.println("Matrica nije simetricna po glavnoj dijagonali!");
    }
    
    if(matrixSideDiagonalSimetry(matrix))
    {
      System.out.println("Matrica je simetricna po sporednoj dijagonali!");
    }
    else
    {
      System.out.println("Matrica nije simetricna po sporednoj dijagonali!");
    }
  }
  
  private static int[][] scanSquareMatrix(int length)
  {
    int[][] temp = new int[length][length];
    for(int i=0; i<length; i++)
    {
      for(int j=0; j<length; j++)
      {
        System.out.print("[" + i + "][" + j + "]=");
        temp[i][j] = Svetovid.in.readInt();
      }
    }
    return temp;
  }
  
  private static boolean matrixMainDiagonalSimetry(int[][] m)
  {
    int length = m.length;
    // check main diagonal simetry
    for(int i=0; i<length-1; i++)
    {
      for(int j=i+1; j<length; j++)
      {
        if(m[i][j] != m[j][i])
        {
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean matrixSideDiagonalSimetry(int[][] m)
  {
    int length = m.length;
    // check side diagonal simetry
    for(int i=0; i<length-1; i++)
    {
      for(int j=0; j<length-i-1; j++)
      {
        if(m[i][j] != m[length-1-j][length-1-i])
        {
          return false;
        }
      }
    }
    return true;
  }
}