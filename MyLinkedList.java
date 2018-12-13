public class MyLinkedList
{
  public class Nodes
  {
    public int data;
    public Node next;
    public Node previous;
    public Nodes(int newData, Node nNext, Node nPrevious)
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
    public void setNext(Node input)
    {
      next = input;
    }
    public void setPrevious(Node input)
    {
      previous = input;
    }
    public void setData(int input)
    {
      data  = input;
    }
  }

  private int size = 0;
  private Node start;
  private Node end;

  public MyLinkedList(Node nStart, Node nEnd)
  {
    Node holder;
    start = new Node(nStart.getData(), nStart.getNext(), holder);
    end = new Node(nEnd.getData(), holder, nStart.getPrevious());
    while(nEnd.getPrevious() != null)
    {
      size ++;
      nEnd = nEnd.getPrevious();
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
    end = setUp;
    size ++;
    return true;
  }
  public void add(int index, Integer value)
  {
    if(index > this.size())
    {
      throw new IndexOutOfBoundsException();
    }
    Node input = new Node(value, getNode(index).getNext(), getNode(index).getPrevious());
    getNode(index).getNext().setPrevious(input);
    getNode(index).getPrevious().setNext(input);
    size ++;
  }

  public boolean contains(int item)
  {
    Node power = start;
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
    if(index > this.size())
    {
      throw new IndexOutOfBoundsException();
    }
    int output = this.get(index);
    this.getNext().setPrevious(this.getPrevious());
    this.getPrevious().setNext(this.getNext());
    this.get(index).setNext(null);
    this.get(index).setPrevious(null);
    size --;
    return output;
  }
  public int indexOf(int value)
  {
    if(! this.contains(value))
    {
      return -1;
    }
    Node power = start;
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
    return getNode(index).getData();
  }
  private Node getNode(int index)
  {
  if(index > this.size())
  {throw new IndexOutOfBoundsException();}
  int counter = 0;
  Node power = start;
  while(counter != index)
  { output = power.getData();
    power = power.getNext();
    counter ++;}
  return power;
}

  public Integer set(int index, int value)
  {
    int bounce = this.get(index);
    this.getNode(index).setData(value);
    return bounce;
  }

  public String toString()
  {
    Node power = start;
    String output = "[";
    while(power.getNext() != null)
    {
      output += (" " + power.getData() + ",");
      power = power.getNext();
    }
    output += "]";
    return output;
  }
}
