class Zadatak5
{
    public static void main(String[] args)
    {
        // a) bez sabiranja, mrzi me da kucam
        Polinom p = PolinomN.ucitaj(), q = PolinomN.ucitaj();
        System.out.print("\np(x)=");
        PolinomN.stampaj(p);
        System.out.print("\nq(x)=");
        PolinomN.stampaj(q);
        System.out.println();

        
        // b) samo pratimo formulu, korak po korak
        Polinom r = new Polinom();

        Polinom pom = new Polinom();
        pom.st = 1;
        pom.k[1] = 2;
        pom.k[0] = 1;

        r = kompozicija(q, pom);

        PolinomN.anuliraj(pom);
        pom.st = 2;
        pom.k[2] = 1;
    
        pom = PolinomN.puta(pom, p);

        r = PolinomN.oduzmi(r, 
                PolinomN.brojPuta(pom, PolinomN.izracunaj(2.0, p)));

        PolinomN.anuliraj(pom);
        pom.st = 3;
        pom.k[3] = 4;
        pom.k[0] = -1;

        r = PolinomN.saberi(r, pom);

        // test
        System.out.print("\n\nf(x) o g(x)=");
        PolinomN.stampaj(kompozicija(p, q));
    }

    private static Polinom kompozicija(Polinom f, Polinom g)
    {
        // f(g(x))
        if((f == null) || (g == null) || (f.st * g.st > Polinom.maxSt))
            return null;

        // primer
        // g(x) = x-3
        // f(x) = 3*x^2 + 2*x
        // f(g(x)) = 3*(x-3)^2 = 3*(x-3)(x-3) + 2*(x-3)
        Polinom kompRez = new Polinom();
        Polinom gNaN = new Polinom();

        if(f.st > -1)
        {
            kompRez.st = 0;
            kompRez.k[0] = 0;

            gNaN.st = 0;
            gNaN.k[0] = 1.0;

            for(int x=1; x<=f.st; x++)
            {
                gNaN = PolinomN.puta(gNaN, g);
                Polinom pom = PolinomN.brojPuta(gNaN, f.k[x]);
                kompRez = PolinomN.saberi(kompRez, pom);
            }        
        }
        return kompRez;
    }
}
