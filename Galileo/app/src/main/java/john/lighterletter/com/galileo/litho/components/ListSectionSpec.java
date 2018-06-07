package john.lighterletter.com.galileo.litho.components;

import android.graphics.Color;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

import java.util.List;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(
            SectionContext c,
            @Prop List<String> names) {

        Children.Builder builder = Children.create();

        for (int i = 0; i < names.size(); i++) {
            builder.child(
                    SingleComponentSection.create(c)
                            .key(String.valueOf(i))
                            .component(ListItem.create(c)
                                    .color(i % 2 == 0 ? Color.WHITE : Color.LTGRAY)
                                    .title(i + ": " + names.get(i))
                                    .subtitle("Litho tutorial")
                                    .build()));
        }
        return builder.build();
    }

}
