package commtest.ymcho.hanains.example.com.commtestasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import commtest.ymcho.hanains.example.com.commtestasynctask.*;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    String os = params[0];
//    String minimum = params[1];
//    String latest = params[2];

    public void getInformation(View view) {
        //value 읽어오는 API 호출
        APIClientTask t = new APIClientTask();
    try {
        Value v = t.execute("t","t","t").get();
        TextView tem = (TextView)findViewById(R.id.tem);
        String x = String.valueOf(v.getOs()+v.getLatest()+v.getMinimum());
        tem.setText(x);

     } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
    }
}


