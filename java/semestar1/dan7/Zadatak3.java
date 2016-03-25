class Zadatak3
{
    public static void main(String[] args)
    {
        int n = Svetovid.in.readInt();
        int r = Svetovid.in.readInt();

        System.out.println("Po def: " + fDef(n, r));
        System.out.println("Po akumulirajucem: " + fAkum(n, r));
    }

    // Rekurzivno po definiciji
    private static int fDef(int n, int r)
    {
        if(n < r)
            return 1;
        else
            return fDef(n-1, r) - gDef(n-2, r) + fDef(n-r, r) - gDef(n-r, r);

    }

    private static int gDef(int n, int r)
    {
        if(n < r)
            return 2;
        else
            return gDef(n-1, r) + fDef(n-2, r) - fDef(n-r, r) - gDef(n-r, r);
    }

    // Putem akumulirajuceg parametra
    private static int fAkum(int n, int r)
    {
        int f[] = new int[r + 1];
        int g[] = new int[r + 1];
        if(n < r)
            return 1;
        else
        {
            for(int j=0; j<r; j++)
            {
                f[j] = 1;
                g[j] = 2;
            }
            return fAkumHelper(f, g, r, n, r);
        }
    }

    private static int fAkumHelper(int[] f, int[] g, int i, int n, int r)
    {
        if(i > n)
            return f[r];
        else
        {
            f[r] = f[r-1] - g[r-2] + f[0] - g[0];
            g[r] = g[r-1] + f[r-2] - f[0] - g[0];
            for(int j=0; j<r; j++)
            {
                f[j] = f[j+1];
                g[j] = g[j+1];
            }
            return fAkumHelper(f, g, ++i, n, r);
        }
    }
}
