/**
  Napisati program koji radi sa spiskom studenata. U fajlu su u svakom 
  redu podaci o jednom studentu, redom ime, prezime i godina rodjenja razdvojeni razmacima.

  Učitati podatke iz fajla čije se ime unosi sa tastature. Podatke ispisati na ekran.
  Napraviti klasu koja predstavlja jednog studenta. Za svakog studenta se pamti ime, prezime i godina rođenja.
  Podatke o studentima predstaviti novom klasom koja podatke čuva u nizu objekata.
  Omogućiti unos novog studenta u spisak i snimiti tako promenjene podatke u fajl.
  Ispisati podatke o studentima sa unetom godinom rođenja
  Prebrojati koliko studenata je rođeno pre neke unete godine

  PROSIRENJE

  Proširiti zadatak za samostalno vežbanje (spisak studenata) sledećim funkcionalnostima:

  Ispisati podatke o studentima sa unetim
  imenom
  prezimenom
  kojima prezime počinje unetim stringom (koristiti metod startsWith klase String)
  koji imaju prezime određene dužine (koristiti length() klase String)

*/
class StudentList
{
  final static int MAX_STUDENTS = 100;

  public Student[] students;
  public int count;

  private String fileName;

  public StudentList(String fileName)
  {
    this.fileName = fileName;
    this.students = new Student[MAX_STUDENTS];

    // this method also checks for failures,
    // such as non existant file, or a file
    // that contains more data than program 
    // can handle
    this.count = getCount();
  }

  // methods
  public int countStudBefYear(int year)
  {
    int count = 0;
    for(int i=0; i<this.count; i++)
      if(this.students[i].year < year)
        count++;
    return count;
  }

  public void getStudByYear(int year)
  {
    Svetovid.out.println();
    for(int i=0; i<this.count; i++)
    {
      if(this.students[i].year == year)
        Svetovid.out.println(this.students[i]);
    }
  }

  public void save()
  {
    for(int i=0; i<this.count; i++)
    {
      Svetovid.out(this.fileName).println(this.students[i]);
    }
    Svetovid.out(this.fileName).close();
  }

  public void addStudent(Student std)
  {
    this.students[count] = std;

    if(this.count < MAX_STUDENTS - 1)
    {
      Svetovid.out.println();
      Svetovid.out.println("Added student");
      Svetovid.out.println(students[count]);
      this.count++;
    }
    else
      throw new RuntimeException("Student not added, maximum reached!");
  }

  public void getStudents()
  {
    Svetovid.out.println();
    Svetovid.out.println("****STUDENTS****");
    int currentStud = 0;
    while(Svetovid.in(this.fileName).hasMore())
    {
      this.students[currentStud] = new Student(
          Svetovid.in(this.fileName).readToken(),
          Svetovid.in(this.fileName).readToken(),
          Svetovid.in(this.fileName).readInt());
      Svetovid.out.println(this.students[currentStud]);
      currentStud++;
    }
    Svetovid.in(this.fileName).close();
    Svetovid.out.println("****************");
  }

  // private methods
  private int getCount()
  {
    if(!Svetovid.testIn(this.fileName) && !Svetovid.testOut(this.fileName))
      throw new RuntimeException("File not accessable or does not exist!");

    int counter = 0;
    while(Svetovid.in(this.fileName).hasMore())
    {
      Svetovid.in(this.fileName).readLine();
      counter++;
    }
    Svetovid.in(this.fileName).close();
    Svetovid.out(this.fileName).close();
    if(counter < MAX_STUDENTS)
      return counter;
    else
      throw new RuntimeException("File exceeds size limit!");
  }

  // PROSIRENJE
  public void getStudByLstNmLn(int length)
  {
    Svetovid.out.println();
    for(int i=0; i<this.count; i++)  
    {
      if(this.students[i].lastName.toCharArray().length == length)
        Svetovid.out.println(this.students[i]);
    }
    Svetovid.out.println();
  }

  public void getSudByStr(String str)
  {
    Svetovid.out.println();
    for(int i=0; i<this.count; i++)  
    {
      if(this.students[i].name.startsWith(str))
        Svetovid.out.println(this.students[i]);
    }
    Svetovid.out.println();
  }

  // get student by name or last name
  public void getStudByName(String name)
  {
    Svetovid.out.println();
    for(int i=0; i<this.count; i++)  
    {
      if(name.equals(this.students[i].name) || name.equals(this.students[i].lastName))
        Svetovid.out.println(this.students[i]);
    }
    Svetovid.out.println();
  }  
}

class Student
{
  public String name;
  public String lastName;
  public int year;

  public Student(String lastName, String name, int year)
  {
    this.name = name;
    this.lastName = lastName;
    this.year = year;
  }

  public String toString()
  {
    return this.name + " " + this.lastName + " " + this.year;
  }
}

class Students
{
  public static void main(String[] args)
  {
    StudentList studList = new StudentList(
        Svetovid.in.readLine("File name: "));
    studList.getStudents();
    studList.addStudent(new Student(
          Svetovid.in.readLine("Last name: "),
          Svetovid.in.readLine("Name: "),
          Svetovid.in.readInt("Year: "))
        );
    studList.save();
    studList.getStudents();
    studList.getStudByYear(Svetovid.in.readInt("Filter students(year):"));
    int year = Svetovid.in.readInt("Filter students(b.b year):");
    Svetovid.out.println("Number of students born before " + year + " is: " + 
        studList.countStudBefYear(year));
  }
}
