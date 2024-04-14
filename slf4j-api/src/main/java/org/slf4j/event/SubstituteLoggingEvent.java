package org.slf4j.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/**
 * 替代的日志记录事件，用户把数据传递给SLF4J API的最小接口。
 */
public class SubstituteLoggingEvent implements LoggingEvent {

    /**
     * 级别
     */
    Level level;
    /**
     * 日志记录事件中的标记者列表
     */
    List<Marker> markers;
    /**
     * 日志记录器实例的名称
     */
    String loggerName;
    /**
     * 替代的日志记录器实例
     */
    SubstituteLogger logger;
    /**
     * 线程名称
     */
    String threadName;
    /**
     * 格式化消息
     */
    String message;
    /**
     * 参数数组
     */
    Object[] argArray;
    /**
     * 键值对列表
     */
    List<KeyValuePair> keyValuePairList;

    /**
     * 创建时间戳
     */
    long timeStamp;
    /**
     * 根因的异常调用栈实例
     */
    Throwable throwable;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void addMarker(Marker marker) {
        if (marker == null)
            return;

        if (markers == null) {
            markers = new ArrayList<>(2);
        }

        markers.add(marker);
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public SubstituteLogger getLogger() {
        return logger;
    }

    public void setLogger(SubstituteLogger logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgumentArray() {
        return argArray;
    }

    public void setArgumentArray(Object[] argArray) {
        this.argArray = argArray;
    }

    @Override
    public List<Object> getArguments() {
        if (argArray == null) {
            return null;
        }
        return Arrays.asList(argArray);
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public List<KeyValuePair> getKeyValuePairs() {
        return keyValuePairList;
    }
}
