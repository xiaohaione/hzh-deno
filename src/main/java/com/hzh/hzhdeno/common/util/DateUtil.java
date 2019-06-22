package com.hzh.hzhdeno.common.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取或转换时间的工具类
 * <p>
 * 2011-11-1上午09:42:00
 */
@Slf4j
public class DateUtil {

    public final static String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
    public final static String HOUR_MINUTE_FORMAT = "HH:mm";
    public final static String SIMPLE_DAY_FORMAT = "yyyyMMdd";
    public final static String SIMPLE_DAYTIME_FORMAT = "yyyyMMddHHmmss";
    public final static String SIMPLE_WEEK_FORMAT = "EEEE";
    public final static String SIMPLE_CHINA_DATE = "yyyy年MM月dd日";

    public static int convertToInt(Long time) {
        String string = convertToString(new Date(time), SIMPLE_DAY_FORMAT);
        return Integer.parseInt(string);
    }

    public static String covertToChinaDate(Long time) {
        return convertToString(new Date(time), SIMPLE_CHINA_DATE);
    }

    /**
     * 获取SimpleDateFormat实例
     *
     * @param format
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 获取自定义格式的当前时间
     *
     * @param format
     * @return
     */
    public static String now(String format) {
        return convertToString(new Date(), format);
    }


    /**
     * 获取普通格式当前时间
     *
     * @return
     */
    public static String now() {
        return convertToString(new Date(), DEFAULT_TIME_FORMAT);
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return convertToString(new Date(), SIMPLE_DAY_FORMAT);
    }

    /**
     * 获取普通格式当前时间
     *
     * @return
     */
    public static String today() {
        return convertToString(new Date(), DEFAULT_DAY_FORMAT);
    }

    public static String yesterday() {
        return convertToString(getYesterdayTimestamp());
    }

    public static String tomorrow() {
        return convertToString(getTomorrowTimestamp());
    }

    /**
     * 将Date类型转换为自定义类型的String类型时间
     *
     * @param format
     * @param date
     * @return
     */
    public static String convertToString(Date date, String format) {
        return getSimpleDateFormat(format).format(date);
    }

    /**
     * 将Date类型转换为普通格式的String类型时间
     *
     * @param date
     * @return
     */
    public static String convertToString(Date date) {
        return convertToString(date, DEFAULT_TIME_FORMAT);
    }


    /**
     * 将指定格式的String类型时间转换为Date类型
     *
     * @param date
     * @param format
     * @return
     */
    public static Date convertToDate(String date, String format) {
        try {
            return getSimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            System.err.println("未能转换时间：" + date + "到格式：" + format + "\n" + e);
        }
        return null;
    }

    /**
     * 将普通格式的的String类型时间转换成Date类型
     *
     * @param date
     * @return
     */
    public static Date convertToDate(String date) {
        return convertToDate(date, DEFAULT_TIME_FORMAT);
    }

