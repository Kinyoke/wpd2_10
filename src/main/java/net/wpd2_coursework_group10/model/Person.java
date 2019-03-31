
package net.wpd2_coursework_group10.model;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Value
public class Person {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Person.class);

    private final String first;
    private final String last;
    private final String email;

    public Person(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public String getFirst() { return this.first; }

    public String getLast() { return this.last; }

    public String getEmail() { return this.email; }

}
