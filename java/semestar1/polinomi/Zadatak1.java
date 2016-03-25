class Zadatak1
{
    /*
     * Napisati program koji ucitava polinom p(x) koji sadrzi samo
     * celobrojne koeficijente i pronalazi i ispisuje neke 
     * celobrojne nule ovog polinoma
     */ 
    public static void main(String[] args)
    { 
        final int gr = 1000;
        System.out.println("Unesite polinom p: ");
        Polinom p = PolinomN.ucitaj();

        for(int i=-gr; i<= gr; i++)
            if(PolinomN.izracunaj(i, p) == 0.0)
                System.out.println("Nula polinoma je: " + i);
    }
}
