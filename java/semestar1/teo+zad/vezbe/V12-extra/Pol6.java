/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa ostatak pri deljenju ta dva polinoma,
   b) stampa polinom r(x) = p(0)(3 - 2x^2 + x^3) - (x^2 - 3x - 5x^3)q(x)
   Napisati i testirati na polinomu r(x) metod koji:
   c) nalazi aritmeticku sredinu koeficijenata monoma parnog stepena sa strogo pozitivnim koeficijentima
   (ako aritmenticka sredina ne postoji metod kao rezultat vrati -1),
   d) broji koliko ima monoma sa ne-nula koeficijentima kod kojih je koeficijent veci nego koeficijent sledbenika 
   (sledbenik monoma A je monom B takav da je B prvi monom sa ne-nula koeficijentom ciji je stepen
   veci od stepena monoma A).
 */
 
class Pol6 {

  // (c)
  static double aritmeticka(Polinom r) {
    if (r == null)
      return -1.0;
    double suma = 0.0;
    int br = 0;
    for (int i = 0; i <= r.st; i += 2) {
      if (r.k[i] > 0) {
        suma += r.k[i];
        br++;
      }
    }
    return br == 0 ? -1.0 : suma / br;
  }

  // (d)
  static int veciOdSledbenika(Polinom r) {
    if (r == null)
      return 0;    
    int br = 0; // brojac
    for (int i = 0; i < r.st; i++) {
      // preskoci monome sa nula koeficijentima
      if (r.k[i] != 0) {
        // preskoci sledbenike sa nula koeficijentima
        int j = i + 1;
        while (r.k[j] == 0.0)
          j++;
        if (r.k[i] > r.k[j]) {
          br++;
        }
      }
    }
    return br;
  }

  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    System.out.println();
    System.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    System.out.println();
    Polinom[] ko = PolinomN.deli(p, q);
    if (ko != null) {
      System.out.print("Ostatak pri deljenju p i q je: ");
      PolinomN.stampaj(ko[1]);
    }
    else {
      System.out.print("Polinom q(x) ne moze biti nula-polinom.");
    }
    System.out.println();

    // (b)
    // c1(x) = 3 - 2x^2 + x^3
    Polinom c1 = new Polinom();
    c1.st = 3;
    c1.k[3] = 1.0;
    c1.k[2] = -2.0;
    c1.k[0] = 3.0;
 
    // s1(x) = p(0)(3 - 2x^2 + x^3) = p(0)c1(x)
    double p0 = PolinomN.izracunaj(0.0, p);
    Polinom s1 = PolinomN.brojPuta(c1, p0);
  
    // c2(x) = x^2 - 3x - 5x^3
    Polinom c2 = new Polinom();
    c2.st = 3;
    c2.k[3] = -5.0;
    c2.k[2] = 1.0;
    c2.k[1] = -3.0;
 
    // s2(x) = (x^2 - 3x - 5x^3)q(x) = c2(x)q(x)
    Polinom s2 = PolinomN.puta(c2, q);
  
    // r(x) = p(0)(3 - 2x^2 + x^3) - (x^2 - 3x - 5x^3)q(x) = s1(x) - s2(x)
    Polinom r = PolinomN.oduzmi(s1, s2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
  
    // (c)
    double as = aritmeticka(r);
    System.out.println();
    if (as == -1.0)
      System.out.println("Aritmeticka sredina ne postoji");
    else
      System.out.println("Aritmeticka sredina je: " + as);

    // (d)
    System.out.println();
    System.out.println("Koef. veci od sledbenika je: " + veciOdSledbenika(r));
  }
}