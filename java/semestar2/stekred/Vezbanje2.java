class Vezbanje2 {
  public static void main (String [] args) {
    Red<Integer> red=new Red<Integer>();
    Red<Integer> redA=new Red<Integer>();
    Red<Integer> redB=new Red<Integer>();

    red=ucitavanje("fajl.txt");

    ukloniParne(red);

    napravi(red, redA, redB);
    System.out.println(red);
  }

  public static void napravi(Red<Integer> red, Red<Integer> redA, Red<Integer> redB) {
    while (!red.jePrazan()) {
      int prvi=red.prvi();
      if (prvi % 2 == 0)
        redA.naKraj(prvi);
      else
        redB.naKraj(prvi);
      red.izbaciPrvi();
    }
  }

  public static void ukloniParne (Red<Integer> r) {
    int prvi=r.prvi();
    while (prvi%2==0 &&  !r.jePrazan()) {
      r.izbaciPrvi();
      prvi=r.prvi();
    }
  }

  public static Red<Integer> ucitavanje (String imef) {
    Red<Integer> rez=new Red<Integer>();
    if (Svetovid.testIn(imef)) {
      while(Svetovid.in(imef).hasMore()) {
        rez.naKraj(Svetovid.in(imef).readInt());
      }
      Svetovid.in(imef).close();
    }
    return rez;
  }

}
