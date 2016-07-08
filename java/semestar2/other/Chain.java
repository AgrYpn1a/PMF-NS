class Number
{
  int info;
  public Number(int n)
  {
    // initial number
    this.info = n;
  }

  public Number print()
  {
    System.out.println("Number is: " + this.info);
    return this;
  }

  public Number addTo(int n)
  {
    this.info += n; return this;  
  }
}

class Chain
{
  public static void main(String[] args)
  {
    Number myNum = new Number(2);
    myNum.print().addTo(3).print().addTo(2).print();
  }
}
