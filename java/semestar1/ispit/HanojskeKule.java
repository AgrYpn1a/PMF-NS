class HanojskeKule
{
    public static void main(String[] args)
    {
        System.out.println("Unesi n: ");
        hanojskeKule(Svetovid.in.readInt(), 1, 2, 3);
    }

    private static void hanojskeKule(int n, int A, int B, int C)
    {
        if(n>0)
        {
            hanojskeKule(n-1, A, C, B);
            System.out.println("Premesti sa " + A + " na " + C);
            hanojskeKule(n-1, B, A, C);
        }
    }
}
