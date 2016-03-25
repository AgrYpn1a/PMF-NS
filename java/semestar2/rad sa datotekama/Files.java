class Files
{
    public static void main(String[] args)
    {
       String fileName = Svetovid.in.readLine("Filename(s): ");

       swapLettersInFile(fileName,
               Svetovid.in.readChar("Char to swap(c): "),
               Svetovid.in.readChar("Swap char with(c): "));

       printFile(fileName);
    }

    private static void printFile(String fileName)
    {
        if(!Svetovid.testIn(fileName))
            return;

        while(Svetovid.in(fileName).hasMore())
            Svetovid.out.println(Svetovid.in(fileName).readLine());

        Svetovid.in(fileName).close();
    }

    private static void swapLettersInFile(String fileName, char x, char y)
    {
        if(!Svetovid.testOut(fileName))
            return;
        
        System.out.println("\nWorking...");

        while(Svetovid.in(fileName).hasMore())
        {
            String line = Svetovid.in(fileName).readLine();

            Svetovid.in(fileName).close();

            Svetovid.out(fileName).println(swapLettersInString(line, x, y));

            Svetovid.out(fileName).close();
        }

        System.out.println("\nDone!");
    }

    private static String swapLettersInString(String str, char x, char y)
    {
        char[] line = str.toCharArray();

        for(int i=0; i<line.length; i++)
            if(line[i] == x)
                line[i] = y;

        return String.copyValueOf(line);
    }
}
