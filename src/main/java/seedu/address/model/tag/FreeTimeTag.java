package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Free Time Tag in Dormie.
 */
public class FreeTimeTag extends Tag implements Comparable<FreeTimeTag> {

    public static final String MESSAGE_CONSTRAINTS = "Free Time Tag should be Mon-Sun:HHmm-HHmm (24hr format)";
    public static final String VALIDATION_REGEX =
            "^(Mon|Tue|Wed|Thu|Fri|Sat|Sun):(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])-(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])$";

    /**
     * Constructs a {@code FreeTimeTag}.
     *
     * @param tagName A valid tag name.
     */
    public FreeTimeTag(String tagName) {
        super(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if the current time is contained within the tag.
     * @param currentTime the current time in the format of "Mon-Sun:HHmm"
     * @return true if the current time is contained within the tag
     */
    public boolean isContained(String currentTime) {
        requireNonNull(currentTime);
        if (!currentTime.matches("^(Mon|Tue|Wed|Thu|Fri|Sat|Sun):(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])$")) {
            return false;
        }
        String[] split = tagName.split(":");
        if (!split[0].equals(currentTime.substring(0, 3))) {
            return false;
        }
        String[] time = split[1].split("-");
        String start = time[0];
        String end = time[1];
        String currentTimeStamp = currentTime.substring(4);
        return currentTimeStamp.compareTo(start) >= 0 && currentTimeStamp.compareTo(end) <= 0;
    }

    @Override
    public int compareTo(FreeTimeTag other) {
        String trimmedThis = this.toString().substring(1, this.toString().length() - 1);
        String thisDay = trimmedThis.substring(0, 3);
        Integer thisDayNum;
        if (thisDay.equals("Mon")) {
            thisDayNum = 1;
        } else if (thisDay.equals("Tue")) {
            thisDayNum = 2;
        } else if (thisDay.equals("Wed")) {
            thisDayNum = 3;
        } else if (thisDay.equals("Thu")) {
            thisDayNum = 4;
        } else if (thisDay.equals("Fri")) {
            thisDayNum = 5;
        } else if (thisDay.equals("Sat")) {
            thisDayNum = 6;
        } else {
            thisDayNum = 7;
        }
        Integer thisStart = Integer.parseInt(trimmedThis.substring(4, 8));
        Integer thisEnd = Integer.parseInt(trimmedThis.substring(9, 13));

        String trimmedOther = other.toString().substring(1, other.toString().length() - 1);
        Integer otherStart = Integer.parseInt(trimmedOther.substring(4, 8));
        Integer otherEnd = Integer.parseInt(trimmedOther.substring(9, 13));
        Integer otherDayNum;
        if (trimmedOther.substring(0, 3).equals("Mon")) {
            otherDayNum = 1;
        } else if (trimmedOther.substring(0, 3).equals("Tue")) {
            otherDayNum = 2;
        } else if (trimmedOther.substring(0, 3).equals("Wed")) {
            otherDayNum = 3;
        } else if (trimmedOther.substring(0, 3).equals("Thu")) {
            otherDayNum = 4;
        } else if (trimmedOther.substring(0, 3).equals("Fri")) {
            otherDayNum = 5;
        } else if (trimmedOther.substring(0, 3).equals("Sat")) {
            otherDayNum = 6;
        } else {
            otherDayNum = 7;
        }

        if (thisDayNum < otherDayNum) {
            return -1;
        } else if (thisDayNum.equals(otherDayNum)) {
            if (thisStart < otherStart) {
                return -1;
            } else if ((thisStart.equals(otherStart)) && (thisEnd < otherEnd)) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return tagName.equals(otherTag.tagName);
    }

    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }
}
