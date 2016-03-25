/* Napisati program koji za date cele brojeve n, 0 <= n <= 40, i r, 1 <= r <= 10,
   ispisuje vrednost elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = f_n-1 + f_n-2 + ... + f_n-r, n >= r
   f_n = n, 0 <= n < r
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */

class Recurrent10 {

  static final int maxN = 40;
  static final int maxR = 10;

  // (a) rekurzivno preko definicije
  static int fRec1(int n, int r) {
    if (n < r)
      return n;
    else {
      int fn = 0;
      for (int i = 1; i <= r; i++) 
        fn = fn + fRec1(n-i, r);
      return fn;
    }
  }

  // (b) rekurzivno pomocu akumulirajuceg parametra
  static int ff(int f[], int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      f[r] = 0;
      for (int j = 1; j <= r; j++) 
        f[r] = f[r] + f[r-j];
      for(int j = 0; j < r; j++) 
        f[j] = f[j+1];
      return ff(f, i+1, n, r);
    }
  }

  static int fRec2(int n, int r) {
    int f[] = new int[maxR + 1];
    if (n < r)
      return n;
    else {
      for (int j = 0; j < r; j++) 
        f[j] = j;
      return ff(f, r, n, r);
    }
  }

  // (c) iterativno
  static int fIter(int n, int r) {
    int f[] = new int[maxR + 1];
    for (int i = 0; i < r; i++) 
      f[i] = i;
    if (n < r)
      return f[n];
    else {
      for (int i = r; i <= n; i++) {
        f[r] = 0;
        for (int j = 1; j <= r; j++) 
          f[r] = f[r] + f[r-j];
        for (int j = 0; j < r; j++)  
          f[j] = f[j+1];
      }
    }
    return f[r];
  }

  public static void main(String[] args) {
    System.out.print("Unesite n (0 <= n <= " + maxN + "): ");
    int n = Svetovid.in.readInt();
    System.out.print("Unesite r (1 <= r <= " + maxR + "): ");
    int r = Svetovid.in.readInt();
    if (0 <= n && n <= maxN && 1 <= r && r <= maxR) {
      System.out.println("fRec1(n, r) = " + fRec1(n, r));
      System.out.println("fRec2(n, r) = " + fRec2(n, r));
      System.out.println("fIter(n, r) = " + fIter(n, r));
    }
    else {
      System.out.println("n i/ili r je van dozvoljenih granica");
    }
  }
}