package john.lighterletter.com.galileo.litho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;

import john.lighterletter.com.galileo.litho.components.ListItem;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext context = new ComponentContext(this);
        final Component component = ListItem.create(context).build();
        setContentView(LithoView.create(context, component));
    }

    void someMethod() {

        //lambdas
        Listener listener = () -> {
        };
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
