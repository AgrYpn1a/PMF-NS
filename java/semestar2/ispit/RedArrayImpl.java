class Red
{
  private int first, last;
  private Object[] data;

  public static final int DEFAULT_SIZE = 100;

  public Red(int n)
  {
    first = -1;
    last = -1;
    data = new Object[n];
  }

  public Red()
  {
    this(DEFAULT_SIZE);
  }

  /**
   * Helper method to keep the array index in range, always returns next of
   * the one that is recieved via arguments
   * Every next one, is higher than the last by 1 place except for the last one,
   * where the next one is first one.
   */
  private int addOne(int i)
  {
    return (i + 1) % data.length;
  }

  public void popFirst()
  {
    if(isEmpty())
      System.out.println("Is empty");
    else if(this.first == this.last)
    {
      this.first = -1;
      this.last = -1;
    }
    else
      this.first = addOne(first);
  }
}

public class RedArrayImpl
{
  public static void main(String[] args)
  {

  }
}
