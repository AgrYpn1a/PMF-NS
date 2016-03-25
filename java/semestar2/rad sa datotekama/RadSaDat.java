import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class RadSaDat
{
    public static void main(String[] args)
    {
        String fileName = Svetovid.in.readLine("Type file name: ");

        while(Svetovid.in(fileName).hasMore())
        {
            Svetovid.out.println(Svetovid.in(fileName).readLine());
        }
        
        // file last modified
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        Svetovid.append(fileName).println("Last modified " + dateFormat.format(date).toString());

        Svetovid.in(fileName).close();
    }

    private static void readDoubleFromFile(String fileName)
    {
        if(Svetovid.testIn(fileName))
        {
            while(Svetovid.in(fileName).hasMore())
            {
                
            }
        }
    }

    private static double tryParseDouble(Object obj)
    {
        double d;
        try
        {
            d = as(obj, Double.class);
        }
        catch
        {
            return Double.NaN;
        }
        return d;
    }

    private static T as(Object o, Class<T> tClass)
    {
        return tClass.isInstance(o) ? (T)o : null;
    }
}
