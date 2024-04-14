package org.slf4j.spi;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * This interface based on {@link java.util.ServiceLoader} paradigm.
 * SLF4J服务提供者，本接口基于服务定位者{@link java.util.ServiceLoader}范式。
 * 
 * <p>It replaces the old static-binding mechanism used in SLF4J versions 1.0.x to 1.7.x.
 * 它取代了 SLF4J 版本 1.0.x 至 1.7.x 中使用的旧的静态绑定机制。
 *
 * @author Ceki G&uml;lc&uml;
 * @since 1.8
 */
public interface SLF4JServiceProvider {

    /**
     * Return the instance of {@link ILoggerFactory} that 
     * {@link org.slf4j.LoggerFactory} class should bind to.
     * 返回日志记录器工厂实例，LoggerFactory 类应绑定到的 ILoggerFactory 实例。
     * 
     * @return instance of {@link ILoggerFactory} 
     */
    ILoggerFactory getLoggerFactory();

    /**
     * Return the instance of {@link IMarkerFactory} that 
     * {@link org.slf4j.MarkerFactory} class should bind to.
     * 
     * @return instance of {@link IMarkerFactory} 
     */
    public IMarkerFactory getMarkerFactory();

    /**
     * Return the instance of {@link MDCAdapter} that
     * {@link MDC} should bind to.
     * 返回 MDC 应绑定到的 MDCAdapter 实例。
     * 
     * @return instance of {@link MDCAdapter} 
     */
    MDCAdapter getMDCAdapter();

    /**
     * Return the maximum API version for SLF4J that the logging
     * implementation supports.
     *
     * <p>For example: {@code "2.0.1"}.
     *
     * @return the string API version.
     */
    String getRequestedApiVersion();

    /**
     * Initialize the logging back-end.
     * 初始化日志记录后端。
     * 
     * <p><b>WARNING:</b> This method is intended to be called once by 
     * {@link LoggerFactory} class and from nowhere else. 
     * 
     */
    void initialize();
}
