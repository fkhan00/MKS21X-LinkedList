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
  private int size = 0;
  private Node start,end;

  public MyLinkedList(Node nStart, Node nEnd)
  {
    start = new Node(nStart.getData(), nStart.getNext(), null);
    end = new Node(nEnd.getData(), null, nStart.getPrevious());
    while(nEnd.getPrevious != null)
    {
      size ++;
      nEnd = nEnd.getPrevious;
    }
  }
  public int size()
  {
    return size;
  }
  public boolean add(int value);
  {
    Node setUp = new Node(value, null, end);
    end.setNext(setUp);
    setUp.setPrevious(end);
    end = setUp;
    size ++;
    return true;
  }
  public boolean contains(int item)
  {
    Node power = new Node(3, null, null);
    power.setNext(start);
    while(power.getNext() != null)
    {
        if(power.getData() == item)
        {
          return true;
        }
        power = power.getNext();
    }
    return false;
  }
  public int remove(int index)
  {
    this.getNext().setPrevious(this.getPrevious());
    this.getPrevious().setNext(this.getNext());
    this.get(index).setNext(null);
    this.get(index).setPrevious(null);
    size --;
    return this.getData();
  }
  public int indexOf(int value)
  {
    if(! this.contains(value))
    {
      return -1;
    }
    Node power = new Node(3, null, null);
    power.setNext(start);
    int counter = 0;
    while( power.getData() != value)
    {
      counter ++;
      power = power.getNext();
    }
    return counter;
  }
  public boolean remove(int value)
  {
    if(this.indexOf(value) == -1)
    {
      return false;
    }
    remove(this.indexOf(value));
    return true;
  }
  public Integer get(int index)
  {
    int counter = 0;
    Node power = new Node(3, null, null);
    power.setNext(start);
    while(power.getNext() != null && power.)
    {
      counter ++;
    }
  }

  public String toString()
  {
    Node power = new Node(3, null, null);
    power.setNext(start);
    String output = "[";
    while(power.getNext() != null)
    {
      output += (" " + power.getData() + ",");
      power = power.getNext();
    }
    output += "]";
    return output;
    power.setNext(null);
    power.setPrevious(null);
  }


}
