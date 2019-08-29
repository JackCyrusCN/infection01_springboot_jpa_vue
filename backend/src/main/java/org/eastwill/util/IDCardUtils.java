package org.eastwill.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCardUtils {

	/**
     * 方法描述： 根据身份证获取年龄，性别
     * 2表示女
     * 1表示男
     */
    public static String[] getAgeAndSexById(String idNum) {
        String age = "";
        String sex = "";
        String tbirth = "";
        String tbirth_y = "";
        String tbirth_m = "";
        String tbirth_d = "";
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getDefault());//获取系统当前时间
        int currentYear = calendar.get(Calendar.YEAR);
        if (idNum.matches("^\\d{15}$|^\\d{17}[\\dxX]$")) {
            if (idNum.length() == 18) {
                Pattern pattern = Pattern.compile("\\d{6}(\\d{4})\\d{6}(\\d{1})[\\dxX]{1}");
                Matcher matcher = pattern.matcher(idNum);
                if (matcher.matches()) {
                	tbirth_y = idNum.substring(6, 10); //beginIndex -- 起始索引（包括） endIndex -- 结束索引（不包括）
                	tbirth_m = idNum.substring(10, 12);
                	tbirth_d = idNum.substring(12, 14);
                    age = String.valueOf(currentYear - Integer.parseInt(matcher.group(1)));
                    sex = "" + Integer.parseInt(matcher.group(2))%2;
                }
            } else if (idNum.length() == 15) {
                Pattern p = Pattern.compile("\\d{6}(\\d{2})\\d{5}(\\d{1})\\d{1}");
                Matcher m = p.matcher(idNum);
                if (m.matches()) {
                	tbirth_y = "19"+idNum.substring(6, 7);
                	tbirth_m = idNum.substring(8, 9);
                	tbirth_d = idNum.substring(10, 11);
                    int year = Integer.parseInt(m.group(1));
                    year = 2000 + year;
                    if (year > 2020) {
                        year = year - 100;
                    }
                    age = String.valueOf(currentYear - year);
                    sex = "" + Integer.parseInt(m.group(2))%2;
                }
            }
        }
        if ("0".equals(sex)) {
            sex = "2";
        }
        tbirth = tbirth_y+"-"+tbirth_m+"-"+tbirth_d;
        return new String[]{age, sex, tbirth};
    }
}
