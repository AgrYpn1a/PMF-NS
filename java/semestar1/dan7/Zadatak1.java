class Zadatak1
{
 public static void main(String[] args)
 {
    int n = Svetovid.in.readInt();
    System.out.println("Po definiciji: " + f(n));
    System.out.println("Po akumulirajucem parametru: " + fAkum(n));
    System.out.println("Iterativno: " + fIter(n));
 }

 // Rekurzivno po definiciji
 private static int f(int n)
 {
    if(n < 3)
    {
        return n;
    }

    return 2*f(n-1) - f(n-2) + f(n-3);
 }

 // Rekurzivno putem akumulirajuceg parametra
 private static int fAkum(int n)
 {
    if(n < 3)
    {
        return n;
    }
    return fAkumHelper(2, 1, 0, n);
 }

 private static int fAkumHelper(int f2, int f1, int f0, int n)
 {
    if(n == 0)
    {
        return f0;
    }
    return fAkumHelper(2*f2-f1+f0, f2, f1, --n);
 }

 // Iterativno
 private static int fIter(int n)
 {
    int fn;
    int f0 = 0;
    int f1 = 1;
    int f2 = 2;

    if(n == 0)
    {
        fn = f0;
    }
    else if(n == 1)
    {
        fn = f1;
    }
    else if(n == 2)
    {
        fn = f2;
    }
    else
    {
        fn = 0;
        for(int i=3; i<=n; i++)
        {
            fn = 2*f2 - f1 + f0;
            f0 = f1;
            f1 = f2;
            f2 = fn;
        }
    }
    return fn;
 }
}
