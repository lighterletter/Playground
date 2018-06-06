package john.lighterletter.com.galileo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    void someMethod() {

        //lambdas
        Listener listener = () -> {};
        listener.someListener();

        //implementation
        ParamListener in = System.out::print; // Print out the value passed in

        //call
        in.passed("Working lambdas");
    }

    //define
    interface Listener {
        void someListener();
    }

    //definition
    interface ParamListener {
        void passed(String s);
    }
}
