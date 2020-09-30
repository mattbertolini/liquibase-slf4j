/*
 * Copyright (c) 2012-2020 Matt Bertolini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.mattbertolini.liquibase.logging.slf4j;

import liquibase.logging.LogMessageFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.logging.Level;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Matt Bertolini
 */
class Slf4jLoggerTest {

    private Logger delegate;
    private TestingFilter filter;
    private Slf4jLogger logger;

    @BeforeEach
    void setUp() {
        delegate = mock(Logger.class);
        filter = new TestingFilter();
        logger = new Slf4jLogger(delegate, filter);
    }

    // log method

    @Test
    void logWithSevereLevel() {
        String message = "severe test";
        logger.log(Level.SEVERE, message, null);
        verify(delegate).error(message, (Throwable) null);
    }

    @Test
    void logWithSevereLevelUsingFilter() {
        String message = "severe test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.SEVERE, message, null);
        verify(delegate).error(filteredMessage, (Throwable) null);
    }

    @Test
    void logWithWarningLevel() {
        String message = "warning test";
        logger.log(Level.WARNING, message, null);
        verify(delegate).warn(message, (Throwable) null);
    }

    @Test
    void logWithWarningLevelUsingFilter() {
        String message = "warning test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.WARNING, message, null);
        verify(delegate).warn(filteredMessage, (Throwable) null);
    }

    @Test
    void logWithInfoLevel() {
        String message = "info test";
        logger.log(Level.INFO, message, null);
        verify(delegate).info(message, (Throwable) null);
    }

    @Test
    void logWithInfoLevelUsingFilter() {
        String message = "info test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.INFO, message, null);
        verify(delegate).info(filteredMessage, (Throwable) null);
    }

    @Test
    void logWithConfigLevel() {
        String message = "config test";
        logger.log(Level.CONFIG, message, null);
        verify(delegate).info(message, (Throwable) null);
    }

    @Test
    void logWithConfigLevelUsingFilter() {
        String message = "config test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.CONFIG, message, null);
        verify(delegate).info(filteredMessage, (Throwable) null);
    }

    @Test
    void logWithFineLevel() {
        String message = "fine test";
        logger.log(Level.FINE, message, null);
        verify(delegate).debug(message, (Throwable) null);
    }

    @Test
    void logWithFineLevelUsingFilter() {
        String message = "fine test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.FINE, message, null);
        verify(delegate).debug(filteredMessage, (Throwable) null);
    }

    @Test
    void logWithFinestLevel() {
        String message = "finest test";
        logger.log(Level.FINEST, message, null);
        verify(delegate).trace(message, (Throwable) null);
    }

    @Test
    void logWithFinestLevelUsingFilter() {
        String message = "finest test";
        String filteredMessage = filter.setExpected("filtered");
        logger.log(Level.FINEST, message, null);
        verify(delegate).trace(filteredMessage, (Throwable) null);
    }


    // Severe level
    
    @Test
    void logsSevereWithMessage() {
        String expected = "This is a severe test.";
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(expected);
        verify(delegate).error(expected);
    }

