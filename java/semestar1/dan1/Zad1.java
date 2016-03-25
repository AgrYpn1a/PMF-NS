/* zadatak1 */
class Zad1
{
  public static void main(String[] args)
  {
    int a = 0, b = 0;
    float sredina = 0f;
    
    Svetovid.out.println("Unesi dva broja: ");
    
    a = Svetovid.in.readInt(); 
    b = Svetovid.in.readInt();
    
    sredina = (a+b) / 2f;
    Svetovid.out.println("Sredina a i b " + sredina);
  }
}