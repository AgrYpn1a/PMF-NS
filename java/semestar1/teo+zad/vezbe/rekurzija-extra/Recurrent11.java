/* Napisati program koji za date cele brojeve n, 0 <= n <= 30, i r, 5 <= r <= 20,
   ispisuje vrednost elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = f_n-2 - g_n-1 + f_n-r+1 - g_n-r, n >= r, n je neparno
   f_n = -f_n-1 + g_n-1 - g_n-2 - f_n-r + g_n-r,  n >= r, n je parno
   g_n = 2g_n-1 - 2f_n-r + g_n-r+1,  n >= r
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */

class Recurrent11 {

  static final int maxN = 30;
  static final int maxR = 20;

  // (a) rekurzivno preko definicije
  static int fRec1(int n, int r) {
    if (n < r)
      return 2;
    else if (n % 2 == 1)
      return fRec1(n-2, r) - gRec1(n-1, r) + fRec1(n-r+1, r) - gRec1(n-r, r);
    else
      return -fRec1(n-1, r) + gRec1(n-1, r) - gRec1(n-2, r) - fRec1(n-r, r) + gRec1(n-r, r);
  }

  static int gRec1(int n, int r) {
    if (n < r)
      return -1;
    else
      return 2*gRec1(n-1, r) - 2*fRec1(n-r, r) + gRec1(n-r+1, r);
  }

  // (b) rekurzivno pomocu akumulirajuceg parametra
  static int ff(int f[], int g[], int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      if (i % 2 == 1)
        f[r] = f[r-2] - g[r-1] + f[1] - g[0];
      else
        f[r] = -f[r-1] + g[r-1] - g[r-2] - f[0] + g[0];
      g[r] = 2*g[r-1] - 2*f[0] + g[1];
      for (int j = 0; j < r; j++) {
        f[j] = f[j+1];
        g[j] = g[j+1];
      }
      return ff(f, g, i+1, n, r);
    }
  }

  static int fRec2(int n, int r) {
    int f[] = new int[maxR + 1];
    int g[] = new int[maxR + 1];
    if (n < r)
      return 2;
    else {
      for (int j = 0; j < r; j++) {
        f[j] = 2;
        g[j] = -1;
      }
      return ff(f, g, r, n, r);
    }
  }

  // (c) iterativno
  static int fIter(int n, int r) {
    int f[] = new int[maxR + 1];
    int g[] = new int[maxR + 1];
    for (int i = 0; i < r; i++) {
      f[i] = 2;
      g[i] = -1;
    }
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        if (i % 2 == 1)
          f[r] = f[r-2] - g[r-1] + f[1] - g[0];
        else
          f[r] = -f[r-1] + g[r-1] - g[r-2] - f[0] + g[0];
        g[r] = 2*g[r-1] - 2*f[0] + g[1];
        for (int j = 0; j < r; j++) {
          f[j] = f[j+1];
          g[j] = g[j+1];
        }
      }
    }
    return f[r];
  }

  public static void main(String[] args) {
    System.out.print("Unesite n (0 <= n <= " + maxN + "): ");
    int n = Svetovid.in.readInt();
    System.out.print("Unesite r (5 <= r <= " + maxR + "): ");
    int r = Svetovid.in.readInt();
    if (0 <= n && n <= maxN && 5 <= r && r <= maxR) {
      System.out.println("fRec1(n, r) = " + fRec1(n, r));
      System.out.println("fRec2(n, r) = " + fRec2(n, r));
      System.out.println("fIter(n, r) = " + fIter(n, r));
    }
    else {
      System.out.println("n i/ili r je van dozvoljenih granica");
    }
  }
}