    @Test
    void logsSevereWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a severe test.";
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(expected, exception);
        verify(delegate).error(expected, exception);
    }

    @Test
    void doesNotLogSevereWhenLogLevelDisabled() {
        when(delegate.isErrorEnabled()).thenReturn(false);
        logger.severe("do not log");
        verify(delegate, never()).error(anyString());
    }

    @Test
    void doesNotLogSevereWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isErrorEnabled()).thenReturn(false);
        logger.severe("do not log", exception);
        verify(delegate, never()).error(anyString(), any(Throwable.class));
    }

    @Test
    void logsSevereWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(message);
        verify(delegate).error(filteredMessage);
    }

    @Test
    void logsSevereWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(message, exception);
        verify(delegate).error(eq(filteredMessage), any(Throwable.class));
    }

    // Warning level

    @Test
    void logsWarningWithMessage() {
        String expected = "This is a warning test.";
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(expected);
        verify(delegate).warn(expected);
    }

    @Test
    void logsWarningWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a warning test.";
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(expected, exception);
        verify(delegate).warn(expected, exception);
    }

    @Test
    void doesNotLogWarningWhenLogLevelDisabled() {
        when(delegate.isWarnEnabled()).thenReturn(false);
        logger.warning("do not log");
        verify(delegate, never()).warn(anyString());
    }

    @Test
    void doesNotLogWarningWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isWarnEnabled()).thenReturn(false);
        logger.warning("do not log", exception);
        verify(delegate, never()).warn(anyString(), any(Throwable.class));
    }

    @Test
    void logsWarningWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(message);
        verify(delegate).warn(filteredMessage);
    }

    @Test
    void logsWarningWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(message, exception);
        verify(delegate).warn(eq(filteredMessage), any(Throwable.class));
    }

    // Info level

    @Test
    void logsInfoWithMessage() {
        String expected = "This is a info test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(expected);
        verify(delegate).info(expected);
    }

    @Test
    void logsInfoWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a info test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(expected, exception);
        verify(delegate).info(expected, exception);
    }

    @Test
    void doesNotLogInfoWhenLogLevelDisabled() {
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.info("do not log");
        verify(delegate, never()).info(anyString());
    }

    @Test
    void doesNotLogInfoWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.info("do not log", exception);
        verify(delegate, never()).info(anyString(), any(Throwable.class));
    }

    @Test
    void logsInfoWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(message);
        verify(delegate).info(filteredMessage);
    }

    @Test
    void logsInfoWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(message, exception);
        verify(delegate).info(eq(filteredMessage), any(Throwable.class));
    }

    // Config level
    
    @Test
    void logsConfigWithMessage() {
        String expected = "This is a config test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(expected);
        verify(delegate).info(expected);
    }

    @Test
    void logsConfigWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a config test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(expected, exception);
        verify(delegate).info(expected, exception);
    }

    @Test
    void doesNotLogConfigWhenLogLevelDisabled() {
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.config("do not log");
        verify(delegate, never()).info(anyString());
    }

    @Test
    void doesNotLogConfigWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.config("do not log", exception);
        verify(delegate, never()).info(anyString(), any(Throwable.class));
    }

    @Test
    void logsConfigWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(message);
        verify(delegate).info(filteredMessage);
    }

    @Test
    void logsConfigWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(message, exception);
        verify(delegate).info(eq(filteredMessage), any(Throwable.class));
    }

    // Fine level

    @Test
    void logsFineWithMessage() {
        String expected = "This is a fine test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(expected);
        verify(delegate).debug(expected);
    }

    @Test
    void logsFineWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a fine test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(expected, exception);
        verify(delegate).debug(expected, exception);
    }

    @Test
    void doesNotLogFineWhenLogLevelDisabled() {
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.fine("do not log");
        verify(delegate, never()).debug(anyString());
    }

    @Test
    void doesNotLogFineWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.fine("do not log", exception);
        verify(delegate, never()).debug(anyString(), any(Throwable.class));
    }

    @Test
    void logsFineWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(message);
        verify(delegate).debug(filteredMessage);
    }

    @Test
    void logsFineWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(message, exception);
        verify(delegate).debug(eq(filteredMessage), any(Throwable.class));
    }

    // Debug level (deprecated). Delegates to fine

    @Test
    void logsDebugWithMessage() {
        String expected = "This is a debug test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(expected);
        verify(delegate).debug(expected);
    }

    @Test
    void logsDebugWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a debug test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(expected, exception);
        verify(delegate).debug(expected, exception);
    }

    @Test
    void doesNotLogDebugWhenLogLevelDisabled() {
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.debug("do not log");
        verify(delegate, never()).debug(anyString());
    }

    @Test
    void doesNotLogDebugWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.debug("do not log", exception);
        verify(delegate, never()).debug(anyString(), any(Throwable.class));
    }

    @Test
    void logsDebugWithFilteredMessage() {
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(message);
        verify(delegate).debug(filteredMessage);
    }

    @Test
    void logsDebugWithFilteredMessageAndException() {
        RuntimeException exception = new RuntimeException("Exception");
        String message = "not filtered";
        String filteredMessage = filter.setExpected("filtered");
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(message, exception);
        verify(delegate).debug(eq(filteredMessage), any(Throwable.class));
    }

    @Test
    void worksWithNullFilter() {
        String message = "message";
        Slf4jLogger slf4jLogger = new Slf4jLogger(delegate, null);
        when(delegate.isInfoEnabled()).thenReturn(true);
        slf4jLogger.info(message);
        verify(delegate).info(message);
    }

    private static class TestingFilter implements LogMessageFilter {
        private String expected;

        public TestingFilter() {
            reset();
        }

        @Override
        public String filterMessage(String message) {
            if (expected != null) {
                return expected;
            }
            return message;
        }

        public void reset() {
            expected = null;
        }

        public String setExpected(String expected) {
            this.expected = expected;
            return expected;
        }
    }
}
