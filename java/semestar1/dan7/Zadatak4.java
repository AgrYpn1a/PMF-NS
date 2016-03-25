class Zadatak4
{
    public static void main(String[] args)
    {
        int n = Svetovid.in.readInt();
        int r = Svetovid.in.readInt();
        
        System.out.println("Po def: " + fDef(n, r));    
        System.out.println("Po akum: " + fAkum(n, r));
        System.out.println("Iterativno: " + fIter(n, r));
    }

    // Rekurzivno po definiciji
    private static int fDef(int n, int r)
    {
        if(n<r)
            return r-n;
        else
        {
            if(n >= 0 && n <= 9)
            {
                return fDef(n-r+3, r) + gDef(n-r+2, r) - 
                    5*fDef(n-r, r);
            }
            else
            {
                return -2*fDef(n-1, r) + gDef(n-1, r) - 
                    4*gDef(n-r+1, r) + gDef(n-r, r);
            }
        }   
    }

    private static int gDef(int n, int r)
    {
        if(n<r)
            return r+n;
        else
        {
            if(n%5 == 0)
            {
                return -gDef(n-r+1, r) + fDef(n-2, r);
            }
            else
            {
                return 3*fDef(n-r+2, r) - 4*(gDef(n-2, r) + fDef(n-r, r));
            }
        
        }
    }

    // Putem akumulirajuceg parametra
    private static int fAkum(int n, int r)
    {
        if(n<r)
            return r-n;;

        int[] f = new int[r+1];
        int[] g = new int[r+1];
        for(int i=0; i<r; i++)
        {
            f[i] = r-i;
            g[i] = r+i;
            
        }

        return fAkumHelper(f, g, r, r, n);
    }

    private static int fAkumHelper(int[] f, int[] g, int i, int r, int n)
    {
        if(i>n)
            return f[r];
        
        // racunamo f
        if(i >= 0 && i <= 9)
        {
            f[r] = f[r-r+3] + g[r-r+2] - 5*f[r-r];
        }
        else
        {
            f[r] = -2*f[r-1] + g[r-1] - 4*g[r-r+1] + g[r-r];
        }

        // racunamo g
        if(i%5 == 0)
        {
            g[r] = -g[r-r+1] + f[r-2];
        }
        else
        {
            g[r] = 3*f[r-r+2] - 4*(g[r-2] + f[r-r]);
        }

        for(int j=0; j<r; j++)
        {
            f[j] = f[j+1];
            g[j] = g[j+1];            
        }
        return fAkumHelper(f, g, ++i, r, n);
    }

    // Iterativno
    private static int fIter(int n, int r)
    {
        if(n<r)
            return r-n;

        int[] f = new int[r+1];
        int[] g = new int[r+1];

        for(int i=0; i<r; i++)
        {
            f[i] = r-i;
            g[i] = r+i;
        }

        for(int j=r; j<n; j++)
        {
            // racunamo f
            if(j >= 0 && j <= 9)
            {
                f[r] = f[j-r+3] + g[j-r+2] - 5*f[j-r];
            }
            else
            {
                f[r] = -2*f[j-1] + g[r-1] - 4*g[j-r+1] + g[j-r];
            }

            // racunamo g
            if(j%5 == 0)
            {
                g[r] = -g[j-r+1] + f[r-2];
            }
            else
            {
                g[r] = 3*f[j-r+2] - 4*(g[r-2] + f[j-r]);
            }
            for(int k=0; k<r; k++)
            {
                f[k] = f[k+1];
                g[k] = g[k+1];
            }
        }
        return f[r];

    }

}
