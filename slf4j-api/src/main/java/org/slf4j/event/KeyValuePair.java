package org.slf4j.event;

import java.util.Objects;

/**
 * 键值对
 */
public class KeyValuePair {

    /**
     * 键
     */
    public final String key;
    /**
     * 值
     */
    public final Object value;

    public KeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=\"" + value +"\"";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        KeyValuePair that = (KeyValuePair) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
