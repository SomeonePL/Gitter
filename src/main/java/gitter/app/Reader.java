package gitter.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reader {
    public Reader() {
    }

    public String read(String url) {
        String name = "";


            try {
             HttpURLConnection   httpcon = (HttpURLConnection) new URL(url).openConnection();
             BufferedReader stream = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

             String line;
             Boolean found = false;
             while( (line = stream.readLine())  != null)
             {
                 if(line.contains("PushEvent")) {
                    found = true;
                    break;
                 }
             }
             if(found)
             {
                 while( (line = stream.readLine())  != null)
                 {
                     if(line.contains("name")) {
                         return line;
                     }
                 }
             }
             stream.close();
            } catch (IOException e) {
                e.printStackTrace();
                final String s = "ERROR! Unable to manage URL connection or get response!";
                return s;
            }


        return name;
    }
}
