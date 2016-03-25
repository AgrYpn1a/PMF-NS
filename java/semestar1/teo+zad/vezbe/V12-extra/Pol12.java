/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihovu razliku,
   b) stampa polinom r(x) = p(x)/q(x) + p(x)^2 - 4q(x) + x^3 + 7.
   Napisati i testirati na polinomu r(x) metod koji:
   c) vraca "kompresovani" polinom t(x) za koji vazi
   t.k[0] = r.k[0] + r.k[1]
   t.k[1] = r.k[2] + r.k[3]
   ...
   ukoliko je stepen polinoma r(x) veci od 1. U suprotnom, vraca taj isti polinom;
   d) izbacuje sve monome ciji je koeficijent manji od apsolutne vrednosti
   razlike koeficijenata uz najveci i najmanji stepen polinoma.
 */

 class Pol12 {
  
  // (c)
  static Polinom kompresuj(Polinom r) {
    if (r == null || r.st < 2) 
      return r;
    Polinom rez = new Polinom();
    rez.st = r.st / 2;
    for(int i = 0; i <= rez.st; i++) {
      rez.k[i] = r.k[i*2] + r.k[i*2 + 1];
    }
    return rez;
  }
  
  // (d)
  static void izbaci(Polinom r) {
    if (r == null || r.st < 0)
      return;
    int najmanji = 0;
    double eps = 1.0e-5;
    while (najmanji < r.st && Math.abs(r.k[najmanji]-0.0) < eps) {
      najmanji++;
    }
    double abs = Math.abs(r.k[r.st] - r.k[najmanji]);
    for (int i = 0; i < r.st; i++) {
      if (r.k[i] < abs) {
        r.k[i] = 0.0;
      }
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
    Polinom razlika = PolinomN.oduzmi(p, q);
    System.out.print("p(x) - q(x) = ");
    PolinomN.stampaj(razlika);
    System.out.println();
    
    // (b)
    Polinom r = PolinomN.deli(p, q)[0];
    Polinom s1 = PolinomN.puta(p, p);
    if (s1 == null) {
      System.out.println("Greska! Prekoracenje opsega!");
      return;
    }
    r = PolinomN.saberi(r, s1);
    r = PolinomN.oduzmi(r, PolinomN.brojPuta(q, 4.0));
    Polinom s2 = new Polinom();
    s2.st = 3;
    s2.k[0] = 7.0;
    s2.k[3] = 1.0;
    r = PolinomN.saberi(r, s2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    Polinom kr = kompresuj(r);
    System.out.println();
    System.out.print("Kompresovani polinom r(x) je: ");
    PolinomN.stampaj(kr);
    System.out.println();
    
    // (d)
    izbaci(r); 
    System.out.println();
    System.out.print("r(x) nakon izbacivanja: ");
    PolinomN.stampaj(r);
    System.out.println();
  }
}