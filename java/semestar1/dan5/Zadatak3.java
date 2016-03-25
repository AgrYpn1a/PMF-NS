class Zadatak3
{
  public static void main(String[] args)
  {
    System.out.println("Unesi velicinu matrice: ");
    int n = Svetovid.in.readInt();
    int[][] matrix = new int[n][n];
    System.out.println("Ucitaj matricu: ");
    
    
    for(int i=0; i<n; i++)
    {
      for(int j=0; j<n; j++)
      {
        System.out.println("Unesi element na poziciji " + i + "-" + j + " :");
        matrix[i][j] = Svetovid.in.readInt();
      }
    }
    
    int max = matrix[0][0];
    
    for(int i=0; i<n; i++)
    {
      for(int j=0; j<n; j++)
      {
        if(matrix[i][j] > max)
        {
          max = matrix[i][j];
        }
      }
    }
    
    System.out.println("Max je: " + max);
  }
}