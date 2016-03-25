/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa njihovu razliku,
   b) stampa polinom r(x) = q'(1)q(x) - p(x)(x^2 - 3) + 2x^4 + 5x^3.
   Napisati i testirati na polinomu r(x) metod koji:
   c) odstranjuje iz polinoma sve monome sa parnim stepenom,
   d) stampa sve nenula monome (svaki u novom redu) ciji se koeficijent
   i stepen razlikuju za najvise 5.
 */

class Pol4 {

  static Polinom izvod(Polinom p) {
    if (p == null)
      return null;
    Polinom rez = new Polinom();
    if (p.st > 0) {
      rez.st = p.st - 1;
      for (int i = 0; i <= rez.st; i++) {
        rez.k[i] = p.k[i+1] * (i+1);
      }
    }
    return rez;
  }

  // (c)
  static void odstraniParneStepene(Polinom p) {
    if (p == null) return;
    for (int i = 0; i <= p.st; i++) {
      if (i % 2 == 0) {
        p.k[i] = 0.0;
      }
    }
    PolinomN.nadjiStepen(p);
  }

  // (d)
  static void stampajMonomeRM5(Polinom p) {
    if (p == null) return;
    Polinom pom = new Polinom();
    for (int i = 0; i <= p.st; i++) {
      if (p.k[i] != 0.0 && Math.abs(p.k[i] - i) < 5.0) {
        PolinomN.anuliraj(pom);
        pom.st = i;
        pom.k[i] = p.k[i];
        System.out.println();
        PolinomN.stampaj(pom);
      }
    }
  }

  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    System.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    Polinom razlika = PolinomN.oduzmi(p, q);
    System.out.print("p(x) - q(x) = ");
    PolinomN.stampaj(razlika);

    // (b)
    Polinom pom1 = new Polinom();
    pom1.st = 2;
    pom1.k[2] = 1.0;
    pom1.k[0] = -3.0;
    Polinom pom2 = new Polinom();
    pom2.st = 4;
    pom2.k[4] = 2.0;
    pom2.k[3] = 5.0;
    Polinom qizv = izvod(p);
    double q1 = PolinomN.izracunaj(1.0, qizv);
    Polinom sab1 = PolinomN.brojPuta(q, q1);
    Polinom sab2 = PolinomN.puta(p, pom2);
    Polinom r = PolinomN.oduzmi(sab1, sab2);
    r = PolinomN.saberi(r, pom2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);

    // (c)
    odstraniParneStepene(r);
    System.out.println();
    System.out.print("r(x) bez parnih stepena = ");
    PolinomN.stampaj(r);

    // (d)
    System.out.println();
    System.out.print("Monomi sa razlikom koeficijenta i stepena ne vecom od 5 su:");
    stampajMonomeRM5(r);
  }
}