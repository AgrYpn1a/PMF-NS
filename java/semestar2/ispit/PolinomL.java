/**
 *  * Polinom predstavljen listom monoma od kojih je svaki predstavljen svojim
 *   * koeficijentom (tipa double) i stepenom (tipa int).
 *    * 
 *     * U listi su monomi poredjani od najviseg do najnizeg stepena i svi monomi su
 *      * razlicitog stepena. Monomi kojima je koeficijent jednak nula se ne cuvaju u
 *       * listi.
 *        *
 *         * Pomocni materijal za SPA1, DMI, PMF, UNS
 *          * v1.0.1
 *           */
public class PolinomL {

  /**
   *   * Predstavlja jedan monom, odnosno njegov koeficijent i stepen, u listi
   *     * monoma u polinomu.
   *       */
  class Monom {
    double k;
    int st;
    Monom veza;

    public Monom(double k, int st) {
      this.k = k;
      this.st = st;
      this.veza = null;
    }

    public Monom() {
      this(1.0, 0);
    }

    public String toString() {
      String res = "";
      if (st != 0) {
        if (Math.abs(k) != 1.0) {
          res += k;
        } else if (k == -1.0) {
          res += '-';
        }
        res += 'x';
        if (st != 1) {
          res += "^" + st;
        }
      } else {
        res += k;
      }
      return res;
    }
  }

  /** pokazivac na prvi monom u listi monoma */
  Monom prvi = null;

  public String toString() {
    String res = "";
    if (prvi == null)
      res += 0.0;
    else {
      res += prvi;
      Monom pom = prvi.veza;
      while (pom != null) {
        if (pom.k > 0)
          res += "+" + pom;
        else
          res += pom;
        pom = pom.veza;
      }
    }
    return res;
  }

  /** Vraca nezavisnu kopiju tekuceg polinoma. */
  public PolinomL kopija() {
    PolinomL kopija = new PolinomL();
    if (prvi != null) {
      kopija.prvi = new Monom();
      kopija.prvi.st = prvi.st;
      kopija.prvi.k = prvi.k;
      kopija.prvi.veza = null;
      Monom pomocni = prvi.veza;
      Monom tekuci = kopija.prvi;
      while (pomocni != null) {
        tekuci.veza = new Monom(pomocni.k, pomocni.st);
        pomocni = pomocni.veza;
        tekuci = tekuci.veza;
      }
    } else
      kopija.prvi = null;
    return kopija;
  }

  /** Ubacuje kopiju monoma mon u tekuci polinom. */
  public void ubaciMonom(Monom mon) {
    if (mon != null) {
      if (prvi == null) {
        prvi = new Monom(mon.k, mon.st);
      } else {

        Monom tekuci = prvi;
        Monom stari = null;

        while (tekuci != null && tekuci.st > mon.st) {
          stari = tekuci;
          tekuci = tekuci.veza;
        }

        if (tekuci != null && mon.st == tekuci.st) {
          tekuci.k = mon.k + tekuci.k;
          if (tekuci.k == 0.0) {
            if (prvi == tekuci)
              prvi = tekuci.veza;
            else
              stari.veza = tekuci.veza;
          }
        } else {
          Monom kopija = new Monom(mon.k, mon.st);
          kopija.veza = tekuci;

          if (tekuci == prvi) {
            prvi = kopija;
          } else {
            stari.veza = kopija;
          }
        }
      }
    }
  }

  /** Postavlja clan monoma na dati koeficijent, pri cemu se po potrebi menja postojeci monom, 
   *   * kreira novi monom ili brise monom. */
  public void postaviClan(double k, int st) {
    Monom cilj, prethodni;
    cilj = prvi;
    prethodni = null;
    while (cilj != null && cilj.st > st) {
      prethodni = cilj;
      cilj = cilj.veza;
    }
    /* da li upisujemo vrednost ili sklanjamo clan */
    if (k != 0.0) {
      /* da li menjamo clan ili pravimo novi */
      if (cilj != null && cilj.st == st) {
        cilj.k = k;
      } else {
        cilj = new Monom();
        cilj.k = k;
        cilj.st = st;
        cilj.veza = null;
        if (prethodni == null) {
          /* ili je prazan polinom, ili dodajemo na pocetak */
          cilj.veza = prvi;
          prvi = cilj;
        } else {
          cilj.veza = prethodni.veza;
          prethodni.veza = cilj;
        }
      }
    } else {
      /* da li postoji ovakav clan - brisemo ga */
      if (cilj != null && cilj.st == st) {
        if (prvi == cilj)
          prvi = prvi.veza;
        else {
          prethodni.veza = prethodni.veza.veza;
        }
      }
    }
  }

  /** Vraca koeficijent uz monom zadat stepenom. */
  public double koeficijentUz(int st) {
    if (prvi != null) {
      Monom tekuci = prvi;
      while (tekuci != null && tekuci.st > st) {
        tekuci = tekuci.veza;
      }
      if (tekuci != null && tekuci.st == st) {
        return tekuci.k;
      } else
        return 0.0;
    } else
      return 0.0;
  }

