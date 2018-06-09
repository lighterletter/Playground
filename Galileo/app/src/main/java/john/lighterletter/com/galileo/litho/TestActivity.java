package john.lighterletter.com.galileo.litho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;

import java.util.ArrayList;
import java.util.List;

import john.lighterletter.com.galileo.R;
import john.lighterletter.com.galileo.litho.components.ListSection;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext context = new ComponentContext(this);
        Component component = RecyclerCollectionComponent.create(context)
                .disablePTR(true) //disables pull to refresh since we're not fetching data
                .section(ListSection.create(
                        new SectionContext(context))
                        .names(getNames()).build())
                .build();
        setContentView(R.layout.activity_test);

        RelativeLayout root = findViewById(R.id.test_root);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        root.addView(LithoView.create(context, component), 0 , params);

    }

    List<String> getNames() {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Clementine");
        names.add("Steve");
        names.add("Kate");
        names.add("Ruben");
        names.add("Chelsea");
        names.add("Matt");
        names.add("Martha");
        names.add("Luis");

        return names;
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
