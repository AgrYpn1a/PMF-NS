class Vozilo
{
    public String Marka;
    public String Godina;

    public void PrintInfo()
    {
        System.out.println("Marka: " + this.Marka);
        System.out.println("Godina: " + this.Godina);
    }

    public static void printInfo(Vozilo v)
    {
        System.out.println("Marka: " + v.Marka);
        System.out.println("Godina: " + v.Godina);
    }
}

class Primer1
{
    public static void main(String[] args)
    {
        Vozilo voz1 = new Vozilo();

        voz1.Marka = "BMW";
        voz1.Godina = "1995";

        voz1.PrintInfo();

        Vozilo.printInfo(voz1);
    }
}
