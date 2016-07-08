/*
   Napisati klasu Vrtic koja predstavlja listu vaspitaca zaposlenih. Svaka
   vaspitacica ima ime, godine randog staza i lisu sticenika - dece njene grupe.
   Napraviti dodavanje nove v. u listu. Sva imena treba da su razlicita. Dodavanje
   sticenika kod vaspitacice, liste sticenika treba da su sortirane po godinama.

   a) racuna prosek godina muskih sticenika date vaspitacice
   b) brise v. sa datim imenom iz liste, njeni sticenici prelaze kod naredne
   u listi ako ona postoji. (bez zauzimanja nove memorije).
   */
class Vrtic
{
  // lista koja sadrzi vaspitace(vaspitacice, radi jednostavnosti pisanja neka bude muski pol)
  public Vaspitac head;

  public Vrtic()
  {
    this.head = null;
  }

  /*
   * Naredne metode su tipa Vrtic, ovo radim da bih mogao da chainujem metode,
   * ovo nije obavezno, mogu da budu tipa void, ali volim da pisem ovako, jer ono
   * sto se dobija jeste sledece
   * Vrtic v = new Vrtic();
   *
   * v.ucitajIzFajla().print().dodaj();
   *
   * i tako dalje, odnosno nadovezujem emtodu na metodu, sto ume da bude korisno i skracuje
   * pisanje.
   *
   * Ono sto se zapravo desava, jeste da mi kada izvrsimo metodu, vratimo istu klasu
   * i nad njom opet pozovemo metodu
   *
   * mozda valja staviti zagrade za pocetak ako nije jasno sta se tacno desava
   * recimo neki objekat obj
   *
   * ((obj.a()).b()).c() i tako dalje, ono sto je u zagradi kada se izvrsi metoda
   * zapravo jeste objekat nase klase jer metoda vraca njega nazad, ako ne bismo pozvali
   * metodu nad njim, on bi ostao da visi
   *
   * ovo je ekvivalentno sledecem:
   *
   * Klasa obj = new Klasa();
   * Klasa obj1 = new Klasa();
   *
   * obj1 = obj.a();
   * obj1.b();
   *
   * znaci mi samo vracamo taj isti objekat i nad njim mozemo da pozovemo novu metodu opet
   *
   * ovo radi zato sto i sledece radi:
   *
   * (new Klasa()).metoda();
   *
   */
  private boolean postoji(String ime)
  {
    Vaspitac v = this.head;
    while(v != null && !ime.equals(v.ime))
      v = v.next;

    // sada samo pitamo da li je v null, 
    // jer ako jeste to znaci da smo dosli do kraja liste
    // i da vaspitac sa zadatim imenom ne postoji
    //
    // ternarni operator, 
    // return a ? b : c;
    // ako je uslov a tacan vraca b, u suprotnom vraca c
    return v == null ? false : true;
  }

  public Vrtic dodaj(String ime)
  {
    /*
     * Ovo je trivijalno, s tim da imamo jednu proveru
     * da li vaspitac sa imenom vec postoji, a ovo cemo odvojiti
     * u posebnu metodu, radi jednostavnosti koda
     */

    // ako postoji, samo izlazimo iz metode
    // ali moramo da vratimo this, odnosno sam objekat iz kog se izvrsava metoda
    // radi chainovanja, u suprotnom ako je metoda tipa void samo return; pisemo
    if(postoji(ime))
      return this;

    // dodajemo na pocetak, jer tako je najjednostavnije a nije naglaseno drugacije
    // ovde jos uvek ne vodimo racuna o sortiranju, ono je bitno samo za sticenike
    Vaspitac v = new Vaspitac(ime);

    v.next = this.head;
    this.head = v;

    return this;
  }

