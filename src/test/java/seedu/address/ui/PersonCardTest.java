package seedu.address.ui;

import org.junit.jupiter.api.Test;
import seedu.address.model.person.*;
import seedu.address.model.tag.DormTag;
import seedu.address.model.tag.FreeTimeTag;

import java.util.HashSet;
import java.util.Set;

public class PersonCardTest {

    @Test
    public void personCardCreateSuccess() {
        Set<FreeTimeTag> tags = new HashSet<>();
        tags.add(new FreeTimeTag("Mon:1300-1400"));

        PersonCard personCard = new PersonCard(new Person(new Name("John Doe"), new Phone("91234567"),
                new Email("jdoe@cs.hku.hk"), new RoomNumber("sw-01-01"), new Telegram("johnDoe"),
                new Birthday("2024-04-01"), new DormTag("PGPR"), tags),0);

        assert(personCard != null);
    }
}
