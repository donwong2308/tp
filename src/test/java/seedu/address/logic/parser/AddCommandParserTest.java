package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.BIRTHDAY_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.DORM_TAG_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.FREE_TIME_TAG_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.ROOMNUMBER_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.TELEGRAM_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DORM_TAG_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROOMNUMBER_BOB;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalNewPersons.BOB;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RoomNumber;
import seedu.address.model.person.Telegram;
import seedu.address.model.tag.DormTag;
import seedu.address.model.tag.FreeTimeTag;
import seedu.address.testutil.NewPersonBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Person expectedPerson = new NewPersonBuilder(BOB).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ROOMNUMBER_DESC_BOB + TELEGRAM_DESC_BOB + BIRTHDAY_DESC_BOB + DORM_TAG_DESC_BOB
                        + FREE_TIME_TAG_DESC_BOB,
                new AddCommand(expectedPerson));
    }

    @Test
    public void parse_someFieldsPresent_success() {
        Name name = new Name(VALID_NAME_BOB);
        Phone phone = new Phone(VALID_PHONE_BOB);
        Email email = null;
        RoomNumber roomNumber = new RoomNumber(VALID_ROOMNUMBER_BOB);
        Telegram telegram = null;
        Birthday birthday = new Birthday(VALID_BIRTHDAY_BOB);
        DormTag dormTag = new DormTag(VALID_DORM_TAG_BOB);
        Set<FreeTimeTag> freeTimeTag = Set.of(new FreeTimeTag("Wed:1400-2000"));

        Person expectedPerson = new Person(name, phone, email, roomNumber, telegram, birthday, dormTag, freeTimeTag);

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + PHONE_DESC_BOB
                + ROOMNUMBER_DESC_BOB + BIRTHDAY_DESC_BOB + DORM_TAG_DESC_BOB + FREE_TIME_TAG_DESC_BOB,
                new AddCommand(expectedPerson));
    }
    @Test
    public void parse_preamble_fail() {
        // Non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                        + ROOMNUMBER_DESC_BOB + TELEGRAM_DESC_BOB + BIRTHDAY_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
    @Test
    public void parse_nameMissing_fail() {
        // whitespace only preamble
        assertParseFailure(parser, PREAMBLE_WHITESPACE + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ROOMNUMBER_DESC_BOB + TELEGRAM_DESC_BOB + BIRTHDAY_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_phoneMissing_fail() {
        // whitespace only preamble
        assertParseFailure(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + EMAIL_DESC_BOB
                        + ROOMNUMBER_DESC_BOB + TELEGRAM_DESC_BOB + BIRTHDAY_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
