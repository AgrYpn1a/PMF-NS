/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihov proizvod,
   b) stampa polinom r(x) = (p(x) + 3x^2 + 2x)(2x^3 + q(3)).
   Napisati i testirati na polinomu r(x) metod koji:
   c) odstranjuje iz polonoma sve monome ciji su koeficijenti kvadrati celog broja,
   d) proverava da li su koeficijenti monoma poredjani u opadajucem redosledu, 
   gledano od monoma najveceg stepena.
 */

class Pol5 {

  // (c)
  static void odstrani(Polinom r) {
    if (r == null) 
      return;
    for (int i = 0; i <= r.st; i++) {
      double k = r.k[i];
      int kk = (int) Math.sqrt(k);
      if (k == kk * kk) 
        r.k[i] = 0.0;
    }
    PolinomN.nadjiStepen(r);
  }

  // (d)
  static boolean poredjani(Polinom r) {
    for (int i = r.st; i > 0; i--) {
      if (r.k[i] <= r.k[i - 1]) {
        return false;
      }
    }    
    return true;
  }

  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    System.out.println();
    System.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    System.out.println();
    Polinom pq = PolinomN.puta(p, q);
    if (pq != null) {
      System.out.print("p(x)q(x) = ");
      PolinomN.stampaj(pq);
    }
    else {
      System.out.print("Polinom p(x)q(x) je prevelikog stepena.");
    }
    System.out.println();

    // (b)
    // s1(x) = 3x^2 + 2x 
    Polinom s1 = new Polinom();
    s1.st = 2;
    s1.k[2] = 3.0;
    s1.k[1] = 2.0;
      
    // c1(x) = p(x) + 3x^2 + 2x = p(x) + s1(x)
    Polinom c1 = PolinomN.saberi(p, s1);

    // c2(x) = 2x^3 + q(3)
    Polinom c2 = new Polinom();
    c2.st = 3;
    c2.k[3] = 2.0;
    c2.k[0] = PolinomN.izracunaj(3.0, q);
  
    // r(x) = (p(x) + 3x^2 + 2x)(2x^3 + q(3)) = c1(x)c2(x)
    Polinom r = PolinomN.puta(c1, c2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();

    // (c)
    odstrani(r);
    System.out.println();
    System.out.print("r(x) nakon odstranjivanja: ");
    PolinomN.stampaj(r);
    System.out.println();
  
    // (d)
    System.out.println();
    if (poredjani(r)) 
      System.out.println("Koeficijenti u opadajucem redosledu");
    else
      System.out.println("Koeficijenti nisu u opadajucem redosledu");
  }
}