class Obj
{
    public static void main(String[] args)
    {
        Integer a = new Integer(50);
        Integer b = new Integer(50);

        System.out.println(a.equals(b));

        System.out.println("\n\n" + equals(a, b));
    }

    private static boolean equals(Object a, Object b)
    {
        if(a instanceof Integer)
            return true;
        else
            return false;
    }
}
