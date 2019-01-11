/*
 * Copyright (C) 2019-2019 S.Violet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project GitHub: https://github.com/shepherdviolet/glaciion
 * Email: shepherdviolet@163.com
 */

package com.github.shepherdviolet.glaciion.core;

/**
 * <p>Glaciion: An implementation of Java Service Provider Interface</p>
 *
 * @author S.Violet
 */
public class Glaciion {

    private Glaciion() {
    }

    /**
     * Get the loader for single-service mode.
     * single-service mode is used when only one service implementation is required.
     * @param type Interface type to load
     * @return SingleServiceLoader (Cached)
     */
    public static SingleServiceLoader getSingleServiceLoader(Class<?> type){
        return null;
    }

    /**
     * Create a loader for single-service mode (New instance always).
     * single-service mode is used when only one service implementation is required.
     * @param type Interface type to load
     * @param classLoader Custom classloader
     * @return SingleServiceLoader (New)
     */
    public static SingleServiceLoader newSingleServiceLoader(Class<?> type, ClassLoader classLoader){
        return null;
    }

    /**
     * Get the loader for multiple-service mode.
     * multiple-service mode is used to load multiple services (has name and ordered).
     * @param type Interface type to load
     * @return MultipleServiceLoader (Cached)
     */
    public static MultipleServiceLoader getMultipleServiceLoader(Class<?> type){
        return null;
    }

    /**
     * Create a loader for multiple-service mode (New instance always).
     * multiple-service mode is used to load multiple services (has name and ordered).
     * @param type Interface type to load
     * @param classLoader Custom classloader
     * @return MultipleServiceLoader (New)
     */
    public static MultipleServiceLoader newMultipleServiceLoader(Class<?> type, ClassLoader classLoader){
        return null;
    }

}
