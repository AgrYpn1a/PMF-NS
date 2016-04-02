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
  public ListElement end;
  private int length;

  public List()
  {
    this.head = null;
    this.length = 0;
    this.end = null;
  }

  public void add(int info)
  {
    ListElement e = new ListElement(info);

    // add end
    if(this.end == null)
      this.end = e;

    e.next = this.head;
    this.head = e;
    this.length++;
  }

  public List print(String msg)
  {
    if(this.head == null)
    {
      System.out.println(msg + " - List is empty!");
      return this;
    }

    ListElement curr = head;
    System.out.println();
    System.out.print(msg + " - [ ");

    while(curr != null)
    {
      System.out.print(curr.info + " ");
      curr = curr.next;
    }
    System.out.print("]");
    System.out.println();
    return this;
  }

  public List clearOdd()
  {
    if(this.head == null)
      return this;

    while(this.head != null && this.head.info%2 != 0)
      this.head = this.head.next;

    if(this.head == null)
      return this;

    ListElement curr = this.head;
    ListElement last = null;

    while(curr.next != null)
    {
      last = curr;
      curr = curr.next;
      if(curr.info%2 != 0)
      {
        last.next = curr.next;
        curr = last;
        this.length--;
      }
    }
    this.end = last;
    return this;
  }

  public List clearGreaterThanB(int b)
  {
    if(this.head == null)
      return this;

    while(head != null && head.info > b)
      head = head.next;

    if(head == null)
      return this;

    ListElement curr = this.head;
    ListElement last = null;

    while(curr.next != null)
    {
      last = curr;
      curr = curr.next;
      if(curr.info > b)
      {
        last.next = curr.next;
        curr = last;
        this.length--;
      }
    }

    this.end = last;
    return this;
  }

  public List reverse()
  {
    if(this.head == null || this.head.next == null)
      return this;

    // postoje bar dva
    ListElement last = null;
    ListElement curr = head;
    this.end = head;
    while(curr != null)
    {
      ListElement next = curr.next;

      curr.next = last;

      last = curr;
      curr = next;
    }
    this.head = last;
    return this;
  }

  public List splitEven()
  {
    List even = new List();
    ListElement evenEnd = null;

    ListElement curr, last;

    while(this.head != null && this.head.info%2 == 0)
    {
      curr = this.head;
      this.head = this.head.next;

      if(even.head == null)
      {
        even.head = curr;
        curr.next = null;
        evenEnd = curr;
        this.length--;
      }
      else
      {
        evenEnd.next = curr;
        evenEnd = curr;
        curr.next = null;
        this.length--;
      }
    }


    if(this.head == null)
      return even;

    curr = this.head;
    while(curr.next != null)
    {
      last = curr;
      curr = curr.next;
      if(curr.info%2 == 0)
      {
        last.next = curr.next;
        if(even.head == null)
        {
          even.head = curr;
          curr.next = null;
          evenEnd = curr;
          this.length--;
        }
        else
        {
          evenEnd.next = curr;
          curr.next = null;
          evenEnd = curr;
          this.length--;
        }
        curr = last;
      }
    }

    return even;
  }

  public List shorten(int n)
  {
    int length = this.length - n;
    int count = 0;
    while(this.head != null && count < length)
    {
      this.head = this.head.next;
      count++;
      this.length--;
    }
    return this;
  }

  public int getLength()
  {
    return this.length;
  }

  public List insertAfterLast(int c, int b)
  {
    if(this.head == null)
      return this;

    ListElement curr = this.head;
    ListElement last = null;

    while(curr != null)
    {
      if(curr.info == b)
        last = curr;

      curr = curr.next;
    }
    if(last == null)
      System.out.println("Element does not exist!");
    else
    {
      ListElement e = new ListElement(c);
      e.next = last.next;
      last.next = e;
      this.length++;
    }
    return this;
  }

  public List merge(List l)
  {
    if(this.head == null)
    {
      this.head = l.head;
      return this;
    }

    ListElement curr = this.head;
    ListElement currL = l.head;

    ListElement lastL = null;

    while(curr != null)
    {
      ListElement last = curr;
      curr = curr.next;

      if(currL != null)
      {
        lastL = currL;
        currL = currL.next;

        lastL.next = curr;
        last.next = lastL;
      }
    }

    l.head = null;

    return this;
  }

  public List printEnd()
  {
    System.out.println(this.end.info);
    return this;
  }
}

class Zadatak1
{
  public static void main(String[] args)
  {
    List list = new List(), list2 = new List();
    testAdd(list);

    list.print("Original");
    //list.reverse().print("Reverse").printEnd().reverse().print("Reverse").printEnd().clearOdd().print("Odd cleared").printEnd().clearGreaterThanB(3).print("Cleared").printEnd();

    
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    list2.add(10);
    

    list.print("list1").clearOdd().print("Cleared odd");
    list2.print("list2");
 
    list.merge(list2).print("list merged");
    list2.print("list2");

    /*
    list.print("Original").insertAfterLast(3, 2).insertAfterLast(4, 3).print("Extended").shorten(4).print("Shorten");

    // list two
    List list2 = list.splitEven();
    list2.print("Even");
    list.print("Original");
    System.out.println("Length: " + list.getLength());
    //list.reverse().print().reverse().print();
    //list.clearOdd().print().clearGreaterThanB(3).print();
    */
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


