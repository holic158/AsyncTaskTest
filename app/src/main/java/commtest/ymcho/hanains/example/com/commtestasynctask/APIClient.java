package commtest.ymcho.hanains.example.com.commtestasynctask;

/**
 * Created by hanains on 2017-01-19.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIClient {

//    private final String TAG = APIClient.getClass().getSimpleName();

    final static String APIClient = "https://fidodev.hanains.com:8443/api/v1/versions/android";

    public Value getValue(String os, String minimum, String latest) {

        Value v = new Value();

        try {
            //call by using HTTP URL Connection
            URL url = new URL(APIClient);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSONObject json = new JSONObject(getStringFromInputStream(in));

            v = parseJSON(json);

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL");
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            System.err.println("JSON pasing error");
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            System.err.println("URL Connection failed");
            e.printStackTrace();
            return null;
        }
        return v;
    }

    private Value parseJSON(JSONObject json) throws JSONException {

        Value v = new Value();
        v.setLatest(json.getString("latest"));
        v.setMinimum(json.getString("minimum"));
        v.setOs(json.getString("os"));
        return v;

    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;

        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}