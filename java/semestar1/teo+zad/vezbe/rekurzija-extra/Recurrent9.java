/* Napisati program koji za dati ceo broj n, 0 <= n <= 25, ispisuje vrednost
   elementa rekurentnog niza realnih brojeva f_n. Niz je definisan na sledeci nacin:
   f_n = 2f_n-1 / g_n-2 + f_n-2 / g_n-3, n >= 3, n parno
   f_n = g_n-1 / f_n-2 + 2g_n-2 / f_n-3, n >= 3, n neparno
   g_n = g_n-1 / f_n-1 + g_n-2 / f_n-2 + g_n-3 / f_n-3, n >= 3
   f_2 = 1, f_1 = 3, f_0 = 1
   g_2 = 2, g_1 = 2, g_0 = 2
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */

class Recurrent9 {

  static final int granica = 25;

  // (a) rekurzivno preko definicije
  static double fRec1(int n) {
    if (n == 0 || n == 2)
      return 1.0;
    else if (n == 1)
      return 3.0;
    else if (n % 2 == 1)
      return gRec1(n-1) / fRec1(n-2) + 2.0 * gRec1(n-2) / fRec1(n-3);
    else
      return 2.0 * fRec1(n-1) / gRec1(n-2) + fRec1(n-2) / gRec1(n-3);
  }

  static double gRec1(int n) {
    if (n <= 2)
      return 2.0;
    else
      return gRec1(n-1) / fRec1(n-1) + gRec1(n-2) / fRec1(n-2) + gRec1(n-3) / fRec1(n-3);
  }

  // (b) rekurzivno pomocu akumulirajuceg parametra
  static double fg(double f2, double f1, double f0, double g2, double g1, double g0, int i, int n) {
    if (i > n)
      return f2;
    else if (i % 2 == 1)
      return fg(g2/f1+2.0*g1/f0, f2, f1, g2/f2+g1/f1+g0/f0, g2, g1, i+1, n);
    else
      return fg(2.0*f2/g1+f1/g0, f2, f1, g2/f2+g1/f1+g0/f0, g2, g1, i+1, n);
  }

  static double fRec2(int n) {
    if (n == 0 || n == 2)
      return 1.0;
    else if (n == 1)
      return 3.0;
    else
      return fg(1.0, 3.0, 1.0, 2.0, 2.0, 2.0, 3, n);
  }

  // (c) iterativno
  static double fIter(int n) {
    double f0, f1, f2, fn, g0, g1, g2, gn;
    fn = 0.0;
    f0 = 1.0;
    f1 = 3.0;
    f2 = 1.0;
    g0 = 2.0;
    g1 = 2.0;
    g2 = 2.0;
    if (n == 0)
      fn = f0;
    else if (n == 1)
      fn = f1;
    else if (n == 2)
      fn = f2;
    else {
      for (int i = 3; i <= n; i++) {
        if (i % 2 == 1) {
          fn = g2/f1 + 2.0*g1/f0;
          gn = g2/f2 + g1/f1 + g0/f0;
        }
        else {
          fn = 2.0*f2/g1 + f1/g0;
          gn = g2/f2 + g1/f1 + g0/f0;
        }
        f0 = f1;
        f1 = f2;
        f2 = fn;
        g0 = g1;
        g1 = g2;
        g2 = gn;
      }
    }
    return fn;
  }

  public static void main(String[] args) {
    System.out.print("Unesite n (0 <= n <= " + granica + "): ");
    int n = Svetovid.in.readInt();
    if (0 <= n && n <= granica) {
      System.out.println("fRec1(n) = " + fRec1(n));
      System.out.println("fRec2(n) = " + fRec2(n));
      System.out.println("fIter(n) = " + fIter(n));
    }
    else {
      System.out.println("n je van dozvoljenih granica");
    }
  }
}