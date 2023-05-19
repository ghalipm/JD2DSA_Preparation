package LinkedinProject;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkedinProfile {

    public static void main(String[] args) throws Exception {
        String profileName = "alip-mohammed";
        String searchURL = "https://www.linkedin.com/search/results/people/?keywords=" + profileName;

        URL url = new URL(searchURL);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.connect();

        System.out.println("Opening Alip Mohammed's profile on LinkedIn");

        if (urlConn.getResponseCode() != 200) {
            System.out.println("Unable to open the profile");
        } else {
            System.out.println("Alip Mohammed's profile is open!");
            String[] cmd = { "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", searchURL };
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        }
    }
}