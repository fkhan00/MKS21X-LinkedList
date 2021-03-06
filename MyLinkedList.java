public class MyLinkedList
{
  public class Node
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
    public String toString(Node input)
    {
      String output = ("" + input.getData());
      return output;
    }
  }
  private int size = 0;
  private Node start;
  private Node end;

  public MyLinkedList()
  {
    size = 0;
  }
  public int size()
  {
    return size;
  }
  public boolean add(int value)
  {
    if(size == 0)
    {
      Node holder = null;
      start = new Node(value, null, holder);
      end = start;
      size ++;
      return true;
    }
     if(size == 1)
    {
      Node holder = null;
      end = new Node(value, holder, null);
      end.setPrevious(start);
      start.setNext(end);
      size ++;
      return true;
    }
    Node setUp = new Node(value, null, null);
    setUp.setPrevious(end);
    end.setNext(setUp);
    end = setUp;
    size ++;
    return true;
  }
  public void add(int index, Integer value)
  {
    if(index > this.size() || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
    if(size < 2 || index == size)
    {
      add(value);
    }
    else
    {
    //Node input = new Node(value, getNode(index).getNext(), getNode(index));
    Node input = new Node(value, null, null);
    //getNode(index).getNext().setPrevious(input);
    input.setNext(getNode(index + 1));
    input.setPrevious(getNode(index));
    getNode(index).setNext(input);
    size ++;
  }
  }

  public boolean contains(int item)
  {
    Node power = start;
    while(power != null)
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
    if(index > this.size() || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
    if(index == 0)
    {
      int output = start.getData();
      start = start.getNext();
      start.setPrevious(null);
      size --;
      return output;
    }
    if(index == size - 1)
    {
      int output = end.getData();
      end = end.getPrevious();
      end.setNext(null);
      size --;
      return output;
    }
    Node output = this.getNode(index);
    int val = output.getData();
    output.getNext().setPrevious(output.getPrevious());
    output.getPrevious().setNext(output.getNext());
    output.setNext(null);
    output.setPrevious(null);
    size --;
    return val;
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
  public boolean removeValue(int value)
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
  if(index > this.size() || index < 0)
  {throw new IndexOutOfBoundsException();}
  int counter = 0;
  Node power = start;
  while(counter != index)
  {
    counter ++;
    power = power.getNext();
  }
  return power;
}

  public Integer set(int index, int value)
  {
    if(index > size || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
  Integer bounce = this.get(index);
  this.getNode(index).setData(value);
    return bounce;
  }

  public String toString()
  {
    Node power = start;
    String output = "[";
    while(power != null)
    {
      output += (" " + power.getData() + ",");
      power = power.getNext();
    }
    output += "]";
    return output;
  }
  public Node getStart()
  {
    return start;
  }
  public Node getEnd()
  {
    return end;
  }
  public void extend(MyLinkedList other)
  {
    other.getStart().setPrevious(end);
    end.setNext(other.start);
    size += other.size;
    end = other.getEnd();
    other.size = 0;
    other.start = null;
    other.end = null;
  }
  public static void main(String[] args)
  {
    MyLinkedList test1 = new MyLinkedList();
    MyLinkedList test2 = new MyLinkedList();
    for(int i = 0; i < 10; i++)
    {
      test1.add(i);
      test2.add(i);
    }
    System.out.println(test1);
    test1.extend(test2);
    System.out.println(test1);
  }
}
