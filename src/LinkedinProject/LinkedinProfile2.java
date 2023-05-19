package LinkedinProject;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkedinProfile2 {
    public static void main(String[] args) throws Exception {
        String profileName = "zapaer-alip";
        String searchURL = "https://www.linkedin.com/search/results/people/?keywords=" + profileName;

        URL url = new URL(searchURL);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.connect();

        System.out.println("Opening " + searchURL);

        if (urlConn.getResponseCode() != 200) {
            System.out.println("Unable to open the site");
        } else {
            System.out.println("Site is open!");
            String[] cmd = { "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", searchURL };
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        }
    }
}

