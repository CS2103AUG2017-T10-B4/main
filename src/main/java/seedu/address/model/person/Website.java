package seedu.address.model.person;

import seedu.address.commons.exceptions.IllegalValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class Website {

    public static final String MESSAGE_WEBSITE_CONSTRAINTS =
            "Person's website should start with \"https://\" and end with a top-level domain ";

    public final String value;

    /**
     * Validates given website.
     *
     * @throws IllegalValueException if given website string is invalid.
     */
    public Website(String website) throws IllegalValueException {
        requireNonNull(website);
        String trimmedWebsite = website.trim();
        if (!isValidWebsite(trimmedWebsite)) {
            throw new IllegalValueException(MESSAGE_WEBSITE_CONSTRAINTS);
        }
        this.value = trimmedWebsite;
    }

    /**
     * Returns if a given string is a valid person email.
     */
    public static boolean isValidWebsite(String test) {
        Pattern p = Pattern.compile("(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(https://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");

        Matcher m = p.matcher(test);
        return m.matches();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Website // instanceof handles nulls
                && this.value.equals(((Website) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
