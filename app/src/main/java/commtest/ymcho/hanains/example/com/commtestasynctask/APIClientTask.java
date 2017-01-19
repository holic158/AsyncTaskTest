package commtest.ymcho.hanains.example.com.commtestasynctask;

import android.os.AsyncTask;

/**
 * Created by hanains on 2017-01-19.
 */

public class APIClientTask extends AsyncTask<String, Void, Value> {
    //AsyncTask 상속 받음.

    @Override
    public Value doInBackground(String... params) {

        APIClient client = new APIClient();

        String os = params[0];
        String minimum = params[1];
        String latest = params[2];

        Value v = client.getValue(os,minimum,latest);

        return v;

    }
}
