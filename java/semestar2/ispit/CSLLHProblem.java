class CSLLH
{
  CSLLNode header;
  public CSLLH()
  {
    this.header = new CSLLNode(-1);
    this.header.next = this.header;
  }

  public class CSLLNode
  {
    int info;
    CSLLNode next;
    public CSLLNode()
    {
      this.info = info;
      this.next = null;
    }
  }

  public CSLLH insertFirst(int info)
  {
    CSLLNode node = new CSLLNode(info);
    node.next = this.header.next;
    this.header.next = node;
  }

  public CSLLH insertLast(int info)
  {
    CSLLNode node = new CSLLNode(info);
   
    node.next = this.header.next;
    this.header.next = node;

    this.header.info = info;
    this.header = node;
  }

  public CSLLNode find(int info)
  {
    // spakujemo u header
    this.header.info = info;

    CSLLNode curr = this.header.next;
    while(curr.info != info)
      curr = curr.next;

    if(curr != this.header)
      return curr;
    else
      return null;
  }
}

public class CSSLHProblem
{
  public static void main(String[] args)
  {

  }
}
