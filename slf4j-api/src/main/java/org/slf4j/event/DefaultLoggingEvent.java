package org.slf4j.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * A default implementation of {@link LoggingEvent}.
 * 日志记录事件的默认实现
 * 
 * @author Ceki G&uuml;lc&uuml;
 *
 * @since 2.0.0
 */
public class DefaultLoggingEvent implements LoggingEvent {

    /**
     * 日志记录者实例
     */
    Logger logger;
    /**
     * 级别
     */
    Level level;

    /**
     * 格式化消息
     */
    String message;
    /**
     * 日志记录事件中的标记者列表
     */
    List<Marker> markers;
    /**
     * 参数列表
     */
    List<Object> arguments;
    /**
     * 键值对列表
     */
    List<KeyValuePair> keyValuePairs;

    /**
     * 根因的异常调用栈
     */
    Throwable throwable;
    /**
     * 线程名称
     */
    String threadName;
    /**
     * 创建时间戳
     */
    long timeStamp;

    /**
     * 调用者边界
     */
    String callerBoundary;

    public DefaultLoggingEvent(Level level, Logger logger) {
        this.logger = logger;
        this.level = level;
    }

    public void addMarker(Marker marker) {
        if (markers == null) {
            markers = new ArrayList<>(2);
        }
        markers.add(marker);
    }

    @Override
    public List<Marker> getMarkers() {
        return markers;
    }

    public void addArgument(Object p) {
        getNonNullArguments().add(p);
    }

    public void addArguments(Object... args) {
        getNonNullArguments().addAll(Arrays.asList(args));
    }

    private List<Object> getNonNullArguments() {
        if (arguments == null) {
            // 参数，一般不超过3个
            arguments = new ArrayList<>(3);
        }
        return arguments;
    }

    @Override
    public List<Object> getArguments() {
        return arguments;
    }

    @Override
    public Object[] getArgumentArray() {
        if (arguments == null)
            return null;
        return arguments.toArray();
    }

    public void addKeyValue(String key, Object value) {
        getNonnullKeyValuePairs().add(new KeyValuePair(key, value));
    }

    private List<KeyValuePair> getNonnullKeyValuePairs() {
        if (keyValuePairs == null) {
            keyValuePairs = new ArrayList<>(4);
        }
        return keyValuePairs;
    }

    @Override
    public List<KeyValuePair> getKeyValuePairs() {
        return keyValuePairs;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable cause) {
        this.throwable = cause;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public String getLoggerName() {
        return logger.getName();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setCallerBoundary(String fqcn) {
        this.callerBoundary = fqcn;
    }
    
    public String getCallerBoundary() {
        return callerBoundary;
    }
}
