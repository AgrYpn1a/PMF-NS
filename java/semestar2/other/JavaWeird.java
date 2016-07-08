class Info
{
  String information;

  public Info(String inf)
  {
    this.information = inf;
  }

  public Info print()
  {
    System.out.println("My info is: " + this.information);
    return this;
  }
}

class JavaWeird
{
  public static void main(String[] args)
  {
    (new Info("bc2j3iu8xlsap98s")).print();
  }
}
