/*
 * Mohist - MohistMC
 * Copyright (C) 2018-2023.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package com.mohistmc.i18n;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class i18n {
    private static final List<String> a = Arrays.asList("en_us", "es_es", "fr_fr", "ru_ru", "zh_cn", "zh_tw");
    public static List<String> b = Arrays.asList("fr_FR", "ru_RU", "zh_CN", "zh_TW");
    public static Map<String, String> CACHE = new ConcurrentHashMap<>();
    private static ResourceBundle rb;

    public static String get(String key) {
        rb = ResourceBundle.getBundle("lang.message", new UTF8Control());
        String string = rb.getString(key);
        if (!CACHE.containsKey(key)) {
            CACHE.put(key, string);
        } else {
            return CACHE.get(key);
        }
        return string;
    }

    public static String get(String key, Object... f) {
        return new MessageFormat(get(key)).format(f);
    }
}
