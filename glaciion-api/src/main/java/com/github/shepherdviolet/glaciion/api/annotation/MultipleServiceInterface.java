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

package com.github.shepherdviolet.glaciion.api.annotation;

import java.lang.annotation.*;

/**
 * Marked on the service interface class. Indicates that this service is multiple-service mode.
 *
 * @author S.Violet
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MultipleServiceInterface {

}
