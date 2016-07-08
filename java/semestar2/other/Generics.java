class Generics
{
  public static void main(String[] args)
  {
    //MyType<int> myType = new MyType<int>(5);
    myMethod<int>();
  }

  public static T myMethod<T>()
  {
    return T;
  }
}

class MyType<T>
{
  T info;
  public MyType(T info)
  {
    this.info = info;
  }
}
