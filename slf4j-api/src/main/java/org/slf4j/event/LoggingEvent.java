package org.slf4j.event;

import java.util.List;

import org.slf4j.Marker;

/**
 * The minimal interface sufficient for the restitution of data passed
 * by the user to the SLF4J API.
 * 日志记录事件，用户把数据传递给SLF4J API的最小接口。
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.7.15
 */
public interface LoggingEvent {

    /**
     * @return 级别
     */
    Level getLevel();

    /**
     * @return 日志记录者实例的名称
     */
    String getLoggerName();

    /**
     * @return 格式化消息
     */
    String getMessage();

    /**
     * @return 参数列表
     */
    List<Object> getArguments();

    /**
     * @return 参数数组
     */
    Object[] getArgumentArray();

    /**
     * List of markers in the event, might be null.
     * 日志记录事件中的标记者列表
     * @return markers in the event, might be null.
     */
    List<Marker> getMarkers();

    /**
     * @return 键值对列表
     */
    List<KeyValuePair> getKeyValuePairs();

    /**
     * @return 根因的异常调用栈
     */
    Throwable getThrowable();

    /**
     * @return 创建时间戳
     */
    long getTimeStamp();

    /**
     * @return 线程名称
     */
    String getThreadName();
 
    /**
     * Returns the presumed caller boundary provided by the logging library (not the user of the library). 
     * Null by default.
     * 调用者边界
     *  
     * @return presumed caller, null by default.
     */
    default String getCallerBoundary() {
        return null;
    }
}
