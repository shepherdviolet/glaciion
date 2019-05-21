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

import com.github.shepherdviolet.glaciion.Glaciion;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

class CommonUtils {

    private static final AtomicInteger LOADER_ID = new AtomicInteger(0);

    /**
     * loaderId of service loader
     */
    static String generateLoaderId(){
        return String.valueOf(LOADER_ID.getAndIncrement());
    }

    /**
     * Close closeable quietly
     */
    static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception ignore) {
        }
    }

    /**
     * Check if string is empty or null
     */
    static boolean isEmpty(String input){
        return input == null || input.length() <= 0;
    }

    /**
     * Check if string is blank, empty or null
     */
    static boolean isEmptyOrBlank(String input){
        return isEmpty(input) || input.trim().length() <= 0;
    }

    /**
     * Digest file, get hash
     */
    static String digest(InputStream inputStream, String type) throws IOException {
        if (inputStream == null){
            throw new NullPointerException("inputStream is null");
        }
        try {
            MessageDigest cipher = MessageDigest.getInstance(type);
            byte[] buff = new byte[1024];
            int size;
            while((size = inputStream.read(buff)) != -1){
                cipher.update(buff, 0, size);
            }
            return bytesToHex(cipher.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No Such Algorithm:" + type, e);
        } finally {
            closeQuietly(inputStream);
        }
    }

    /**
     * bytes to hex
     */
    static String bytesToHex(byte[] bytes){
        if (bytes == null) {
            return null;
        }
        if (bytes.length <= 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte unit : bytes) {
            int unitInt = unit & 0xFF;
            String unitHex = Integer.toHexString(unitInt);
            if (unitHex.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(unitHex);
        }
        return stringBuilder.toString();
    }

    /**
     * get method caller info
     */
    static String getCaller(Class<?> currentClass) {
        String current = currentClass.getName();
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        boolean flag = false;
        for (StackTraceElement element : elements) {
            if (current.equals(element.getClassName())) {
                flag = true;
            } else if (flag &&
                    !Glaciion.CLASS_NAME.equals(element.getClassName()) &&
                    !PreLoader.CLASS_NAME.equals(element.getClassName()) &&
                    !SingleServiceLoader.CLASS_NAME.equals(element.getClassName()) &&
                    !MultipleServiceLoader.CLASS_NAME.equals(element.getClassName())) {
                return element.getClassName() + "#" + element.getMethodName();
            }
        }
        return "unknown#unknown";
    }

}
