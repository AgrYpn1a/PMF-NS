public class DLL
{
  DLLNode first, last;
  public DLL()
  {
    this.first = null;
    this.last = null;
  }

  public class DLLNode
  {
    int info;
    DLLNode pred, succ;

    public DLLNode(int info)
    {
      this.info = info;
      this.pred = null;
      this.succ = null;
    }
  }

  public DLL insert(int info, DLLNode pred)
  {
    // insert after predecessor, or before
    // the first node if pred is null
    DLLNode node = new DLLNode(info);

    if(pred == null)
    {
      // insert at beginning
      node.succ = this.first;
      this.first = node;

      if(this.last == null)
      // if list is empty
        this.last = node;
      else
        this.first.succ.pred = node;
    }
    else
    {
      node.succ = pred.succ;
      pred.succ = node;

      if(node.succ == null)
      {
        // at the end
        node.pred = this.last;
        this.last = node;
      }
      else
      {
        node.pred = node.succ.pred;
        node.succ.pred = node;
      }

    }
  }
}

public class DLLProblem
{
  public static void main(String[] args)
  {
    
  }
}
