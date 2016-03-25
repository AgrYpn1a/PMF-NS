class Zadatak3
{
    /*
     * Zadatak1, UUP-V12
     */ 
    public static void main(String[] args)
    {
        Polinom p = PolinomN.ucitaj(), q = PolinomN.ucitaj();

        System.out.print("Proizvod polinoma\n\n p(x)=");
        PolinomN.stampaj(p);
        System.out.print("\n q(x)=");
        PolinomN.stampaj(q);
        System.out.println("\n\nje:");
        PolinomN.stampaj(PolinomN.puta(p, q));

        System.out.println();

        Polinom r = q;
        r = PolinomN.oduzmi(r, izvod(p));
        r = PolinomN.oduzmi(r, PolinomN.brojPuta(p, 2.0));

        Polinom pom = new Polinom();
        pom.st = 2;
        pom.k[2] = 3;
        pom.k[1] = 0;
        pom.k[0] = -4;

        r = PolinomN.saberi(r, pom);

        System.out.print("\nr(x)=");
        PolinomN.stampaj(r);
        System.out.println();

        odstraniNegativne(r);
        System.out.print("(odst neg)r(x)=");
        PolinomN.stampaj(r);

        System.out.println();
        System.out.print("MonomiKVS: ");
        stampajKVS(r);
        System.out.print("\n\n");
    }

    private static Polinom izvod(Polinom p)
    {
        if(p == null)
            return null;
        
        Polinom izv = new Polinom();
        if(p.st > 0)
        {
            // prvi izvod smanjuje stepen polinoma za 1
            izv.st = p.st - 1;

            for(int i=0; i<=izv.st; i++)
            {
                izv.k[i] = p.k[i+1] * (i+1);
            }
        }
        return izv;
    }

    private static void odstraniNegativne(Polinom p)
    {
        if(p == null)
            return;
        for(int i=0; i<=p.st; i++)
            if(p.k[i] < 0.0)
                p.k[i] = 0.0;

        PolinomN.nadjiStepen(p);
    }

    private static void stampajKVS(Polinom p)
    {
        if(p == null)
            return;

        Polinom pom = new Polinom();
        for(int i=0; i<=p.st; i++)
        {
            if(p.k[i]>p.st)
            {
                PolinomN.anuliraj(pom);
                pom.st = i;
                pom.k[i] = p.k[i];
                PolinomN.stampaj(pom);
                System.out.print(" --- ");
            }
        }
    }
}
