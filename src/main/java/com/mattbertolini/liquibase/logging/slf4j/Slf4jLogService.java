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

import liquibase.logging.Logger;
import liquibase.logging.core.AbstractLogService;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Liquibase {@link liquibase.logging.LogService} that creates an SLF4J-backed logger.
 */
public class Slf4jLogService extends AbstractLogService {

    private static final int DEFAULT_PRIORITY = 5;
    private static final String PRIORITY_PROPERTY_NAME = Slf4jLogService.class.getName() + ".priority";

    private int priority;

    /**
     * Default constructor is needed for ServiceLoader to work.
     *
     * @see liquibase.servicelocator.StandardServiceLocator
     */
    public Slf4jLogService() {
        this(System.getProperties());
    }

    /**
     * Constructor visible for testing.
     */
    Slf4jLogService(final Properties systemProps) {
        priority = DEFAULT_PRIORITY;
        String priorityPropertyValue = systemProps.getProperty(PRIORITY_PROPERTY_NAME);
        if (priorityPropertyValue != null && !priorityPropertyValue.isEmpty()) {
            try {
                priority = Integer.parseInt(priorityPropertyValue);
            } catch (NumberFormatException e) {
                // Do nothing
            }
        }
    }

    /**
     * Gets the logger priority for this logger. The priority is used by Liquibase to determine which LogService to use.
     * The LogService with the highest priority will be selected. This implementation's priority is set to 5. Remove loggers
     * with higher priority numbers if needed.
     *
     * @return The priority integer. Defaults to 5 if no override is given.
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Takes the given class argument and associates it with a SLF4J logger.
     *
     * @param clazz The class to create an SLF4J logger for
     */
    @Override
    public Logger getLog(Class clazz) {
        return new Slf4jLogger(LoggerFactory.getLogger(clazz), getFilter());
    }
}
