public class Polinom
{
  class Monom
  {
    double k;
    int st;
    Monom succ;

    // prvi konstruktor sa vrednostima prosledjenim
    public Monom(double k, int st)
    {
      this.k = k;
      this.st = st;
      this.succ = null;
    }

    // defaultni konstruktor
    public Monom()
    {
      this(1.0, 0);
    }

    public String toString()
    {
      String res = "";

      if(this.st != 0)
      {
        if(Math.abs(k) != 1.0)
          res += k;
        else if(k == -1.0)
          res += '-';

        res += 'x';
        if(st != 1)
          res += '^' + st;
      }
      else
        res += k;

      return res;
    }
  }

  /*
   * END MONOM
   */
  // A polynom consists of monoms, thus we have a Single-Linked list of monoms
  Monom first = null;

  // kopija trenutnog polinoma
  public Polinom kopija()
  {
    Polinom kop = new Polinom();

    if(this.first != null)
    {
      // prvi monom u listi resavamo posebno
      kop.first = new Monom();

      // kopiramo poznate parametre za prvi monom
      kop.first.st = this.first.st;
      kop.first.k = this.first.k;
      kop.first.next = null;

      Monom temp = this.first.next;
      Monom curr = kop.first;

      while(temp != null)
      {
        curr.next = new Monom(temp.k, temp.st);
        temp = temp.next;
        curr = curr.next;
      }
    }
    else
      kop.first = null;

    return kop;
  }

  public void ubaciMonom(Monom mon)
  {
    if(mon == null)
      return;

    if(this.first == null)
      this.first = new Monom(mon.k, mon.st);
    else
    {
      Monom curr = this.first;
      Monom last = null;

      while(curr != null && curr.st > mon.st)
      {
        last = curr;
        curr = curr.succ;
      }

      if(curr != null && mon.st == curr.st)
      {
        curr.k = mon.k + curr.k;
        if(curr.k == 0.0)
          if(this.first == curr)
            this.first = curr.succ;
          else
            last.succ = curr.succ;
      }
      else
      {
        Monom kopija = new Monom(mon.k, mon.st);
        kopija.succ = curr;

        if(curr == this.first)
          this.first = kopija;
        else
          last.succ = kopija;  
      }
    }
  }

  public void postaviClan(double k, int st)
  {
    Monom curr, last; // gde je curr trazeni monom

    curr = this.first;
    last = null;

    while(curr != null && curr.st > st)
    {
      last = curr;
      curr = curr.next;
    }

    if(k != 0.0)
    {
      if(curr != null && curr.st == st)
        curr.k = k;
      else
      {
        curr = new Monom();
        curr.k = k;
        curr.st = st;
        curr.next = null;

        if(last == null)
        {
          // polinom je prazan, ili dodajemo na pocetak
          curr.next = this.first;
          this.first = curr;
        }
        else
        {
          curr.next = last.next;
          last.next = curr;
        }
      }
    }
    else
    {
      if(curr != null && curr.st == st)
        if(this.first == curr)
          this.first = this.first.succ;
        else
          last.succ = = last.succ.succ;
    }
  }

  public Polinom monomPuta(Monom mon)
  {
    if(mon != null && this.first != null)
    {
      Polinom mp = new Polinom();
      mp.first = new Monom();
      mp.first.k = this.first.k * mon.k;
      mp.first.st = this.first.st + mon.st;
      Monom pom = this.first.next;
      Monom curr = mp.first;

      while(pom != null)
      {
        curr.succ = new Monom();
        curr.succ.k = pom.k * mon.k;
        curr.succ.st = pom.st + mon.st;
        pom = pom.succ;
        curr = curr.succ;
      }
      return mp;
    }

    return null;
  }


  public Polinom[] kolicnik(Polinom delilac)
  {
    if(delilac != null)
    {
      Polinom ostatak = this.kopija();
      Polinom kolicnik = new Polinom();

      while(ostatak.succ != null && ostatak.succ.st >= delilac.succ.st)
      {

      }
    }
    return null;
  }

}
