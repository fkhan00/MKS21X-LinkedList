public class MyList
{
  private class Nodes
  {
    public int data;
    public Node next;
    public Node previous;
    public Node(int newData, Node nNext, Node nPrevious)
    {
      data = newData;
      nNext = next;
      nPrevious = previous;
    }
    public int getData()
    {
      return data;
    }
    public Node getNext()
    {
      return next;
    }

    public Node getPrevious()
    {
      return previous;
    }
    public void Node setNext(Node input)
    {
      next = input;
    }
    public void Node setPrevious(Node input)
    {
      previous = input;
    }
    public void setData(int input)
    {
      data  = input;
    }
  }
}
