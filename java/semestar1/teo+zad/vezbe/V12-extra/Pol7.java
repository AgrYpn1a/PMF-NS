/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihov proizvod,
   b) stampa polinom r(x) = q(-2)(x^6 – 3x^4 – 7) – (2x^5)*p(x).
   Napisati i testirati na r(x) metod koji:
   c) dize na kub negativne koeficijente monoma u polinomu,
   d) iz polinoma izbacuje prvih k monoma parnog stepena sa ne-nula
   koeficijentima (gledano od monoma sa najmanjim stepenom),
   gde je k parametar metoda (unos vrednosti za parametar realizovati u main metodi). 
 */

class Pol7 {

  // (c)
  static void naKub(Polinom p) {
    if (p == null) return;
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i]< 0) {
        p.k[i] = Math.pow(p.k[i],3);
      }
    }
  }

  // (d)
  static void kParnih(Polinom p, int k) {
    if (p == null) return;
    int br = 0;
    if (p.st > -1) {
      for (int i = 0; i <= p.st; i++) {
        if (p.k[i] != 0.0 && i % 2 == 0 && br < k) {
          p.k[i] = 0.0;
          br++;
        }
      }
      PolinomN.nadjiStepen(p);
    }
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
    // x^6 – 3x^4 – 7
    Polinom pom1 = new Polinom();
    pom1.st = 6;
    pom1.k[6] = 1.0;
    pom1.k[4] = -3.0;
    pom1.k[0] = -7.0;
    
    // q(-2) 
    double br = PolinomN.izracunaj(-2.0, q);
    // q(-2)(x^6 – 3x^4 – 7)
    Polinom c1 = PolinomN.brojPuta(pom1, br);
    
    // 2x^5
    Polinom pom2 = new Polinom();
    pom2.st = 5;
    pom2.k[5] = 2.0;
    
    // (2x^5)*p(x)
    Polinom c2 = PolinomN.puta(pom2,p);
    
    Polinom r = PolinomN.oduzmi(c1, c2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    naKub(r);
    System.out.println();
    System.out.print("r(x) sa negativnim koeficijentima na kub je: ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d)
    System.out.println();
    System.out.print("Unesite parametar k: ");
    int k = Svetovid.in.readInt();
    kParnih(r, k);
    System.out.println();
    System.out.print("r(x) sa izbacenim prvih k monoma parnog stepena sa ne-nula koeficijentima: ");
    PolinomN.stampaj(r);
    System.out.println();
  }
}