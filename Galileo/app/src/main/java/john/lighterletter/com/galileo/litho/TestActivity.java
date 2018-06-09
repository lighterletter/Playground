package john.lighterletter.com.galileo.litho;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;

import java.util.ArrayList;
import java.util.List;

import john.lighterletter.com.galileo.db.PeopleDataBase;
import john.lighterletter.com.galileo.litho.components.ListSection;
import john.lighterletter.com.galileo.model.Person;

public class TestActivity extends AppCompatActivity {


    private static final String DATABASE_NAME = "people_db";
    private PeopleDataBase movieDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieDatabase = Room.databaseBuilder(getApplicationContext(),
                PeopleDataBase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        final List<Person> people = new ArrayList<>();


        final ComponentContext context = new ComponentContext(this);
        Component component = RecyclerCollectionComponent.create(context)
                .disablePTR(true) //disables pull to refresh since we're not fetching data
                .section(ListSection.create(
                        new SectionContext(context))
                        .people(people).build())
                .build();
        setContentView(LithoView.create(context, component));



        new Thread(new Runnable() {
            @Override
            public void run() {
                people.addAll(movieDatabase.daoAccess().getAll());
                if (people.isEmpty()) {
                    //Todo: Create list objects and save them to the database, otherwise get all objects and pass to component
                    people.addAll(getPeople());
                    movieDatabase.daoAccess().insertMultiplePeople(people);
                } else {

                }
            }
        }).start();



    }

    List<Person> getPeople() {


        List<Person> names = new ArrayList<>();
        names.add(new Person("John", "Smith"));
        names.add(new Person("Clementine", "Berry"));
        names.add(new Person("Steve", "Brule"));
        names.add(new Person("Kate", "Stevenson"));
        names.add(new Person("Ruben", "Guy"));
        names.add(new Person("Chelsea", "Peterson"));
        names.add(new Person("Matt", "Brosnan"));
        names.add(new Person("Martha", "Vineyard"));
        names.add(new Person("Luis", "Bernan"));

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
