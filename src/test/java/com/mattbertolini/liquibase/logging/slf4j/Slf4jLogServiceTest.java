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
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class Slf4jLogServiceTest {
    @Test
    void usesDefaultPriority() {
        Slf4jLogService logService = new Slf4jLogService(new Properties());
        assertEquals(5, logService.getPriority());
    }

    @Test
    void usesPriorityFromSystemProperties() {
        Properties systemProps = new Properties();
        systemProps.setProperty(Slf4jLogService.class.getName() + ".priority", "99");
        Slf4jLogService logService = new Slf4jLogService(systemProps);
        assertEquals(99, logService.getPriority());
    }

    @Test
    void usesDefaultPriorityOnPropertyParseError() {
        Properties systemProps = new Properties();
        systemProps.setProperty(Slf4jLogService.class.getName() + ".priority", "not_a_number");
        Slf4jLogService logService = new Slf4jLogService(systemProps);
        assertEquals(5, logService.getPriority());
    }

    @Test
    void usesDefaultPriorityOnEmptyProperty() {
        Properties systemProps = new Properties();
        systemProps.setProperty(Slf4jLogService.class.getName() + ".priority", "");
        Slf4jLogService logService = new Slf4jLogService(systemProps);
        assertEquals(5, logService.getPriority());
    }

    @Test
    void returnsSlf4jLogger() {
        Slf4jLogService logService = new Slf4jLogService();
        Logger logger = logService.getLog(Slf4jLogServiceTest.class);
        assertAll(() -> {
            assertNotNull(logger);
            assertEquals(Slf4jLogger.class, logger.getClass());
        });
    }
}