  public Vrtic dodajSticenika(String imeV, String ime, int starost, int pol)
  {
    // moramo da proverimo da li vaspitac postoji
    if(!postoji(imeV))
      return this;

    Vaspitac v = this.head;

    // posto smo implementirali metodu dodaj u klasi vaspitac, ovo je trivijalno
    // kada nadjemo vaspitaca sa zadatim imenom, samo pozovemo metodu dodaj i prosledimo
    // odgovarajuce parametre
    while(v != null)
    {
      if(imeV.equals(v.ime))
        v.dodaj(ime, starost, pol);
      v = v.next;
    }

    return this;
  }

  // b)
  public Vrtic ukloni(String ime)
  {
    // prvo treba da pronadjemo trazenog vaspitaca
    Vaspitac tVasp = null;
    Vaspitac v = this.head;
    Vaspitac pV = null;

    while(v.next != null && !v.ime.equals(ime))
    {
      pV = v;
      v = v.next;
    }

    if(v != null)
      tVasp = v;
    else
    {
      System.out.println("Trazeni vaspitac ne postoji!");
      return this;
    }

    // sada kada smo nasli vaspitaca, ako postoje sticenici
    // treba ih prevezati na sledeceg, ako on postoji
    if(tVasp.next != null)
    {
      // postoji, sada nas zanima da li vaspitac ima sticenika
      if(tVasp.head != null)
      {
        // ima, pa sada treba spojiti dve liste, ovo je otprilike najteze
        //
        Vaspitac.Sticenik s1 = tVasp.head;
        Vaspitac.Sticenik s2 = tVasp.next.head;
        Vaspitac.Sticenik p = null, p2 = null; // moramo da pamtimo i prethodnog radi uvezivanja

        // opet zaseban poseban slucaj, dodavanje na pocetak, 
        // kako je head uvek najstariji, sve dok nailazimo na starije dodajemo ih na head
        // dodajemo u s2
        while(s1.next != null) 
        {
          p = s1;
          s1 = s1.next;

          if(s2.starost <= s1.starost)
          {
            s1.next = s2;
            s2 = s1;

            // prevezujemo
            p.next = p.next.next;
            s1 = p;
          }
        }

        if(s1 == null)
          return this;

        p = null;

        // sada dodajemo preostale iz s1 u s2
        while(s1.next != null)
        {
          p2 = s1;
          s1 = s1.next;

          while(s2.next != null && s1.starost <= s2.starost)
          {
            p = s2;
            s2 = s2.next;
          }

          // ista provera kao kod dodavanja sticenika
          if(s2.next != null)
          {
            p.next = s1;
            s1.next = s2;

            p2.next = p.next.next;
          }
          else
          {
            // u suprotnom dodajemo na kraj
            s1.next = s2.next;
            s2 = s1;
            p2.next = p2.next.next;
          }
          // resetujemo s2 i idemo dalje kroz s1
          s2 = v.next.head;
        }

        // end of while
        //
      }
    }
    pV.next = pV.next.next;
    return this;
  }

  // zadatak zahteva da implementiramo toString() metode
  public String toString()
  {
    if(this.head == null)
      return "Lista je prazna!";

    Vaspitac v = this.head;

    String str = "[ ";
    while(v != null)
    {
      str += "\n" + v.ime + "\n\t" + v + "\n";
      v = v.next;
    }
    str += "]";
    return str;
  }

  class Vaspitac
  {
    String ime;
    // lista sticenika
    Sticenik head;
    Vaspitac next;

    public Vaspitac(String ime)
    {
      this.ime = ime;
      this.head = null;
      this.next = null;
    }

    public String toString()
    {
      if(this.head == null)
        return "Vaspitac nema sticenika!";

      Sticenik s = this.head;

      String str = "[ ";
      while(s != null)
      {
        str += s.ime + " ";
        s = s.next;
      }
      str += "]";
      return str;
    }

    private boolean postoji(String ime)
    {
      Sticenik s = this.head;
      while(s != null && !ime.equals(s.ime))
        s = s.next;

      return s == null ? false : true;
    }

