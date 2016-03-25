/* Napisati program koji za dati ceo broj n, 0 <= n <= 42, ispisuje vrednost
   elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = f_n-1 + f_n-3 - 2f_n-4, n >= 4, poslednja cifra n je >= 5
   f_n = 3f_n-1 - f_n-2 - f_n-4, n >= 4, poslednja cifra n je < 5
   f_3 = 1, f_2 = 2, f_1 = 3, f_0 = 1
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */

class Recurrent6 {

  static final int granica = 42;

  // (a) rekurzivno preko definicije
  static int fRec1(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else if (n == 3)
      return 1;
    else if (n % 10 >= 5)
      return fRec1(n-1) + fRec1(n-3) - 2*fRec1(n-4);
    else
      return 3*fRec1(n-1) - fRec1(n-2) - fRec1(n-4);
  }

  // (b) rekurzivno pomocu akumulirajuceg parametra
  static int ff(int f3, int f2, int f1, int f0, int i, int n) {
    if (i > n)
      return f3;
    else if (i % 10 >= 5)
      return ff(f3+f1-2*f0, f3, f2, f1, i+1, n);
    else
      return ff(3*f3-f2-f0, f3, f2, f1, i+1, n);
  }

  static int fRec2(int n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return 3;
    else if (n == 2)
      return 2;
    else if (n == 3)
      return 1;
    else
      return ff(1, 2, 3, 1, 4, n);
  }

  // (c) iterativno
  static int fIter(int n) {
    int f0, f1, f2, f3, fn;
    fn = 0;
    f0 = 1;
    f1 = 3;
    f2 = 2;
    f3 = 1;
    if (n == 0)
      fn = f0;
    else if (n == 1)
      fn = f1;
    else if (n == 2)
      fn = f2;
    else if (n == 3)
      fn = f3;
    else {
      for (int i = 4; i <= n; i++) {
        if (i % 10 >= 5)
          fn = f3 + f1 - 2*f0;
        else
          fn = 3*f3 - f2 - f0;
        f0 = f1;
        f1 = f2;
        f2 = f3;
        f3 = fn;
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