  /** Vraca stepen polinoma. */
  public int maksimalniStepen() {
    if (prvi != null)
      return prvi.st;
    else
      return 0;
  }

  /** Trazi od korisnika da unese novi polinom koji ce biti ubacen u tekuci. */
  public void unos() {
    int n;
    try {
      do {
        System.out.print("Unesite broj monoma n (n>=0) ");
        n = Svetovid.in.readInt();
      } while (n < 0);
      for (int i = 1; i <= n; i++) {
        Monom novi = new Monom();
        do {
          System.out.print("Unesite koeficijent monoma br. " + i + ": ");
          novi.k = Svetovid.in.readDouble();
        } while (novi.k == 0);
        do {
          System.out.print("Unesite eksponent monoma br. " + i + ": ");
          novi.st = Svetovid.in.readInt();
        } while (novi.st < 0);
        ubaciMonom(novi);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Vraca novi polinom koji je jednak zbiru polinoma p2 i ovog polinoma. */
  public PolinomL saberi(PolinomL p2) {
    PolinomL zbir = kopija();
    if (p2 != null) {
      Monom pom = p2.prvi;
      while (pom != null) {
        zbir.ubaciMonom(pom);
        pom = pom.veza;
      }
    }
    return zbir;
  }

  /** Dodaje polinom p na tekuci polinom. */
  public void saberiNa(PolinomL p) {
    if (p != null) {
      Monom pom = p.prvi;
      while (pom != null) {
        ubaciMonom(pom);
        pom = pom.veza;
      }
    }
  }

  /** Menja znak tekucem polinomu. */
  public void promeniZnak() {
    Monom pom = prvi;
    while (pom != null) {
      pom.k = -pom.k;
      pom = pom.veza;
    }
  }

  /** Vraca novi polinom koji je jednak razlici izmedju tekuceg polinoma i p2.*/
  public PolinomL oduzmi(PolinomL p2) {
    if (p2 == null) {
      return this.kopija();
    }

    PolinomL razlika = p2.kopija();
    razlika.promeniZnak();
    Monom pom = prvi;
    while (pom != null) {
      razlika.ubaciMonom(pom);
      pom = pom.veza;
    }
    return razlika;
  }

  /** Vraca novi polinom koji je jednak ovom polinomu pomonomenom sa monom mon. */
  public PolinomL monomPuta(Monom mon) {
    if (mon != null && prvi != null) {
      PolinomL mp = new PolinomL();
      mp.prvi = new Monom();
      mp.prvi.k = prvi.k * mon.k;
      mp.prvi.st = prvi.st + mon.st;
      Monom pom = prvi.veza;
      Monom tekuci = mp.prvi;
      while (pom != null) {
        tekuci.veza = new Monom();
        tekuci.veza.k = pom.k * mon.k;
        tekuci.veza.st = pom.st + mon.st;
        pom = pom.veza;
        tekuci = tekuci.veza;
      }
      return mp;
    }
    return null;
  }

  /** Vraca novi polinom koji je jednak proizvodu tekuceg polinoma sa p2. */
  public PolinomL puta(PolinomL p2) {
    if (p2 != null && prvi != null) {
      PolinomL pr = monomPuta(p2.prvi);
      Monom pom = p2.prvi.veza;
      while (pom != null) {
        PolinomL pomocni = monomPuta(pom);
        Monom pomocniMon = pomocni.prvi;
        do {
          pr.ubaciMonom(pomocniMon);
          pomocniMon = pomocniMon.veza;
        } while (pomocniMon != null);
        pom = pom.veza;
      }
      return pr;
    } else
      return null;
  }

  /**
   *   * Vraca niz dva polinoma od koji prvi predstavlja kolicnik, a drugi ostatak pri deljenju
   *     * tekuceg polinom sa prosledjenim polinomom `delilac`. 
   *       */
  public PolinomL[] kolicnik(PolinomL delilac) {
    if (delilac != null) {
      PolinomL ostatak = this.kopija();
      PolinomL kolicnik = new PolinomL();

      while (ostatak.prvi != null && ostatak.prvi.st >= delilac.prvi.st) {
        Monom novi = new Monom();
        novi.k = -ostatak.prvi.k / delilac.prvi.k;
        novi.st = ostatak.prvi.st - delilac.prvi.st;
        PolinomL pomocni = delilac.monomPuta(novi);
        ostatak.saberiNa(pomocni);
        novi.k = -novi.k;
        kolicnik.ubaciMonom(novi);
      }

      PolinomL[] rez = { kolicnik, ostatak };
      return rez;
    }
    return null;
  }

  /** Vraca novi polinom koji je jedank tekucem polinomu podignutom na stepen n. */
  public PolinomL polinomNaN(int n) {
    PolinomL rez;
    if (n == 0) {
      rez = new PolinomL();
      rez.prvi = new Monom(1.0, 0);
    } else {
      rez = this.kopija();
      for (int i = 2; i <= n; i++) {
        PolinomL pret = rez;
        rez = puta(pret);
      }
    }
    return rez;
  }

}

