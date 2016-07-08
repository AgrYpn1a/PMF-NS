class CSLL
{
  CSLLNode last;

  public CSLL()
  {
    this.last = null;
  }

  public class CSLLNode
  {
    int info;
    CSLLNode next;
    public CSLLNode(int info)
    {
      this.info = info;
      this.next = null;
    }
  }

  public CSLL insertFirst(int info)
  {
    CSLLNode node = new CSLLNode(info);

    if(this.last == null)
    {
      node.next = node;
      this.last = node;
    }
    else
    {
      node.next = this.last.next;
      this.last.next = node;
    }
    return this;
  }

  public CSLL insertLast(int info)
  {
    CSLLNode node = new CSLLNode(info);

    if(this.last == null)
    {
      node.next = node;
    }
    else
    {
      node.next = this.last.next;
      this.last.next = node;
    }
    this.last = node;
    return this;
  }

  public CSLL print()
  {

    if(this.last != null)
    {
      CSLLNode curr = this.last.next;

      System.out.print("[ ");
      while(curr != this.last)
      {
        System.out.print(curr.info + " ");
        curr = curr.next;
      }
      System.out.print(curr.info + " ");

      System.out.print("]");
      System.out.println();
    }
    else
      System.out.println("List is empty!");
    return this;
  }

  public CSLLNode find(int info)
  {
    if(this.last == null)
      return null;

    CSLLNode curr = this.last.next;
    while(curr != this.last && 
        info != curr.info)
      curr = curr.next;
 
    return curr.info == info ? curr : null; 
  }
}

public class CSLLProblem
{
  public static void main(String[] args)
  {
    CSLL csll = new CSLL();

    System.out.println(csll.insertFirst(1).insertLast(2).insertLast(3).insertFirst(10).print().find(10));
  }
}
