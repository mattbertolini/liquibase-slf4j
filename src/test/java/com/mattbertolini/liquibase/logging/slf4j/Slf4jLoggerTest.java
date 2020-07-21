///*
// * Copyright (c) 2012-2015 Matt Bertolini
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
// * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
// * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
// * permit persons to whom the Software is furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
// * Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
// * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
// * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// */
//
package com.mattbertolini.liquibase.logging.slf4j;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;

///**
// * @author Matt Bertolini
// */
public class Slf4jLoggerTest {
//    private Logger unitTestLogger;
//    private ListAppender<ILoggingEvent> listAppender;
//
//    @Before
//    public void setUp() {
//        this.unitTestLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
//        this.unitTestLogger.setLevel(Level.DEBUG);
//        this.listAppender = (ListAppender<ILoggingEvent>) unitTestLogger.getAppender("list");
//        this.listAppender.list.clear();
//    }
//
//    @After
//    public void tearDown() {
//        this.listAppender.list.clear();
//    }
//
    @Ignore
    @Test
    public void testSevereWithMessage() {
        String expectedChangeLogName = "/test/path";
        String expectedChangeSetName = "TestChangeSet";
        String expectedMessage = "This is a severe test.";
        int expectedCount = 1;
        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;

        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);

//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.severe(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.ERROR, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
    }
//
//    @Test
//    public void testSevereWithMessageLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a severe test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.severe(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testSevereWithMessageNoOptionalData() {
//        String expectedMessage = "This is a severe test.";
//        int expectedCount = 1;
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(null);
//        slf4jLogger.setChangeSet(null);
//        slf4jLogger.severe(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.ERROR, loggingEvent.getLevel());
//        Assert.assertEquals(expectedMessage, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testSevereWithMessageAndThrowable() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.severe(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.ERROR, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
//    }
//
//    @Test
//    public void testSevereWithMessageAndThrowableLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.severe(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testWarningWithMessage() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a warning test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.warning(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.WARN, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testWarningWithMessageLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a warning test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.warning(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testWarningWithMessageNoOptionalData() {
//        String expectedMessage = "This is a warning test.";
//        int expectedCount = 1;
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(null);
//        slf4jLogger.setChangeSet(null);
//        slf4jLogger.warning(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.WARN, loggingEvent.getLevel());
//        Assert.assertEquals(expectedMessage, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testWarningWithMessageAndThrowable() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a warning test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.warning(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.WARN, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
//    }
//
//    @Test
//    public void testWarningWithMessageAndThrowableLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.warning(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testInfoWithMessage() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.info(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.INFO, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testInfoWithMessageLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.info(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testInfoWithMessageNoOptionalData() {
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 1;
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(null);
//        slf4jLogger.setChangeSet(null);
//        slf4jLogger.info(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.INFO, loggingEvent.getLevel());
//        Assert.assertEquals(expectedMessage, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testInfoWithMessageAndThrowable() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.info(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.INFO, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
//    }
//
//    @Test
//    public void testInfoWithMessageAndThrowableLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.info(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testDebugWithMessage() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a debug test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.debug(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.DEBUG, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testDebugWithMessageLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a debug test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.debug(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testDebugWithMessageNoOptionalData() {
//        String expectedMessage = "This is a debug test.";
//        int expectedCount = 1;
//
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(null);
//        slf4jLogger.setChangeSet(null);
//        slf4jLogger.debug(expectedMessage);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.DEBUG, loggingEvent.getLevel());
//        Assert.assertEquals(expectedMessage, loggingEvent.getFormattedMessage());
//    }
//
//    @Test
//    public void testDebugWithMessageAndThrowable() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 1;
//        String expectedStr = expectedChangeLogName + ": " + expectedChangeSetName + ": " + expectedMessage;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.debug(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//        ILoggingEvent loggingEvent = this.listAppender.list.iterator().next();
//        Assert.assertEquals(Level.DEBUG, loggingEvent.getLevel());
//        Assert.assertEquals(expectedStr, loggingEvent.getFormattedMessage());
//        Assert.assertEquals(expectedException.getClass().getName(), loggingEvent.getThrowableProxy().getClassName());
//    }
//
//    @Test
//    public void testDebugWithMessageAndThrowableLogLevelDisabled() {
//        String expectedChangeLogName = "/test/path";
//        String expectedChangeSetName = "TestChangeSet";
//        String expectedMessage = "This is a info test.";
//        int expectedCount = 0;
//
//        DatabaseChangeLog mockChangeLog = Mockito.mock(DatabaseChangeLog.class);
//        Mockito.when(mockChangeLog.getFilePath()).thenReturn(expectedChangeLogName);
//        ChangeSet mockChangeSet = Mockito.mock(ChangeSet.class);
//        Mockito.when(mockChangeSet.toString(false)).thenReturn(expectedChangeSetName);
//
//        this.unitTestLogger.setLevel(Level.OFF);
//        Exception expectedException = new RuntimeException("Exception");
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        slf4jLogger.setName("unit.test");
//        slf4jLogger.setChangeLog(mockChangeLog);
//        slf4jLogger.setChangeSet(mockChangeSet);
//        slf4jLogger.debug(expectedMessage, expectedException);
//        Assert.assertEquals(expectedCount, this.listAppender.list.size());
//    }
//
//    @Test
//    public void testGetPriority() {
//        Slf4jLogger slf4jLogger = new Slf4jLogger();
//        // Just for the coverage. Does nothing.
//        slf4jLogger.setLogLevel(null, null);
//        Assert.assertEquals(5, slf4jLogger.getPriority());
//    }
}
