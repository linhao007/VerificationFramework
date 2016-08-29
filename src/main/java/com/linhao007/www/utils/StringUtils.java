package com.linhao007.www.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by www.linhao007.com on 8/3/16.
 */
public class StringUtils {
    
    public static boolean areNotEmpty(String... values) {

        boolean result = true;
        if (values != null && values.length != 0) {
            String[] arr$ = values;
            int len$ = values.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                String value = arr$[i$];
                result &= !isEmpty(value);
            }
        } else {
            result = false;
        }

        return result;

    }

    public static boolean isEmpty(String value) {
        int strLen;

        if (value == null || (strLen = value.length()) == 0)
            return true;

        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }



    public static boolean isNumeric(Object obj) {
        if(obj == null) {
            return false;
        } else {
            char[] chars = obj.toString().toCharArray();
            int length = chars.length;
            if(length < 1) {
                return false;
            } else {
                int i = 0;
                if(length > 1 && chars[0] == 45) {
                    i = 1;
                }

                while(i < length) {
                    if(!Character.isDigit(chars[i])) {
                        return false;
                    }

                    ++i;
                }

                return true;
            }
        }
    }


    public static String unicodeToChinese(String unicode) {
        StringBuilder out = new StringBuilder();
        if(!isEmpty(unicode)) {
            for(int i = 0; i < unicode.length(); ++i) {
                out.append(unicode.charAt(i));
            }
        }

        return out.toString();
    }

    public static String toUnderlineStyle(String name) {
        StringBuilder newName = new StringBuilder();

        for(int i = 0; i < name.length(); ++i) {
            char c = name.charAt(i);
            if(Character.isUpperCase(c)) {
                if(i > 0) {
                    newName.append("_");
                }

                newName.append(Character.toLowerCase(c));
            } else {
                newName.append(c);
            }
        }

        return newName.toString();
    }

    public static String convertString(byte[] data, int offset, int length) {
        if(data == null) {
            return null;
        } else {
            try {
                return new String(data, offset, length, "UTF-8");
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static byte[] convertBytes(String data) {
        if(data == null) {
            return null;
        } else {
            try {
                return data.getBytes("UTF-8");
            } catch (Exception var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static Date parseDateTime(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        try {
            return format.parse(str);
        } catch (ParseException var3) {
            throw new RuntimeException(var3);
        }
    }
}

