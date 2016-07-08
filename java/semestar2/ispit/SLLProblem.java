class SLL
{
  // constructor

  SLLNode first;
  public SLL()
  {
    this.first = null;
  }

  public class SLLNode
  {
    int info;
    SLLNode next;

    public SLLNode(int info)
    {
      this.info = info;
      this.next = null;
    }
  }

  // we want a sorted SLL
  public SLL add(int info)
  {
    /*
     * Four cases;
     *
     * 1) List is empty
     * 2) Adding before first
     * 3) If first is the only element, adding after
     * 4) Adding somewhere in list
     *
     */
    SLLNode node = new SLLNode(info);

    if(this.first == null)
      this.first = node;
    else if(node.info <= this.first.info)
    {
      node.next = this.first;
      this.first = node;
    }
    else if(this.first.next == null)
      this.first.next = node;
    else
    {
      // final case, when we have to insert it somewhere in the middle
      SLLNode curr = this.first;

      while(curr.next.next != null &&
          node.info > curr.info)
        curr = curr.next;

      if(curr.next.info >= node.info)
      {
        // ako ispadnemo iz petlje zbog uslova node.info > curr.info
        node.next = curr.next;
        curr.next = node;
      }
      else
        // u suprotnom, izasli smo iz liste
        curr.next.next = node;

    }

    return this;
  }

  public SLL print()
  {
    if(this.first == null)
      System.out.println("List is empty!");

    SLLNode temp = this.first;
    System.out.println();
    System.out.print("[ ");

    while(temp != null)
    {
      System.out.print(temp.info + " ");
      temp = temp.next;
    }

    System.out.print("]");
    System.out.println();
    return this;
  }

  public boolean find(int info)
  {
    SLLNode curr = this.first;

    while(curr != null && info > curr.info)
      curr = curr.next;
    
    return curr != null && curr.info == info ? true : false;
  }
}

public class SLLProblem
{
  public static void main(String[] args)
  {
    SLL sll = new SLL();
    sll.add(3).add(1).add(2).add(5).add(3).print();
    System.out.println(sll.find(5));

  }
}