    /**
     * 将字符串类型的时间转换为Date类型
     *
     * @param date
     * @return
     */
    public static Date convertToDateFromLocaleUS(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            System.err.println("未能转换时间：" + date + "到格式：EEE MMM dd HH:mm:ss Z yyyy\n" + e);
        }
        return null;
    }

    /**
     * LocaleUS时间格式转化为自定义时间格式
     *
     * @param date
     * @return
     */
    public static String convertToString(String date) {
        return convertToString(convertToDateFromLocaleUS(date));
    }

    /**
     * 时间戳转化为Date类型的时间
     *
     * @param
     * @return
     */
    public static Date convertToDate(long timestamp) {
        if (String.valueOf(timestamp).length() == 10) {
            timestamp *= 1000;
        }
        return new Date(timestamp);
    }

    /**
     * 时间戳转化为String类型的时间
     *
     * @param timestamp
     * @return
     */
    public static String convertToString(long timestamp) {
        return convertToString(convertToDate(timestamp));
    }

    public static long convertToTimestamp(String date) {
        return convertToDate(date).getTime();
    }

    public static long convertToTimestamp(String date, String format) {
        return convertToDate(date, format).getTime();
    }

    /**
     * 判断当前时间是否在指定的时间范围内
     *
     * @auth 闫海鹏
     *
     * @param str
     *            数据库中取出来的时间
     * @return
     * @throws ParseException
     *
     */
	/*
	public static boolean checkTime(String str) {
		List<String> allowedSendTime = StringUtil.splitToList(str);

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);// 获得当前小时数
		int minutes = c.get(Calendar.MINUTE);// 获得当前分钟数
		c.clear();
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minutes);

		SimpleDateFormat sdf = getSimpleDateFormat("HH:mm");
		for (String sendTime : allowedSendTime) {
			try {
				Date d1 = sdf.parse(sendTime.split("-")[0]);
				Date d2 = sdf.parse(sendTime.split("-")[1]);
				if (d1.compareTo(c.getTime()) == -1 && d2.compareTo(c.getTime()) == 1)
					return true;
			} catch (ParseException e) {
				System.err.println("未能转换时间：" + sendTime + "到格式：HH:mm\n" + e);
			}
		}
		return false;
	}
	*/


    /**
     * 返回一个时间几小时后的时间
     *
     * @param date string格式的时间
     * @param hour 要增加的小时数
     * @return
     * @author 王勇
     */
    public static Calendar addHoursToDate(String date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertToDate(date));
        calendar.add(Calendar.HOUR, hour);
        return calendar;
    }

    /**
     * 比较指定的参数是否与现在相同
     *
     * @param pamram 年份、月份、日期、小时、分钟
     * @param date   需要比较的时间
     * @return
     * @auth 闫海鹏
     */
    public static boolean compareTime(int pamram, String date) {
        Calendar calendar = Calendar.getInstance();
        int nowTime = calendar.get(pamram);
        calendar.setTime(convertToDate(date, "yyyy-MM-dd"));
        return nowTime == calendar.get(pamram);
    }

    /**
     * 获取消息发送时间格式
     *
     * @param time
     * @return
     * @auth 闫海鹏
     */
    public static String getFormatTime(Date time) {
        if (time == null)
            return null;
        Calendar cNow = Calendar.getInstance();

        Calendar cCom = Calendar.getInstance();
        cCom.setTime(time);
        long timeDiff = cNow.getTimeInMillis() - cCom.getTimeInMillis();
        long dateDiff = cNow.get(Calendar.DATE) - cCom.get(Calendar.DATE);

        if (cNow.get(Calendar.YEAR) != cCom.get(Calendar.YEAR))
            return convertToString(time, "yyyy年MM月dd日 HH:mm");
        if (timeDiff < 1000 * 60)
            return "刚刚";
        else if (timeDiff < 1000 * 60 * 60)
            return timeDiff / 1000 / 60 + "分钟前";
        else if (timeDiff < 1000 * 60 * 60 * 24 && dateDiff == 0)
            return "今天 " + convertToString(time, "HH:mm");
        else if (timeDiff < 1000 * 60 * 60 * 24 * 2 && dateDiff == 1)
            return "昨天 " + convertToString(time, "HH:mm");
        else if (timeDiff < 1000 * 60 * 60 * 24 * 2 && dateDiff == 2)
            return "前天 " + convertToString(time, "HH:mm");
        else if (cNow.get(Calendar.MONTH) == cCom.get(Calendar.MONTH))
            return cNow.get(Calendar.DAY_OF_MONTH) - cCom.get(Calendar.DAY_OF_MONTH) + "天前" + convertToString(time, "HH:mm");
        else
            return convertToString(time, "MM月dd日 HH:mm");
    }

    public static String getFormatTime(String time) {
        return getFormatTime(convertToDate(time));
    }

    /**
     * 当天的00:00:00.000时刻的时间戳
     *
     * @return
     * @author 郑德湖
     * @date Oct 28, 2011 5:09:59 PM
     */
    public static long getTodayTimestamp() {
        return convertToTimestamp(today(), DEFAULT_DAY_FORMAT);
    }

    public static long getYesterdayTimestamp() {
        return convertToTimestamp(today(), DEFAULT_DAY_FORMAT) - 86400000;
    }

    public static long getTomorrowTimestamp() {
        return convertToTimestamp(today(), DEFAULT_DAY_FORMAT) + 86400000;
    }

    /**
     * 将时间戳转换为如下格式：yyMMddHHmmss 例如：20180626000000；
     *
     * @param time
     * @return
     */
    public static String convertToDayTime(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.SIMPLE_DAYTIME_FORMAT);
        return sdf.format(time);
    }

    /**
     * 转换时间格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param time 长度为14
     * @return
     */
    public static String toString(String time) {
        if (time.length() != 14) {
            return null;
        }
        StringBuffer sb = new StringBuffer(time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12));
        return sb.toString();
    }

    /**
     * 功能描述: 返回昨日日期，int yyyyMMdd
     *
     * @auther: huangsenming
     * @date: 2018/7/9 20:00
     */
    public static int getIntYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        return Integer.parseInt(getSimpleDateFormat("yyyyMMdd").format(time));
    }

    /**
     * 功能描述: 获取前一天的日期 传入格式yyyy-MM-dd，返回格式为yyyyMMdd int
     *
     * @auther: huangsenming
     * @date: 2018/7/9 17:46
     */
    public static int getDateBeforeOneDay() {
//		Calendar c = Calendar.getInstance();
//		Date dateBefore=null;
//		try {
//			dateBefore = getSimpleDateFormat("yyyy-MM-dd").parse(date);
//		} catch (ParseException e) {
//			System.err.println("传入日期格式有误，格式为yy-MM-dd");
//		}
//		c.setTime(dateBefore);
//		int day=c.get(Calendar.DATE);
//		c.set(Calendar.DATE,day-1);
//		return Integer.parseInt(getSimpleDateFormat("yyyyMMdd").format(c.getTime()));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        Date time = cal.getTime();
        return Integer.parseInt(getSimpleDateFormat("yyyyMMdd").format(time));
    }

    private final String NOWDAY = "yyyyMMdd";
    private final String NOWHOUR = "HH";

    /**
     * @param date
     * @return 获取3个月前的时间戳，用于导出
     */
    public static Long getBeforeThreeMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -3);
        return c.getTimeInMillis();
    }

    /**
     * @param date
     * @return 获取3个月前的日期, 时间格式为yyyyMMdd
     */
    public static int getBefore3MonDate(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -3);
        return Integer.parseInt(getSimpleDateFormat("yyyyMMdd").format(c.getTime()));
    }

