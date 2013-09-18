package com.tinkerpop.blueprints;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Element {

    public Object getId();

    public <T> Property<T> getProperty(String key);

    public <T> Property<T> setProperty(String key, T value);

    public <T> Property<T> removeProperty(String key);

    public Set<String> getPropertyKeys();

    public default <T> T getValue(String key) throws NoSuchElementException {
        final Property<T> property = this.getProperty(key);
        if (property.isPresent())
            return property.getValue();
        else throw new NoSuchElementException();
    }

    public void remove();

}
