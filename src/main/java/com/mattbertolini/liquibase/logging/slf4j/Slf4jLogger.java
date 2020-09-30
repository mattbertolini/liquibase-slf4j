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
import liquibase.logging.core.AbstractLogger;
import org.slf4j.Logger;

import java.util.logging.Level;

/**
 * <p>An implementation of the Liquibase Logger that sends log output to SLF4J.</p>
 *
 * <p><strong>Log level Mappings:</strong>
 *  <table summary="log level mappings">
 *     <tr>
 *         <th>Liquibase Level</th>
 *         <th>SLF4J Level</th>
 *     </tr>
 *     <tr>
 *         <td>Debug</td>
 *         <td>Debug</td>
 *     </tr>
 *     <tr>
 *         <td>Fine</td>
 *         <td>Debug</td>
 *     </tr>
 *     <tr>
 *         <td>Config</td>
 *         <td>Info</td>
 *     </tr>
 *     <tr>
 *         <td>Info</td>
 *         <td>Info</td>
 *     </tr>
 *     <tr>
 *         <td>Warning</td>
 *         <td>Warn</td>
 *     </tr>
 *     <tr>
 *         <td>Severe</td>
 *         <td>Error</td>
 *     </tr>
 * </table>
 *
 * @author Matt Bertolini
 * @see liquibase.logging.Logger
 */
public class Slf4jLogger extends AbstractLogger {

    private static final int TRACE_THRESHOLD = Level.FINEST.intValue();
    private static final int DEBUG_THRESHOLD = Level.FINE.intValue();
    private static final int INFO_THRESHOLD = Level.INFO.intValue();
    private static final int WARN_THRESHOLD = Level.WARNING.intValue();

    private final Logger logger;

    Slf4jLogger(Logger logger, LogMessageFilter filter) {
        super(filter);
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
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    /**
     * Logs a severe message. Calls SLF4J {@link Logger#error(String, Throwable)}.
     *
     * @param message The message to log
     * @param e The exception to log.
     */
    @Override
    public void severe(String message, Throwable e) {
        if (logger.isErrorEnabled()) {
            logger.error(message, e);
        }
    }

    /**
     * Logs a warning message. Calls SLF4J {@link Logger#warn(String)}
     *
     * @param message The message to log.
     */
    @Override
    public void warning(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    /**
     * Logs a warning message. Calls SLF4J {@link Logger#warn(String, Throwable)}.
     *
     * @param message The message to log.
     * @param e The exception to log.
     */
    @Override
    public void warning(String message, Throwable e) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, e);
        }
    }

    /**
     * Log an info message. Calls SLF4J {@link Logger#info(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    /**
     * Log an info message. Calls SLF4J {@link Logger#info(String, Throwable)}.
     *
     * @param message The message to log.
     * @param e The exception to log.
     */
    @Override
    public void info(String message, Throwable e) {
        if (logger.isInfoEnabled()) {
            logger.info(message, e);
        }
    }

    /**
     * Log a config message. Calls SLF4J {@link Logger#info(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void config(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    /**
     * Log a config message. Calls SLF4J {@link Logger#info(String, Throwable)}.
     *
     * @param message The message to log
     * @param e The exception to log
     */
    @Override
    public void config(String message, Throwable e) {
        if (logger.isInfoEnabled()) {
            logger.info(message, e);
        }
    }

    /**
     * Log a fine message. Calls SLF4J {@link Logger#debug(String)}.
     *
     * @param message The message to log.
     */
    @Override
    public void fine(String message) {
        if (logger.isDebugEnabled()) {
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
        if (logger.isDebugEnabled()) {
            logger.debug(message, e);
        }
    }
}
