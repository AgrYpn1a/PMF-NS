/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihov kolicnik,
   b) stampa polinom r(x) = 5q^2(x)(2.5x^3 + x) - p(2) + 8.
   Napisati i testirati na r(x) metodu koja:
   c) dize na kvadrat koeficijente monoma ciji je stepen neparan broj,
   d) deli polinom na dva polinoma: jedan koji sadrzi monome ciji su 
   koeficijenti celobrojne vrednosti i drugi ciji koeficijenti nisu 
   celobrojne vrednosti (ispis oba polinoma realizovati u main metodu; 
   polinom sa kojim je pozvana metoda mora biti ocuvan).  
 */

class Pol8 {
  // (c)
  static void naKvadrat(Polinom p) {
    if (p == null) return;
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 1) {
        p.k[i] = Math.pow(p.k[i], 2);
      }
    }
  }
  
  // (d)
  static Polinom[] celobrojni(Polinom p) {
    if (p == null)
      return null;
    Polinom a = PolinomN.kopiraj(p);
    Polinom drugi =  new Polinom();
    if (a.st > -1) {
      for (int i = 0; i <= a.st; i++) {
        if (a.k[i] != 0.0 && a.k[i] != Math.round(a.k[i])) {
          drugi.k[i] = a.k[i];
          a.k[i] = 0.0;
        }
      }
    }
    PolinomN.nadjiStepen(a);
    PolinomN.nadjiStepen(drugi);
    Polinom[] rez = {a, drugi};
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
    Polinom[] kolost = PolinomN.deli(p, q); 
    if (kolost != null) { 
      System.out.print("p(x)/q(x) = "); 
      PolinomN.stampaj(kolost[0]); 
    } 
    else { 
      System.out.print("Polinom q(x) ne moze biti nula-polinom."); 
    }
    System.out.println();
    
    // (b)
    // 2.5x^3+x          
    Polinom pom1 = new Polinom();
    pom1.st = 3;
    pom1.k[3] = 2.5;
    pom1.k[1] = 1.0;
    
    //q^2(x)
    Polinom qNa2 = PolinomN.puta(q, q);
    
    //q^2(x)(2.5x^3 + x)
    Polinom r = PolinomN.puta(pom1, qNa2);
    //5q^2(x)(2.5x^3+x)
    r = PolinomN.brojPuta(r, 5);
    //5q^2(x)(2.5x^3+x) – p(2) + 8
    r.k[0] = r.k[0] + 8 - PolinomN.izracunaj(2.0, p);
    PolinomN.nadjiStepen(r); // za slucaj da je q(x) = 0 i p(2) = 8
    
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    naKvadrat(r);
    System.out.println();
    System.out.print("r(x) sa koeficijentima monoma ciji je stepen neparan broj na kvadrat: ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d)
    Polinom[] poli = celobrojni(r);
    System.out.println();
    System.out.print("Polinom sa monomima ciji su koeficijenti celobrojne vrednosti: ");
    PolinomN.stampaj(poli[0]);
    System.out.println();
    System.out.print("Polinom sa monomima ciji koeficijenti nisu celobrojne vrednosti: ");
    PolinomN.stampaj(poli[1]);
    System.out.println();
  }
}