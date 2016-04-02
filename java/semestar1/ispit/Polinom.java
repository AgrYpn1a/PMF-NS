class Polinom
{
  static final int maxSt = 100;
  public double[] k = new double[maxSt + 1];
  public int st = -1;

  // chainable methods
  public Polinom anuliraj()
  {
    for(int i=0; i<maxSt; i++)
      this.k[i] = 0.0;
    this.st = -1;
    return this;
  }

  public Polinom kopiraj()
  {
    Polinom temp = new Polinom();
    temp.st = this.st;
    for(int i=0; i<this.st; i++)
      temp.k[i] = this.k[i];

    return temp;
  }

  public Polinom nadjiStepen()
  {
    this.st = maxSt;
    final double eps = 1.0E-5;
    while(this.st > -1 && Math.abs(this.k[this.st]-0.0) < eps)
    {
      // pri poredjenju sa nulom, pitamo se da li je koef.
      // dovoljno blizu nule
      this.st--;
    }
    return this;
  }

  public Polinom[] deli(Polinom p)
  {
    if(p == null || p.st = -1)
      return null;
    
    Polinom ostatak = this.kopiraj();
    Polinom kolicnik = new Polinom();

    int j;

    if(this.st >= p.st)
    {
      kolicnik.st = this.st - p.st;
      for(int i = this.st; i>=p.st; i--)
        kolicnik.k[i-p.st] = ostatak.k[i] / p.k[p.st];
        for(int j=0; j<=p.st; j++)
          ostatak.k[j+i-p.st] -= kolicnik.k[i-p.st] * p.k[j];

        ostatak.nadjiStepen();
    }
    Polinom[] rez = {kolicnik, ostatak};
    return rez;
  }
}
