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

import java.util.List;

/**
 * The loader for multiple-service mode.
 * multiple-service mode is used to load multiple services (has name and ordered).
 *
 * @param <T> Interface of service
 * @author S.Violet
 */
public class MultipleServiceLoader<T> {

    MultipleServiceLoader() {
    }

    /**
     * Get the service with the specified name.
     * If there are two services with the same name, an exception will be thrown.
     * @param name The name of service implementation (Specified by annotation 'ImplementationName')
     * @return Service instance (cached)
     */
    public T getService(String name) {
        return null;
    }

    /**
     * Get all services, sorted by priority (Specified by annotation 'ImplementationPriority')
     * @return Service instances (cached)
     */
    public List<T> getServices(){
        return null;
    }

}
