package commtest.ymcho.hanains.example.com.commtestasynctask;

import android.os.AsyncTask;

/**
 * Created by hanains on 2017-01-19.
 */

public class APIClientTask extends AsyncTask<String, Void, Value> {
    //AsyncTask 상속 받음.

    private  HttpHandler httpHandler;

    public APIClientTask(HttpHandler httpHandler) {
        this.httpHandler = httpHandler;
    }

    @Override
    protected void onPreExecute() {


        super.onPreExecute();
    }

    @Override
    public Value doInBackground(String... params) {
        //가변 배열 params

        APIClient client = new APIClient();
        //APIClient 객체 생성




        Value v = client.getValue(params[0]);

        return v;

    }

    @Override
    protected void onPostExecute(Value value) {
        super.onPostExecute(value);
//        MainActivity.value = value;
        MainActivity.onResult(value);
//        httpHandler.onSuccess(value);
    }
}
