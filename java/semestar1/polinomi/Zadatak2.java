class Zadatak2
{
    public static void main(String[] args)
    {
        int a, b, c, n;
        do
        {
            System.out.println("Unesi ceo broj A(A !=0): ");
            a = Svetovid.in.readInt();
        }
        while(a == 0);
        System.out.println("Unesi ceo broj B: ");
        b = Svetovid.in.readInt();

        System.out.println("Unesi ceo broj C: ");
        c = Svetovid.in.readInt();

        Polinom p = new Polinom();

        p.st = 2;

        p.k[2] = a;
        p.k[1] = b;
        p.k[0] = c;

        do
        {
            System.out.println("Unesite stepen n (0 <= n <= 50)");
            n = Svetovid.in.readInt();
        }
        while(n < 0 || n > 50);

        Polinom pNaN = new Polinom();
        pNaN.st = 0;
        pNaN.k[0] = 1;

        for(int i=1; i<=n; i++)
            pNaN = PolinomN.puta(p, pNaN);

        Polinom q = new Polinom(), r = new Polinom();


        for(int i=0; i<=pNaN.st; i++)
            if(i%2 == 0)
                q.k[i/2] = pNaN.k[i];
            else
                r.k[i/2] = pNaN.k[i];

        PolinomN.nadjiStepen(q);
        PolinomN.nadjiStepen(r);

        System.out.print("q(x) = ");
        PolinomN.stampaj(q);
        System.out.println();
        System.out.print("r(x) = ");
        PolinomN.stampaj(r);
        System.out.println();
        System.out.print("pNaN: ");
        PolinomN.stampaj(pNaN);
    }
}
