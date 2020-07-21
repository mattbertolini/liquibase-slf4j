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

import liquibase.logging.core.AbstractLogger;
import org.slf4j.Logger;

import java.util.logging.Level;

/**
 * An implementation of the Liquibase Logger that sends log output to SLF4J.
 *
 * @author Matt Bertolini
 */
public class Slf4jLogger extends AbstractLogger {

    private static final int TRACE_THRESHOLD = Level.FINEST.intValue();
    private static final int DEBUG_THRESHOLD = Level.FINE.intValue();
    private static final int INFO_THRESHOLD = Level.INFO.intValue();
    private static final int WARN_THRESHOLD = Level.WARNING.intValue();

    private final Logger logger;
    
    Slf4jLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(Level level, String message, Throwable e) {
        int levelValue = level.intValue();
        if (levelValue <= TRACE_THRESHOLD) {
            logger.trace(message, e);
        } else if (levelValue <= DEBUG_THRESHOLD) {
            logger.debug(message, e);
        } else if (levelValue <= INFO_THRESHOLD) {
            logger.info(message, e);
        } else if (levelValue <= WARN_THRESHOLD) {
            logger.warn(message, e);
        } else {
            logger.error(message, e);
        }
    }

    /**
     * Logs an severe message. Calls SLF4J {@link Logger#error(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void severe(String message) {
        if(this.logger.isErrorEnabled()) {
            this.logger.error(message);
        }
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
            this.logger.error(message, throwable);
        }
    }

    /**
     * Logs a warning message. Calls SLF4J {@link Logger#warn(String)}
     *
     * @param message The message to log.
     */
    @Override
    public void warning(String message) {
        if(this.logger.isWarnEnabled()) {
            this.logger.warn(message);
        }
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
            this.logger.warn(message, throwable);
        }
    }

    /**
     * Log an info message. Calls SLF4J {@link Logger#info(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void info(String message) {
        if(this.logger.isInfoEnabled()) {
            this.logger.info(message);
        }
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
            this.logger.info(message, throwable);
        }
    }

    /**
     * Log a fine message. Calls SLF4J {@link Logger#debug(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void fine(String message) {
        if(logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    /**
     * Log a fine message. Calls SLF4J {@link Logger#debug(String, Throwable)}.
     *
     * @param message The message to log.
     * @param e The exception to log.
     */
    @Override
    public void fine(String message, Throwable e) {
        if(logger.isDebugEnabled()) {
            logger.debug(message, e);
        }
    }
}
