/*
 * Copyright (c) 2012 Matt Bertolini>
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

package liquibase.ext.logging.slf4j;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * @author Matt Bertolini
 */
public class Slf4jLoggerTest {
    @Test
    public void testSevereWithMessage() {
        int expectedCount = 1;
        String expectedStr = "This is a severe test.";
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.severe(expectedStr);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.ERROR, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
    }

    @Test
    public void testSevereWithMessageAndThrowable() {
        int expectedCount = 1;
        String expectedStr = "This is a severe test.";
        Exception expectedException = new RuntimeException("Exception");
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.severe(expectedStr, expectedException);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.ERROR, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
    }

    @Test
    public void testWarningWithMessage() {
        int expectedCount = 1;
        String expectedStr = "This is a warning test.";
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.warning(expectedStr);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.WARN, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
    }

    @Test
    public void testWarningWithMessageAndThrowable() {
        int expectedCount = 1;
        String expectedStr = "This is a warning test.";
        Exception expectedException = new RuntimeException("Exception");
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.warning(expectedStr, expectedException);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.WARN, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
    }

    @Test
    public void testInfoWithMessage() {
        int expectedCount = 1;
        String expectedStr = "This is a info test.";
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.info(expectedStr);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.INFO, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
    }

    @Test
    public void testInfoWithMessageAndThrowable() {
        int expectedCount = 1;
        String expectedStr = "This is a info test.";
        Exception expectedException = new RuntimeException("Exception");
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.info(expectedStr, expectedException);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.INFO, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
    }

    @Test
    public void testDebugWithMessage() {
        int expectedCount = 1;
        String expectedStr = "This is a debug test.";
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.debug(expectedStr);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.DEBUG, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
    }

    @Test
    public void testDebugWithMessageAndThrowable() {
        int expectedCount = 1;
        String expectedStr = "This is a debug test.";
        Exception expectedException = new RuntimeException("Exception");
        Logger unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        ListAppender<ILoggingEvent> listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
        listAppender.list.clear();
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        slf4jLogger.setName("unit.test");
        slf4jLogger.debug(expectedStr, expectedException);
        Assert.assertEquals(expectedCount, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.iterator().next();
        Assert.assertEquals(Level.DEBUG, loggingEvent.getLevel());
        Assert.assertEquals(expectedStr, loggingEvent.getMessage());
        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
    }

    @Test
    public void testGetPriority() {
        Slf4jLogger slf4jLogger = new Slf4jLogger();
        // Just for the coverage. Does nothing.
        slf4jLogger.setLogLevel(null, null);
        Assert.assertEquals(5, slf4jLogger.getPriority());
    }
}
