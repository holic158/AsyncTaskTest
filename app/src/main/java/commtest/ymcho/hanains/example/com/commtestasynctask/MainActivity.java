package commtest.ymcho.hanains.example.com.commtestasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    public static Value value = null;
    private static EditText tem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getInformation(View view) {

        final TextView tem = (TextView) findViewById(R.id.tem);

        HttpHandler httpHandler = new HttpHandler() {
            @Override
            public void onSuccess(Value value) {
                String test = value.getOs() + value.getLatest() + value.getMinimum();
                tem.setText(test);
            }

            @Override
            public void onFailed() {

            }
        };


        //value 읽어오는 API 호출
        APIClientTask t = new APIClientTask(httpHandler);

        try {
            Value v2 = t.execute("").get();


//        tem.setText(x);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void onResult(Value v){
        String test = value.getOs() + value.getLatest() + value.getMinimum();
        tem.setText(test);
    }
}


