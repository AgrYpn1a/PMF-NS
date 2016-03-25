class ZadatakSaPosVezbi
{
    public static void main(String[] args)
    {
        // ucitavamo p i q
        Polinom p = PolinomN.ucitaj(), q = PolinomN.ucitaj();
        System.out.print("p(x)=");
        PolinomN.stampaj(p);
        System.out.print("\nq(x)=");
        PolinomN.stampaj(q);
        System.out.println();
        
        // ispisujemo zbir
        System.out.print("\n\np(x)+q(x) = ");
        PolinomN.stampaj(PolinomN.saberi(p, q));
        System.out.println();

        // pravimo r(x)
        Polinom r = q;
        r = PolinomN.oduzmi(r, PolinomN.brojPuta(p, 3.0));

        // pomocni polinom kao poslednja 2 monoma u r
        Polinom pom = new Polinom();
        pom.st = 4;
        pom.k[4] = 2;
        pom.k[1] = 3;

        // dodajemo novi polinom na r, i tako zavrsavamo
        // sa kreiranjem r po zadatoj formuli
        r = PolinomN.saberi(r, pom);
        System.out.print("r(x)=");
        PolinomN.stampaj(r);
        System.out.println();

        // pozivamo metode c i d
        // uvecaj koef od r, koji su != 0 za 1
        neNulaKoef(r);
        
        System.out.print("\n(uvKza1)r(x)=");
        PolinomN.stampaj(r);
        System.out.print("\nNajmanji koef r(x)=");
        // stampaj monom sa najmanjim koef != 0
        stampajMinKoef(r);
        System.out.print("\n\n");
    }

    // c) koef. razlicite od 0 uvecaj za 1
    private static void neNulaKoef(Polinom p)
    {
        if(p == null)
            return;

        for(int i=0; i<=p.st; i++)
            if(p.k[i] != 0)
                p.k[i] += 1;

        PolinomN.nadjiStepen(p);
    }

    // d) stampaj monom sa najmanjim koef. razlicitim od 0
    private static void stampajMinKoef(Polinom p)
    {
        double minK = nadjiMin(p.k);
        Polinom pom = new Polinom();

        for(int i=0; i<=p.st; i++)
        {
            if(p.k[i] == minK)
            {
                pom.st = i;
                pom.k[i] = p.k[i];
                PolinomN.stampaj(pom);        
            }
        }
    }
    // pomocna metoda, nadji najmanji
    private static double nadjiMin(double[] n)
    {
        double min = n[0];
        for(int i=0; i<n.length; i++)
            if(n[i]<min && n[i] != 0.0)
                min = n[i];

        return min;
    }
}
