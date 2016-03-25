/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihovu aritmeticku sredinu,
   b) stampa polinom r(x) = (q(x) + p(2)*x)^2 + 3(q(x) + p(2)*x) - 4x^3 - 1. 
   Napisati i testirati na polinomu r(x) metod koji:
   c) obrce koeficijente polinoma r(x), tako da r.k[0] zameni mesta sa r.k[r.st], ...
   d) racuna proizvod monoma sa najvecim i najmanjim koeficijentom.
*/

class Pol10 {

  // (c)
  public static Polinom obrniKoeficijente(Polinom p) {
    if (p == null)
      return null;
    for (int i = 0; i <= p.st / 2; i++) {
      double d = p.k[i];
      p.k[i] = p.k[p.st - i];
      p.k[p.st - i] = d;
    }
    return p;
  }

  // (d)
  public static Polinom proizvodMonomaNMK(Polinom p) {
    if (p == null) 
      return null;
    Polinom rez = new Polinom();
    if (p.st == -1) 
      return rez;
    double minKoef, maxKoef;
    int minStepen, maxStepen;
    minKoef = p.k[p.st];
    minStepen = p.st;
    maxKoef = p.k[p.st];
    maxStepen = p.st;
    for (int i = p.st; i >= 0; i--) {
      if (p.k[i] < minKoef) {
        minKoef = p.k[i];
        minStepen = i;
      } 
      if (p.k[i] > maxKoef) {
        maxKoef = p.k[i];
        maxStepen = i;
      } 
    }
    if (minStepen + maxStepen > Polinom.maxSt) {
      return null;
    }
    else {
      rez.st = minStepen + maxStepen;
      rez.k[rez.st] = minKoef*maxKoef;
      return rez;
    }  
  }
  
  public static void main(String[] args) {
    Polinom p, q, aritmetickaSredina, r, pom1, pom2, px, sab1, sab2;
  
    // (a)
    System.out.println("Unesite polinom p:");
    p = PolinomN.ucitaj();
    System.out.println();
    System.out.println("Unesite polinom q:");
    q = PolinomN.ucitaj();
    System.out.println();
    aritmetickaSredina = PolinomN.saberi(p, q);
    aritmetickaSredina = PolinomN.brojPuta(aritmetickaSredina, 0.5);
    System.out.print("Aritmeticka sredina unetih polinoma je: ");
    PolinomN.stampaj(aritmetickaSredina);
    System.out.println();

    // (b)
    pom1 = new Polinom();
    pom1.st = 3;
    pom1.k[3] = -4;
    pom1.k[0] = -1;
    px = new Polinom();
    px.st = 1;
    px.k[1] = PolinomN.izracunaj(2.0, p);
    pom2 = PolinomN.saberi(q, px);
    sab1 = PolinomN.puta(pom2, pom2);
    sab2 = PolinomN.brojPuta(pom2, 3.0);
    r = PolinomN.saberi(sab1, sab2);
    r = PolinomN.saberi(r, pom1);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    Polinom rez = obrniKoeficijente(r);
    System.out.println();
    System.out.print("Polinom r(x) nakon obrtanja izgleda ovako: ");
    PolinomN.stampaj(rez);
    System.out.println();
    
    // (d)
    Polinom mon = proizvodMonomaNMK(r);
    System.out.println();
    System.out.print("Proizvod monoma sa najvecim i najmanjim koeficijentom je: ");
    PolinomN.stampaj(mon);
    System.out.println();
  }
}