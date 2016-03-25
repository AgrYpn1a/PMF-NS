class Klasa
{
    public int id = 0;
    
    public void SetId(int id)
    {
        this.id = id;
    }

    public void PrintId()
    {
        System.out.println("id: " + this.id);
    }
}

class Primer2
{
    public static void main(String[] args)
    {
        Klasa k = new Klasa();

        k.PrintId();
        k.SetId(4);
        k.PrintId();
    }
}
