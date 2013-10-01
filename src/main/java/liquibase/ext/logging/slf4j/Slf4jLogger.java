/*
 * Copyright (c) 2013 Matt Bertolini
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

import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.logging.core.AbstractLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of the Liquibase Logger that sends log output to SLF4J.
 *
 * @author Matt Bertolini
 */
public class Slf4jLogger extends AbstractLogger {
    private static final int PRIORITY = 5;

    private Logger logger;
    private String changeLogName = null;
    private String changeSetName = null;

    /**
     * Takes the given logger name argument and associates it with a SLF4J logger.
     *
     * @param name The name of the logger.
     */
    @Override
    public void setName(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }

    /**
     * This method does nothing in this implementation
     *
     * @param logLevel Log level
     * @param logFile Log file
     */
    @Override
    public void setLogLevel(String logLevel, String logFile) {
        // Do nothing
    }

    /**
     * Logs an severe message. Calls SLF4J {@link Logger#error(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void severe(String message) {
        this.logger.error("{}: {}: {}", changeLogName, changeSetName, message);
    }

    /**
     * Logs a severe message. Calls SLF4J {@link Logger#error(String, Throwable)}.
     *
     * @param message The message to log
     * @param throwable The exception to log.
     */
    @Override
    public void severe(String message, Throwable throwable) {
        if(this.logger.isErrorEnabled()) {
            this.logger.error(changeLogName + ": " + changeSetName + ": " + message, throwable);
        }
    }

    /**
     * Logs a warning message. Calls SLF4J {@link Logger#warn(String)}
     *
     * @param message The message to log.
     */
    @Override
    public void warning(String message) {
        this.logger.warn("{}: {}: {}", changeLogName, changeSetName, message);
    }

    /**
     * Logs a warning message. Calls SLF4J {@link Logger#warn(String, Throwable)}.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    @Override
    public void warning(String message, Throwable throwable) {
        if(this.logger.isWarnEnabled()) {
            this.logger.warn(changeLogName + ": " + changeSetName + ": " + message, throwable);
        }
    }

    /**
     * Log an info message. Calls SLF4J {@link Logger#info(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void info(String message) {
        this.logger.info("{}: {}: {}", changeLogName, changeSetName, message);
    }

    /**
     * Log an info message. Calls SLF4J {@link Logger#info(String, Throwable)}.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    @Override
    public void info(String message, Throwable throwable) {
        if(this.logger.isInfoEnabled()) {
            this.logger.info(changeLogName + ": " + changeSetName + ": " + message, throwable);
        }
    }

    /**
     * Log a debug message. Calls SLF4J {@link Logger#debug(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void debug(String message) {
        this.logger.debug("{}: {}: {}", changeLogName, changeSetName, message);
    }

    /**
     * Log a debug message. Calls SLF4J {@link Logger#debug(String, Throwable)}.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    @Override
    public void debug(String message, Throwable throwable) {
        if(this.logger.isDebugEnabled()) {
            this.logger.debug(changeLogName + ": " + changeSetName + ": " + message, throwable);
        }
    }

    /**
     * Gets the logger priority for this logger. The priority is used by Liquibase to determine which logger to use.
     * The logger with the highest priority will be used. This implementation's priority is set to 5. Remove loggers
     * with higher priority numbers if needed.
     *
     * @return An integer (5)
     */
    @Override
    public int getPriority() {
        return PRIORITY;
    }

    @Override
    public void setChangeLog(DatabaseChangeLog databaseChangeLog) {
        changeLogName = (databaseChangeLog == null) ? null : databaseChangeLog.getFilePath();
    }

    @Override
    public void setChangeSet(ChangeSet changeSet) {
        changeSetName = (changeSet == null ? null : changeSet.toString(false));
    }
}
