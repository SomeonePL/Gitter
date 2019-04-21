package gitter.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Reader {
    public Reader() {
    }

    public String read(String url) {
        String repo_name = "";
        Pattern regexpattern = Pattern.compile("PushEvent.+\"name\\\":\\\"allegro/.+url");
        Matcher regexmather;

            try {
             HttpURLConnection   httpcon = (HttpURLConnection) new URL(url).openConnection();
             BufferedReader stream = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

             String line;
             Boolean found = false;
             while( (line =  stream.readLine() )  != null)
             {

                     if (line.contains("PushEvent")) {
                         found = true;
                         break;
                     }

             }

            if(found)
            {
                List names = Collections.synchronizedList(new ArrayList());
                List extract_name = Collections.synchronizedList(new ArrayList());
                Arrays.stream(line.split("PushEvent")).skip(1).map(l -> l.split("payload")[0]).forEach(l ->extract_name.add(l));
                Arrays.stream(extract_name.get(0).toString().split("\"name\":"+'"')).skip(1).map(l -> l.split("\",\"url\":")[0]).forEach(l -> names.add(l));
                repo_name = names.get(0).toString();
            }
             stream.close();
            } catch (IOException e) {
                e.printStackTrace();
                final String s = "ERROR! Unable to manage URL connection or to get response!";
                return s;
            }


        return repo_name;
    }
}
