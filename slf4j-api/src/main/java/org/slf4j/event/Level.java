package org.slf4j.event;

import static org.slf4j.event.EventConstants.DEBUG_INT;
import static org.slf4j.event.EventConstants.ERROR_INT;
import static org.slf4j.event.EventConstants.INFO_INT;
import static org.slf4j.event.EventConstants.TRACE_INT;
import static org.slf4j.event.EventConstants.WARN_INT;

/**
 * SLF4J's internal representation of Level.
 * 日志级别的内部表示形式
 * 
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.7.15
 */
public enum Level {

    /**
     * 错误
     */
    ERROR(ERROR_INT, "ERROR"),
    /**
     * 警告
     */
    WARN(WARN_INT, "WARN"),
    /**
     * 信息
     */
    INFO(INFO_INT, "INFO"),
    /**
     * 调试
     */
    DEBUG(DEBUG_INT, "DEBUG"),
    /**
     * 追踪
     */
    TRACE(TRACE_INT, "TRACE"),
    ;

    /**
     * 等级的整数值
     */
    private final int levelInt;
    /**
     * 等级的字符串值
     */
    private final String levelStr;

    Level(int i, String s) {
        levelInt = i;
        levelStr = s;
    }

    public int toInt() {
        return levelInt;
    }

    public static Level intToLevel(int levelInt) {
        switch (levelInt) {
        case (TRACE_INT):
            return TRACE;
        case (DEBUG_INT):
            return DEBUG;
        case (INFO_INT):
            return INFO;
        case (WARN_INT):
            return WARN;
        case (ERROR_INT):
            return ERROR;
        default:
            throw new IllegalArgumentException("Level integer [" + levelInt + "] not recognized.");
        }
    }

    /**
     * Returns the string representation of this Level.
     */
    public String toString() {
        return levelStr;
    }

}
