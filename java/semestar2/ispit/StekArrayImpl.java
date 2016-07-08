private class Stek
{
  // index of the top element
  private int topEl;

  // array of data
  private Object[] data;

  public static final int DEFAULT_SIZE = 100;

  public Stek(int n)
  {
    topEl = 0;
    data = new Object[n];
  }

  public Stek()
  {
    this(DEFAULT_SIZE);
  }

  public boolean isEmpty()
  {
    return topEl == 0;
  }

  public boolean isFull()
  {
    return topEl = this.data.length;
  }

  public Object top()
  {
    if(this.isEmpty())
      System.out.println("Stek is empty");
    ekse
      return data[topEl - 1];
  }

  public void pop()
  {
    if(isEmpty())
      System.out.println("Stek is empty");
    else
      topEl--;
  }

  public void push(Object x)
  {
    if(this.isFull())
      System.out.println("Stek is full");
    else
    {
      data[topEl] = x;
      topEl++;
    }
  }
}

public class StekArrayImpl
{
  public static void main(String[] args)
  {

  }
}
