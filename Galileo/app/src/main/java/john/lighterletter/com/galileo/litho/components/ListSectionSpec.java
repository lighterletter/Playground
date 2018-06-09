package john.lighterletter.com.galileo.litho.components;

import android.app.LauncherActivity;
import android.graphics.Color;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

import java.util.List;

import john.lighterletter.com.galileo.model.Person;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(
            SectionContext c,
            @Prop List<Person> people) { // This is fairly straight-forward just adding objects here.

        Children.Builder builder = Children.create();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            builder.child(
                    SingleComponentSection.create(c)
                            .key(String.valueOf(i))
                            .component(ListItem.create(c)
                                    .color(i % 2 == 0 ? Color.WHITE : Color.LTGRAY)
                                    .title("Person: " + i)
                                    .subtitle(person.getFirstName() + " " + person.getLastName())
                                    .build()));
        }
        return builder.build();
    }

}
