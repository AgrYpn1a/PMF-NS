class List
{
  class ListElement
  {
    public int info;
    public ListElement next;

    public ListElement(int info)
    {
      this.info = info;
      this.next = null;
    }

    public String toString()
    {
      return info + "";
    }
  }

  public ListElement head;

  public List()
  {
    this.head = null;
  }

  public void add(int info)
  {
    ListElement e = new ListElement(info);
    e.next = this.head;
    this.head = e;
  }

  public void print()
  {
    if(this.head == null)
    {
      System.out.println("List is empty!");
      return;
    }

    ListElement curr = head;
    System.out.println();
    System.out.print("[ ");

    while(curr != null)
    {
      System.out.print(curr.info + " ");
      curr = curr.next;
    }
    System.out.print("]");
    System.out.println();
  }

  public void clearOdd()
  {
    // ova metoda brise sve 
    // elemente na neparnim mestima
    ListElement curr = this.head;
    ListElement last = null;
    int counter = 0;

    while(curr.next != null)
    {
      last = curr;
      curr = curr.next;
      counter++;

      if(counter%2 != 0 && last != null)
      {
        last.next = curr.next;
        curr = last;
      }
      else
        this.head = curr.next;
    }
  }

  public void reverse()
  {
    if(this.head == null || this.head.next == null)
      return;

    // postoje bar dva
    ListElement last = null;
    ListElement curr = head;

    while(curr != null)
    {
      ListElement next = curr.next;

      curr.next = last;

      last = curr;
      curr = next;
    }
    this.head = last;
  }

  public void clearGreaterThanB(int b)
  {
    if(this.head == null)
      return;

    ListElement curr = this.head;

    while(curr.next != null)
    {
      if(curr.info > b)
      {
        if(curr == this.head)
        {
          curr = curr.next;
          this.head = curr;
        }
        else
        {
          curr.next = curr.next.next;
          curr = curr.next;
        }
      }
      else
        curr = curr.next;
    }
  }
}

class Zadatak1
{
  public static void main(String[] args)
  {
    List list = new List();
    testAdd(list);
    //list.add(3);
    list.print();
    list.clearGreaterThanB(2);
    list.print();
  }

  // test methods
  static void testAdd(List l)
  {
    for(int i=5; i>=0; i--)
    {
      l.add(i);
    }    
  }
}

