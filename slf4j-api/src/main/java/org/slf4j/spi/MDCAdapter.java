/**
 * Copyright (c) 2004-2011 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.spi;

import java.util.Deque;
import java.util.Map;

/**
 * This interface abstracts the service offered by various MDC
 * implementations.
 * MDC适配者，本接口抽象了各种 MDC 实现提供的服务。
 * 
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.4.1
 */
public interface MDCAdapter {

    /**
     * Put a context value (the <code>val</code> parameter) as identified with
     * the <code>key</code> parameter into the current thread's context map. 
     * The <code>key</code> parameter cannot be null. The <code>val</code> parameter
     * can be null only if the underlying implementation supports it.
     * 将与 key 参数标识的上下文值（val 参数）放入当前线程的上下文映射中。
     * 
     * <p>If the current thread does not have a context map it is created as a side
     * effect of this call.
     */
    void put(String key, String val);

    /**
     * Get the context identified by the <code>key</code> parameter.
     * The <code>key</code> parameter cannot be null.
     * 获取由键参数标识的诊断上下文。
     * 
     * @return the string value identified by the <code>key</code> parameter.
     */
    String get(String key);

    /**
     * Remove the context identified by the <code>key</code> parameter.
     * The <code>key</code> parameter cannot be null. 
     * 
     * <p>
     * This method does nothing if there is no previous value 
     * associated with <code>key</code>.
     */
    void remove(String key);

    /**
     * Clear all entries in the MDC.
     * 清除 MDC 中的所有条目。
     */
    void clear();

    /**
     * Return a copy of the current thread's context map, with keys and 
     * values of type String. Returned value may be null.
     * 返回当前线程的上下文映射的副本，其中包含字符串类型的键和值。
     * 返回值可能为 null。
     * 
     * @return A copy of the current thread's context map. May be null.
     * @since 1.5.1
     */
    Map<String, String> getCopyOfContextMap();

    /**
     * Set the current thread's context map by first clearing any existing 
     * map and then copying the map passed as parameter. The context map 
     * parameter must only contain keys and values of type String.
     * 通过首先清除任何现有映射，然后复制作为参数传递的映射来设置当前线程的上下文映射。
     * 
     * Implementations must support null valued map passed as parameter.
     * 
     * @param contextMap must contain only keys and values of type String
     * 
     * @since 1.5.1
     */
    void setContextMap(Map<String, String> contextMap);
    
    /**
     * Push a value into the deque(stack) referenced by 'key'.
     *      
     * @param key identifies the appropriate stack
     * @param value the value to push into the stack
     * @since 2.0.0
     */
    public void pushByKey(String key, String value);
    
    /**
     * Pop the stack referenced by 'key' and return the value possibly null.
     * 
     * @param key identifies the deque(stack)
     * @return the value just popped. May be null/
     * @since 2.0.0
     */
    public String popByKey(String key);

    /**
     * Returns a copy of the deque(stack) referenced by 'key'. May be null.
     * 
     * @param key identifies the  stack
     * @return copy of stack referenced by 'key'. May be null.
     * 
     * @since 2.0.0
     */
    public Deque<String>  getCopyOfDequeByKey(String key);
    

    /**
     * Clear the deque(stack) referenced by 'key'. 
     * 
     * @param key identifies the  stack
     * 
     * @since 2.0.0
     */
    public void clearDequeByKey(String key);
    
}
