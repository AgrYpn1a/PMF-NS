class Zadatak2
{
    public static void main(String[] args)
    {
        int n = Svetovid.in.readInt();
        System.out.println("Rekurzivno po def: " + fDef(n));   
        System.out.println("Akumulirajuce: " + fAkum(n));   
        System.out.println("Iterativno: " + fIter(n));   
    }

    // Rekurzivno po definiciji
    private static int fDef(int n)
    {
        if(n == 0)
            return 1;
        else if(n == 1)
            return 3;
        else if(n == 2)
            return 2;
        else
        {
            if(n % 2 != 0)
                return fDef(n-1) - 2*fDef(n-2);
            else
                return fDef(n-2) + 3*fDef(n-3); 

        }

    }

    // Rekurizvno po akumulirajucem parametru
    private static int fAkum(int n)
    {
        if(n == 0)
            return 1;
        else if(n ==1)
            return 3;
        else if(n == 2)
            return 2;
        else
            return fAkumHelper(2 , 3 , 1, 3, n);
    }

    private static int fAkumHelper(int f2, int f1, int f0, int i, int n)
    {
        if(i > n)
        {
            return f2;      
        }
        else
        {
            if(i % 2 != 0)
            {
                return fAkumHelper(f2 - 2*f1, f2, f1, ++i, n);
            }
            else
            {
                return fAkumHelper(f1 + 3*f0, f2, f1, ++i, n);
            }

        }
    }

    // Iterativno
    private static int fIter(int n)
    {
        int fn, f0 = 1, f1 = 3, f2 = 2;
        if(n == 0)
            fn = f0;
        else if(n == 1)
            fn = f1;
        else if(n == 2)
            fn = f2;
        else
        {
            fn = 0;
            for(int i=3; i<=n; i++)
            {
                if(i % 2 != 0)
                    fn = f2 - 2*f1;     
                else
                    fn = f1 + 3*f0;
                f0 = f1;
                f1 = f2;
                f2 = fn;
            }
        }
        return fn;
    }
}
