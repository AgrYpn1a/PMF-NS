class Zadatak6
{
    public static void main(String[] args)
    {
        // a)
        Polinom p = PolinomN.ucitaj(), q = PolinomN.ucitaj();
        System.out.print("\np(x)=");
        PolinomN.stampaj(p);
        System.out.print("\nq(x)=");
        PolinomN.stampaj(q);
        System.out.println();

        // b)
        Polinom r = q;
        r = PolinomN.puta(r, p);
        r = PolinomN.oduzmi(r, PolinomN.brojPuta(p, 4.0));

        Polinom pom = new Polinom();
        pom.st = 3;
        pom.k[3] = 1;
        pom.k[1] = 2;
        pom.k[0] = -5;

        r = PolinomN.oduzmi(r, pom);
        System.out.print("\nr(x)=");
        PolinomN.stampaj(r);

        // c)
        System.out.print("\nUnesi k: ");
        double k = Svetovid.in.readDouble();

        System.out.print("\nPolinom r(x), brMonK=" + 
                brMonK(k, r));

        // d)
        System.out.print("\na(x)=");
        Polinom[] temp = deliNaTri(r);
        PolinomN.stampaj(temp[0]);
        System.out.print("\n\n");
    }

    // c) method
    private static int brMonK(double k, Polinom p)
    {
        if(p == null)
            return 0;

        int brMon = 0;
        if(p.st > -1)
        {
            for(int i=1; i<=p.st; i++)
                if(p.k[i] != 0 && i%3 == k)
                    brMon++;       
        }
        return brMon;
    }

    // d)
    private static Polinom[] deliNaTri(Polinom p)
    {
        if(p == null)
            return null;

        Polinom a = new Polinom(), b = new Polinom(),
                x = PolinomN.kopiraj(p);
        if(x.st > -1)
        {
            for(int i=0; i<=x.st; i++)
            {
                if(x.k[i] == 0)
                    continue;

                if(x.k[i] < 0.0)
                {
                    a.k[i] = x.k[i];
                    x.k[i] = 0;
                }
                else if(x.k[i] > 0.0 && x.k[i] < 10.0)
                {
                    b.k[i] = x.k[i];
                    x.k[i] = 0.0;
                }
            }
        }

        PolinomN.nadjiStepen(a);
        PolinomN.nadjiStepen(b);
        PolinomN.nadjiStepen(x);

        Polinom[] rez = {a, b, x}; 
        return rez;
    }
}
