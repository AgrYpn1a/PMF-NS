/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i ctampa njihov zbir,
   b) stampa polinom r(x) = q(x)*p(x) - 4p(x) - x^3 + 2x - 5.
   Napisati i testirati na r(x) metod koji:
   c) vraca koliko polinom ima monoma sa ne-nula koeficijentom 
   ciji stepen pri deljenju sa 3 daje ostatak k, gde je k 
   parametar metoda (unos vrednosti za parametar realizovati u main metodi).
   d) deli polinom na tri polinoma: prvi sadrzi monome ciji su 
   koeficijenti negativni, drugi monome ciji su koeficijenti pozitivni
   i manji od 10 i treci sve ostale monome (ispis dobijenih polinoma 
   realizovati u main metodi; polinom sa kojim je pozvana metoda mora biti ocuvan).
 */

class Pol9 {
  // (c)
  static int brojMonoma(Polinom p, int k) {
    if (p == null) 
      return 0;
    int br = 0;
    if (p.st >- 1) {
      for (int i = 0; i <= p.st; i++) {
        if (p.k[i] != 0.0 && i % 3 == k) {
          br++;
        }
      }
    }
    return br;
  }
  
  // (d)
  static Polinom[] podeliPolinom(Polinom p) {
    if (p == null)
      return null;
    Polinom a = new Polinom();
    Polinom b = new Polinom();
    Polinom c = PolinomN.kopiraj(p);
    
    if (c.st >- 1) {
      for (int i = 0; i <= c.st; i++) {
        if (c.k[i] != 0.0) {
          if (c.k[i] < 0.0) {
            a.k[i] = c.k[i];
            c.k[i] = 0.0;
          }
          if (c.k[i] > 0.0 && c.k[i] < 10.0) {
            b.k[i] = c.k[i];
            c.k[i] = 0.0;
          }
        }
      }
    }
    PolinomN.nadjiStepen(a);
    PolinomN.nadjiStepen(b);
    PolinomN.nadjiStepen(c);
    Polinom[] rez = {a, b, c};
    return rez;
  }

  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    System.out.println();
    System.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    System.out.println();
    Polinom zbir = PolinomN.saberi(p, q);
    System.out.print("p(x) + q(x) = ");
    PolinomN.stampaj(zbir);
    System.out.println();
    
    // (b)
    // q(x)*p(x)         
    Polinom sab1 = PolinomN.puta(p, q);
    
    // –4p(x)
    Polinom sab2 = PolinomN.brojPuta(p, -4.0);
    
    // -x^3 + 2x - 5
    Polinom pom1 = new Polinom();
    pom1.st = 3;
    pom1.k[3] = -1.0;
    pom1.k[1] = 2.0;
    pom1.k[0] = -5.0;
    
    // q(x)*p(x) – 4p(x)
    Polinom r = PolinomN.saberi(sab1, sab2);
    // q(x)*p(x) – 4p(x)- x^3 + 2x - 5
    r = PolinomN.saberi(r, pom1);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    int k;
    do {
      System.out.println();
      System.out.print("Unesite parametar k (0, 1 ili 2): ");
      k = Svetovid.in.readInt();
    } while (k < 0 || k > 2);
    System.out.println();
    System.out.println("Broj monoma sa ne-nula koeficijentom ciji stepen pri deljenju sa 3 daje ostatak " + k + ": " + brojMonoma(r, k));
    
    // (d)
    Polinom[] poli = podeliPolinom(r);
    System.out.println();
    System.out.print("Polinom sa monomima ciji su koeficijenti negativni: ");
    PolinomN.stampaj(poli[0]);
    System.out.println();
    System.out.print("Polinom sa monomima ciji su koeficijenti pozitivni i manji od 10: ");
    PolinomN.stampaj(poli[1]);
    System.out.println();
    System.out.print("Polinom sa preostalim monomima: ");
    PolinomN.stampaj(poli[2]);
    System.out.println();
  }
}