/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) ucitava polinome p(x) i q(x) i stampa polinom cija je suma koeficijenata veca
   (u slucaju da su sume jednake stampa polinom p(x)),
   b) stampa polinom r(x) = p(x)*q(x) - q(x)^3 - 4q(x) + x^4 -3x^3 + 12.
   Napisati i testirati na polinomu r(x) metod koji:
   c) sve koeficijente monoma parnog stepena mnozi sa 2, a sve koeficijente monoma
   neparnog stepena sabira sa 5,
   d) mnozi polinom polinomom x, a monom nultog stepena novog polinoma postaje
   aritmeticka sredina svih ostalih koeficijenata.
 */

class Pol13 {
  
  // (c)
  static void parniNeparni(Polinom r) {
    if (r == null) 
      return;
    for (int i = 0; i <= r.st; i++) {
      if (i % 2 == 0) {
        r.k[i] *= 2.0;
      }
      else {
        r.k[i] += 5.0;
      }
    }
    PolinomN.nadjiStepen(r);
  }
  
  // (d)
  static Polinom mnoziSaX(Polinom r) {
    if (r == null)
      return null;
    Polinom x = new Polinom();
    x.st = 1;
    x.k[1] = 1.0;
    Polinom rez = PolinomN.puta(r, x);
    if (rez == null)
      return null;
    int br = 0;
    double suma = 0.0;
    double eps = 1.0e-5;
    for (int i = 1; i <= rez.st; i++) {
      if (Math.abs(rez.k[i] - 0.0) > eps) { 
        suma += rez.k[i];
        br++;
      }
    }
    rez.k[0] = suma / br;
    return rez;
  }
  
  static double sumaKoef(Polinom p) {
    double suma = 0.0;
    for (int i = 0; i <= p.st; i++) {
      suma += p.k[i];
    }
    return suma;
  }
  
  public static void main(String[] args) {
    // (a)
    System.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    System.out.println();
    System.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    double sumaP = sumaKoef(p);
    double sumaQ = sumaKoef(q);
    System.out.println();
    System.out.print("Polinom sa vecom sumom koeficijenata je ");
    if (sumaP >= sumaQ) {
      System.out.print("p(x): ");
      PolinomN.stampaj(p);
    }
    else {
      System.out.print("q(x): ");
      PolinomN.stampaj(q);
    } 
    System.out.println();
    
    // (b)
    Polinom r = PolinomN.puta(p, q);
    if (r == null) {
      System.out.println("Greska! Prekoracenje opsega!");
      return;
    }
    Polinom s1 = PolinomN.puta(q, q);
    s1 = PolinomN.puta(s1, q);
    if (s1 == null) {
      System.out.println("Greska! Prekoracenje opsega!");
      return;
    }
    r = PolinomN.oduzmi(r, s1);
    Polinom s2 = new Polinom();
    s2.st = 4;
    s2.k[0] = 12.0;
    s2.k[3] = 3.0;
    s2.k[4] = 1.0;
    r = PolinomN.saberi(r, s2);
    System.out.println();
    System.out.print("r(x) = ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (c)
    parniNeparni(r);
    System.out.println();
    System.out.print("Modifikovani polinom r: ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (d)
    Polinom putaX = mnoziSaX(r); 
    System.out.println();
    System.out.print("mnoziSaX(r) = ");
    PolinomN.stampaj(putaX);
    System.out.println();
  }
}