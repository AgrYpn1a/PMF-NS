/**
  Napraviti klasu koja predstavlja jednu kuću, 
  koja je predstavljena svojom površinom i brojem soba.

  Napraviti klasu koja predstavlja Ulicu, odnosno u sebi ima niz kuća. 
  Ulica je dodatno predstavljena i svojim imenom, a redni brojevi u 
  nizu su redni brojevi kuća.

  Ispisati sve brojeve kuća sa tačno 4 sobe.
  Ispisati ukupunu površinu kuća na parnoj strani ulice.
  Ispisati broj kuće sa najvećom površinom.
  Ispisati broj kuće sa najvećom prosečnom površinom sobe.
  */
class Street
{
  final static int MAX_HOUSES = 100;

  public String name;
  public House[] houses;
  public int count;

  private String fileName;

  public Street(String fileName)
  {
    this.fileName = fileName;
    this.houses = new House[MAX_HOUSES];
    load();
  }

  public void print()
  {
    for(int i=0; i<this.count; i++)
      Svetovid.out.println(i + ". " + this.houses[i]);
  }

  public void getHouseWithLargestAvarageRoomArea()
  {
    int largestRoomArea = -1;
    int currentRoomArea = 0;
    int index = 0;
    for(int i=0; i<this.count; i++)  
    {
      currentRoomArea = this.houses[i].sqMeters / this.houses[i].rooms;
      if(currentRoomArea > largestRoomArea)
      {
        largestRoomArea = currentRoomArea;
        index = i;
      }
    }
    Svetovid.out.println("Number of house with largest avarage room area is " + index);
  }

  public void getLargestHouseNumber()
  {
    int largest = this.houses[0].sqMeters;
    int index = 0;

    for(int i=0; i<this.count; i++)
      if(this.houses[i].sqMeters > largest)
      {
        largest = this.houses[i].sqMeters;
        index = i;
      }
    Svetovid.out.println("Largest house in " + this.name + " is house with number " + index);
  }

  public void getTotalSqMetOnEvenSide()
  {
    int totalSqMet = 0;
    for(int i=0; i<this.count; i++)
    {
      if(i%2 == 0)
        totalSqMet += this.houses[i].sqMeters;
    }
    Svetovid.out.println("Total sqMet of houses on even side: " + totalSqMet);
  }

  public void getHousesByRoomNum(int n)
  {
    Svetovid.out.println();
    for(int i=0; i<this.count; i++)
    {
      if(this.houses[i].rooms == n)
        Svetovid.out.println(this.houses[i]);
    }
    Svetovid.out.println();
  }

  private void load()
  {
    if(!Svetovid.testIn(this.fileName))
      throw new RuntimeException("File not accessable or does not exist!");


    int counter = 0;
    boolean readHeader = false;
    while(counter < MAX_HOUSES && Svetovid.in(this.fileName).hasMore())
    {
      if(!readHeader)
      {
        this.name = Svetovid.in(this.fileName).readLine();
        Svetovid.in(this.fileName).readLine();
        readHeader = true;
      }
      this.houses[counter] = new House(Svetovid.in(this.fileName).readInt(),
          Svetovid.in(this.fileName).readInt());
      counter++;
    }

    this.count = counter;

    if(Svetovid.in(this.fileName).hasMore())
      Svetovid.out.println("File exceeds size limit. Loaded first " + MAX_HOUSES + ".");
    else
      Svetovid.out.println("Loaded successfully!");

    Svetovid.in(this.fileName).close();
  }
}

class House
{
  public int sqMeters;
  public int rooms;

  public House(int sqMeters, int rooms)
  {
    this.sqMeters = sqMeters;
    this.rooms = rooms;
  }

  public String toString()
  {
    return "\t" + this.sqMeters + "\t" + this.rooms; 
  }
}

class StreetProblem
{
  public static void main(String[] args)
  {
    Street street = new Street(Svetovid.in.readLine("File name:"));
    Svetovid.out.println();
    Svetovid.out.println("Welcome to " + street.name);
    Svetovid.out.println();
    street.print();
    Svetovid.out.println();

    street.getLargestHouseNumber();
    street.getTotalSqMetOnEvenSide();
    street.getHouseWithLargestAvarageRoomArea();
  }
}
