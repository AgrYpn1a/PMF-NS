package knjige;

import org.svetovid.Svetovid;

import java.io.IOException;

/**
 * Created by Rastko on 29-Oct-16.
 */
public class Knjige {

    private Knjiga[] knjige;

    public Knjige(String fileName) throws IOException {
        knjige = new Knjiga[Svetovid.in(fileName).readInt()];

        for(int i=0; i<knjige.length; i++) {
            knjige[i] = new Knjiga(
                    Svetovid.in(fileName).readInt(),
                    Svetovid.in(fileName).readLine(),
                    Svetovid.in(fileName).readLine()
            );
        }
    }

    public Knjiga[] getCollection() {
        return knjige;
    }
}
