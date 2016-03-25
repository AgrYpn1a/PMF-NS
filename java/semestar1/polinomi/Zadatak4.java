class Zadatak4
{
    public static void main(String[] args)
    {
        // a)
        Polinom p = PolinomN.ucitaj(), q = PolinomN.ucitaj();
        System.out.print("\n\np(x)=");
        PolinomN.stampaj(p);
        System.out.print("\nq(x)=");
        PolinomN.stampaj(q);
        // razlika
        System.out.print("\n\np(x)-q(x)=");
        PolinomN.stampaj(PolinomN.oduzmi(p, q));
        System.out.println();

        // b)
        Polinom r = new Polinom();
        // izvod q u tacki 1
        double qIzv = PolinomN.izracunaj(1.0, izvod(q));
        r = PolinomN.brojPuta(q, qIzv);

        // p(x) * pom(x)
        Polinom pom = new Polinom();
        pom.st = 2;
        pom.k[2] = 1;
        pom.k[0] = -3;

        r = PolinomN.oduzmi(r, PolinomN.puta(p, pom));

        PolinomN.anuliraj(pom);
        pom.st = 4;
        pom.k[4] = 2;
        pom.k[3] = 5;

        r = PolinomN.saberi(r, pom);
        System.out.print("\n\nr(x)=");
        PolinomN.stampaj(r);

        // c)
        odstraniParan(r);
        System.out.print("\n\nOdstranjen paran r(x)=");
        PolinomN.stampaj(r);
        
        // d)
        System.out.print("\n\nMonomi:\n");
        stampajMonRz5(r);
        System.out.print("\n\n");

    }

    private static Polinom izvod(Polinom p)
    {
        if(p == null)
            return null;

        Polinom izv = new Polinom();
        izv.st = p.st - 1;
        for(int i=0; i<=izv.st; i++)
            izv.k[i] = p.k[i+1] * (i+1);
        return izv;
    }

    private static void odstraniParan(Polinom p)
    {
        if(p == null)
            return;

        for(int i=0; i<=p.st; i++)
        {
            if(i%2 == 0)
                p.k[i] = 0.0;
        }
        PolinomN.nadjiStepen(p);
    }

    private static void stampajMonRz5(Polinom p)
    {
        if(p == null)
            return;

        Polinom pom = new Polinom();

        for(int i=0; i<=p.st; i++)
        {
            if(Math.abs(i-p.k[i]) < 5 && p.k[i] != 0)
            {       
                PolinomN.anuliraj(pom);
                pom.st = i;
                pom.k[i] = p.k[i];
                PolinomN.stampaj(pom);
                System.out.println();
            }
        }

    }
}
