class Klasa
{
    public int a = 0;
    public int b = 3;

    Klasa(int x)
    {
        System.out.println("An object created with paramteres: " + x + "!");
        a = x;
    }
}

class Primer1
{

    public static void main(String[] args)
    {
        String str = "Neki string";

        Klasa k = new Klasa(4);
        
        f(k);
    }

    static void f(Object obj)
    {
        System.out.println(obj);
        System.out.println("Error!");
    }
}