    // sada nema potrebe da chainujemo metode,
    // jer ne radimo sa ovom klasom iz main-a
    public void dodaj(String ime, int starost, int pol)
    {
      // pre svega nam je potrebno da pronadjemo odgovarajuce mesto
      // za naseg novog sticenika, zbog toga sto oni moraju biti sortirani
      //
      // pre toga, proveravamo da li on vec postoji
      if(postoji(ime))
        return;

      Sticenik s = new Sticenik(ime, starost, pol);

      // prvo resavamo trivijalan slucaj, kada je lista prazna
      if(this.head == null)
      {
        s.next = this.head;
        this.head = s;
        return; // izlazimo iz metode, jer nema potrebe da proveravamo dalje
      }

      // posebno treba proveriti, u slucaju kada je novi sticenik stariji od prvog (head)
      // u listi
      // ovo radimo iz razloga, sto moramo da pomeramo head tj uvek dodajemo na pocetak
      if(this.head.starost >= starost)
      {
        s.next = this.head;
        this.head = s;
        return;
      }

      // u slucaju da se nas sticenik nalazi negde u sredini liste,
      // moramo da znamo gde je tacno, pa stoga pamtimo prethodnika
      // da bi mogli da ga uvezemo na odgovarajuce mesto
      Sticenik t = this.head; // trenutni
      Sticenik p = null; // prethodni

      // sada prolazimo kroz listu while petljom, dok ne naidjemo na sticenika koji je stariji od naseg
      // kada ga pronadjemo, hocemo da dodamo novog sticenika izmedju njega i prethodnika
      while(t.next != null && t.starost <= starost)
      {
        p = t;
        t = t.next;
      }

      // sada treba da proverimo da li je t == null
      // ako nije uvezujemo sticenika izmedju dva, a ako jeste
      // onda samo dodajemo sticenika na kraj
      if(t.next != null)
      {
        System.out.println("t: " + t.next);
        p.next = s;
        s.next = t;
      }
      else
      {
        s.next = t.next;
        t.next = s;
      }
    }

    class Sticenik
    {
      String ime;
      int starost; // liste sticenika treba da budu sortirane po starosti
      int pol; // 1 za muski 0 za zenski

      Sticenik next;
      public Sticenik(String ime, int starost, int pol)
      {
        this.ime = ime;
        this.starost = starost;
        this.next = null;
        this.pol = pol;
      }
    }
  }
}

// ovo je glavna klasa kojas sadrzi main metodu, nisam smisio neko pametnije ime
class Example
{
  public static void main(String[] args)
  {
    Vrtic v = new Vrtic();

    ucitajVaspitace(v, "vaspitaci.txt");
    System.out.println(v);

    ucitajSticenike(v, "sticenici.txt");
    System.out.println(v);

    // prosek je jednostavan za racunanje, sve sto treba uraditi jeste proci kroz listu
    // proveriti da li je sticenik muskog pola ako jeste povecati brojac, i povecati ukupne godine
    // na kraju samo podeliti ukupne godine sa brojacem
    //
    // b) 
    v.ukloni("Marija");    
    System.out.println("\n\n\nNakon sto smo uklonili neke: \n" + v);
  }

  // ucitavamo iz fajla radi testiranja
  private static void ucitajVaspitace(Vrtic v, String fn)
  {
    if(!Svetovid.testIn(fn))
      return;

    System.out.println("Ucitavam vaspitace...");

    while(Svetovid.in(fn).hasMore())
      v.dodaj(Svetovid.in(fn).readLine());

    Svetovid.in(fn).close();
  }

  private static void ucitajSticenike(Vrtic v, String fn)
  {
    if(!Svetovid.testIn(fn))
      return;

    System.out.println("Ucitavam sticenike...");
    while(Svetovid.in(fn).hasMore())
      v.dodajSticenika(Svetovid.in(fn).readToken(), 
                       Svetovid.in(fn).readToken(), 
                       Svetovid.in(fn).readInt(), 
                       Svetovid.in(fn).readInt());

    Svetovid.in(fn).close();
  }
}
