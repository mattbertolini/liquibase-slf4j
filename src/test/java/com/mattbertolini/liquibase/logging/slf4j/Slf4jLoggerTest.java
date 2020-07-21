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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Matt Bertolini
 */
public class Slf4jLoggerTest {

    private Logger delegate;
    private Slf4jLogger logger;

    @BeforeEach
    public void setUp() {
        delegate = mock(Logger.class);
        logger = new Slf4jLogger(delegate);
    }

    // Severe level
    
    @Test
    public void logsSevereWithMessage() {
        String expected = "This is a severe test.";
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(expected);
        verify(delegate).error(expected);
    }

    @Test
    public void logsSevereWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a severe test.";
        when(delegate.isErrorEnabled()).thenReturn(true);
        logger.severe(expected, exception);
        verify(delegate).error(expected, exception);
    }

    @Test
    public void doesNotLogSevereWhenLogLevelDisabled() {
        when(delegate.isErrorEnabled()).thenReturn(false);
        logger.severe("do not log");
        verify(delegate, never()).error(anyString());
    }

    @Test
    public void doesNotLogSevereWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isErrorEnabled()).thenReturn(false);
        logger.severe("do not log", exception);
        verify(delegate, never()).error(anyString(), any(Throwable.class));
    }

    // Warning level

    @Test
    public void logsWarningWithMessage() {
        String expected = "This is a warning test.";
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(expected);
        verify(delegate).warn(expected);
    }

    @Test
    public void logsWarningWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a warning test.";
        when(delegate.isWarnEnabled()).thenReturn(true);
        logger.warning(expected, exception);
        verify(delegate).warn(expected, exception);
    }

    @Test
    public void doesNotLogWarningWhenLogLevelDisabled() {
        when(delegate.isWarnEnabled()).thenReturn(false);
        logger.warning("do not log");
        verify(delegate, never()).warn(anyString());
    }

    @Test
    public void doesNotLogWarningWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isWarnEnabled()).thenReturn(false);
        logger.warning("do not log", exception);
        verify(delegate, never()).warn(anyString(), any(Throwable.class));
    }

    // Info level

    @Test
    public void logsInfoWithMessage() {
        String expected = "This is a info test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(expected);
        verify(delegate).info(expected);
    }

    @Test
    public void logsInfoWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a info test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.info(expected, exception);
        verify(delegate).info(expected, exception);
    }

    @Test
    public void doesNotLogInfoWhenLogLevelDisabled() {
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.info("do not log");
        verify(delegate, never()).info(anyString());
    }

    @Test
    public void doesNotLogInfoWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.info("do not log", exception);
        verify(delegate, never()).info(anyString(), any(Throwable.class));
    }

    // Config level
    
    @Test
    public void logsConfigWithMessage() {
        String expected = "This is a config test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(expected);
        verify(delegate).info(expected);
    }

    @Test
    public void logsConfigWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a config test.";
        when(delegate.isInfoEnabled()).thenReturn(true);
        logger.config(expected, exception);
        verify(delegate).info(expected, exception);
    }

    @Test
    public void doesNotLogConfigWhenLogLevelDisabled() {
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.config("do not log");
        verify(delegate, never()).info(anyString());
    }

    @Test
    public void doesNotLogConfigWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isInfoEnabled()).thenReturn(false);
        logger.config("do not log", exception);
        verify(delegate, never()).info(anyString(), any(Throwable.class));
    }

    // Fine level

    @Test
    public void logsFineWithMessage() {
        String expected = "This is a fine test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(expected);
        verify(delegate).debug(expected);
    }

    @Test
    public void logsFineWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a fine test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.fine(expected, exception);
        verify(delegate).debug(expected, exception);
    }

    @Test
    public void doesNotLogFineWhenLogLevelDisabled() {
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.fine("do not log");
        verify(delegate, never()).debug(anyString());
    }

    @Test
    public void doesNotLogFineWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.fine("do not log", exception);
        verify(delegate, never()).debug(anyString(), any(Throwable.class));
    }

    // Debug level (deprecated). Delegates to fine

    @Test
    public void logsDebugWithMessage() {
        String expected = "This is a debug test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(expected);
        verify(delegate).debug(expected);
    }

    @Test
    public void logsDebugWithMessageAndThrowable() {
        RuntimeException exception = new RuntimeException("Exception");
        String expected = "This is a debug test.";
        when(delegate.isDebugEnabled()).thenReturn(true);
        logger.debug(expected, exception);
        verify(delegate).debug(expected, exception);
    }

    @Test
    public void doesNotLogDebugWhenLogLevelDisabled() {
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.debug("do not log");
        verify(delegate, never()).debug(anyString());
    }

    @Test
    public void doesNotLogDebugWithThrowableWhenLogLevelDisabled() {
        RuntimeException exception = new RuntimeException("Exception");
        when(delegate.isDebugEnabled()).thenReturn(false);
        logger.debug("do not log", exception);
        verify(delegate, never()).debug(anyString(), any(Throwable.class));
    }
}