//    /**
//     * 功能描述: 获取某月的开始日期和结束日期 dateStr yyyyMMdd
//     *
//     * @auther: huangsenming
//     * @date: 2018/7/16 14:48
//     */
//    public static DateVO getMonthDays(int dateStr, int amount) {
//        DateVO date = new DateVO();
//        SimpleDateFormat dateFormat = getSimpleDateFormat("yyyyMMdd");
//        Calendar calendar = Calendar.getInstance();
//        try {
//            calendar.setTime(dateFormat.parse(dateStr + ""));
//
//            calendar.add(Calendar.MONTH, amount);
//            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//            date.setStartCdate(Integer.parseInt(dateFormat.format(calendar.getTime())));
//            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            date.setEndCdate(Integer.parseInt(dateFormat.format(calendar.getTime())));
//        } catch (Exception e) {
//            System.err.println("未能转换时间：" + date + "到格式：EEE MMM dd HH:mm:ss Z yyyy\n" + e);
//        }
//        return date;
//    }

    /**
     * 功能描述: 获取前几天的时间戳
     *
     * @auther: huangsenming
     * @date: 2018/7/19 9:21
     */
    public static Long getLongDay(int day) {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTimeInMillis();
    }

    /**
     * 功能描述: 获取当天日期 yyyymmdd
     *
     * @auther: huangsenming
     * @date: 2018/8/8 19:51
     */
    public static int getTodayDate() {
        return Integer.parseInt(getSimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    /**
     * 功能描述: 获取当前小时 HH
     *
     * @auther: huangsenming
     * @date: 2018/8/18 9:54
     */
    public static int getCurrentHour() {
        return Integer.parseInt(getSimpleDateFormat("HH").format(new Date()));
    }

    /**
     * 功能描述: 获取当前星期 int
     *
     * @auther: huangsenming
     * @date: 2018/8/20 13:48
     */
    public static int getCurrentWeek() {
        String currentWeekStr = getCurrentWeekStr();
        switch (currentWeekStr) {
            case "星期一":
                return 1;
            case "星期二":
                return 2;
            case "星期三":
                return 3;
            case "星期四":
                return 4;
            case "星期五":
                return 5;
            case "星期六":
                return 6;
            case "星期日":
                return 7;
            default:
                return 0;
        }
    }

    /**
     * 功能描述: 获取当前星期 String
     *
     * @auther: huangsenming
     * @date: 2018/8/20 13:48
     */
    public static String getCurrentWeekStr() {
        return getSimpleDateFormat(SIMPLE_WEEK_FORMAT).format(new Date());
    }

    /**
     * 功能描述: 获取 日期的周数 1-7 分别表示周一到周日
     *
     * @auther: huangsenming
     * @date: 2018/10/13 11:22
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        } else {
            calendar.setTime(new Date());
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 功能描述: 获取日期之间的所有日期
     *
     * @auther: huangsenming
     * @date: 2018/10/17 16:27
     */
    public static List<Integer> getCdateBetween(int startCdate, int endCdate) {
        List<Integer> dates = new ArrayList<>();
        try {
            Date d1 = new SimpleDateFormat("yyyyMMdd").parse(startCdate + "");//定义起始日期
            Date d2 = new SimpleDateFormat("yyyyMMdd").parse(endCdate + "");//定义结束日期
            Calendar dd = Calendar.getInstance();//定义日期实例
            dd.setTime(d1);//设置日期起始时间
            while (dd.getTimeInMillis() <= d2.getTime()) {//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String str = sdf.format(dd.getTime());
                dates.add(Integer.parseInt(str));
                dd.add(Calendar.DAY_OF_MONTH, 1);//进行当前日期月份加1
            }
        } catch (Exception e) {
            log.error("获取日期异常", e);
            dates.add(startCdate);
            dates.add(endCdate);
        }
        return dates;
    }

    /**
     * 功能描述: 获取一个日期的开始时间戳
     *
     * @auther: huangsenming
     * @date: 2018/10/18 15:50
     */
    public static long getStartTimeStamp(int cdate) {
        try {
            Date d1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(cdate + " 00:00:00");//定义起始日期
            return d1.getTime();
        } catch (Exception e) {
            log.error("日期解析异常");
            return cdate;
        }
    }

    /**
     * 功能描述: 获取一个日期的结束时间戳
     *
     * @auther: huangsenming
     * @date: 2018/10/18 15:50
     */
    public static long getEndTimeStamp(int cdate) {
        try {
            Date d1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(cdate + " 23:59:59");//定义起始日期
            return d1.getTime() + 999;
        } catch (Exception e) {
            log.error("日期解析异常");
            return cdate;
        }
    }

    /**
     * @return 获取前一天开始的时间戳
     */
    public static long getYesterdayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -1); // 明天的就是1，昨天是负1
        return calendar.getTimeInMillis();
    }

    /**
     * 功能描述: 获取两个日期的间隔天数
     *
     * @auther: huangsenming
     * @date: 2018/12/10 16:16
     */
    public static int getIntervalDay(int cdate1, int cdate2) {
        Date date1;
        Date date2;
        try {
            SimpleDateFormat dateFormat = getSimpleDateFormat(SIMPLE_DAY_FORMAT);
            date1 = dateFormat.parse(cdate1 + "");
            date2 = dateFormat.parse(cdate2 + "");
        } catch (Exception e) {
            log.error("解析日期异常[cdate1：{}，cdate2{}]", cdate1, cdate2, e);
            return 0;
        }
        return (int) (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
    }

//    /**
//     * 功能描述: 获取月份之间的月份
//     * 格式为 yyyyMM
//     *
//     * @auther: huangsenming
//     * @date: 2019/3/6 17:34
//     */
//    public static List<YearMonthBO> getYearMonth(int startParam, int endParam) {
//        List<YearMonthBO> list = new ArrayList<>();
//        YearMonthBO yearMonthBO = null;
//        try {
//            int startYear = startParam / 100;
//            int endYear = endParam / 100;
//
//            int startMonth = startParam % 100;
//            int endMonth = endParam % 100;
//            for (int i = startYear; i <= endYear; i++) {
//                for (; startMonth <= endMonth || i < endYear; startMonth++) {
//                    yearMonthBO = new YearMonthBO();
//                    yearMonthBO.setYear(i);
//                    yearMonthBO.setMonth(startMonth);
//                    list.add(yearMonthBO);
//                    if (startMonth == 12) {
//                        startMonth = 1;
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.info("日期解析错误", e);
//        }
//        return list;
//    }
}
