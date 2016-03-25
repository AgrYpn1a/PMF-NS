/* Koristeci klase Polinom i PolinomN, napisati program koji:
   a) kreira polinom r(x) koji odgovara razvoju funkcije sin(x) u Tejlorov red
   sin(x) ~ x - x^3/3! + x^5/5! i x^7/7! +...+ x^(2n+1)/(2n+1)!, n <= 10;
   b) za unetu vrednost broja x iz intervala [-1..1], izracunati razliku 
   izmedju p(x) i Math.sin(x). 
   Napisati i testirati na polinomu r(x) metod koji:
   c) izracunava vrednost odredjenog integrala na intervalu [0.5, 0.7],
   d) brise sve koeficijente koji su po apsolutnoj vrednoti manji od 0.00001.

   (Program moze lepo da se testira za n = 5 i x = 0.5.)
*/

class Pol11 {
  
  // (c)
  static double odredjeniIntegral(Polinom p, double a, double b) {
    if (a > b || p == null || p.st == Polinom.maxSt)
      return Double.MIN_VALUE;
    Polinom integral = new Polinom();
    integral.st = p.st + 1;
    for (int i = 1; i <= integral.st; i++)
      integral.k[i] = p.k[i-1] / i;
    return PolinomN.izracunaj(a, integral) - PolinomN.izracunaj(b, integral);
  } 
  
  // (d)
  static Polinom obrisiKoeficijente(Polinom p, double granica) {
    if (p == null) 
      return null;
    for (int i = 0; i < p.st; i++) {
      if (Math.abs(p.k[i]) < granica) {
        p.k[i] = 0.0;
      }
    }
    PolinomN.nadjiStepen(p);
    return p;   
  }
 
  public static void main(String[] args) {
    Polinom r;
    
    // (a)
    System.out.print("Unesite broj n: ");
    int n = Svetovid.in.readInt();
    r = new Polinom();
    r.st = 2*n + 1;
    double a = 1.0;
    for (int i = 0; i <= n; i++) {
       r.k[2*i + 1] = a;
       a = -a / (2*i + 2) / (2*i + 3);
    }
    System.out.println();
    System.out.print("Kreirani polinom izgleda ovako: ");
    PolinomN.stampaj(r);
    System.out.println();
    
    // (b)
    System.out.println();
    System.out.print("Unesite broj x: ");
    double x = Svetovid.in.readDouble();
    double razlika = Math.abs(PolinomN.izracunaj(x, r) - Math.sin(x));
    System.out.println();
    System.out.println("Za unetu vrednost " + x + " razlika je: " + razlika);
    
    // (c)
    double vrednost = odredjeniIntegral(r, 0.5, 0.7);
    System.out.println();
    System.out.println("Vrednost odredjenog intervala je: " + vrednost);
                       
    // (d)
    obrisiKoeficijente(r, 0.00001);
    System.out.println();
    System.out.print("Nakon brisanja polinom izgleda ovako: ");
    PolinomN.stampaj(r);
    System.out.println();
  }
}