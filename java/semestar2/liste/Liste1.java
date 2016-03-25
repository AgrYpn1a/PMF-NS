class List
{
  class ListElement
  {
    int info;
    ListElement next;

    public ListElement(int n)
    {
      this.info = n;
      this.next = null;
    }

    public String toString()
    {
      return info + " ";
    }
  }

  ListElement head = null;

  public List()
  {
    for(int i=1; i<=5; i++)
    {
      ListElement _new = new ListElement(i);
      _new.next = head;
      head = _new;
    }     
  }
}

class Liste1
{
  public static void main(String[] args)
  {
    List list = new List();
    ListElement current = list.head;

    while(current != null)
    {
      Svetovid.out.println(current);
      current = current.next;
    }
  }
}
