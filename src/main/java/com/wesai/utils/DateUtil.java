package com.wesai.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
            "yyyy-MM-dd");
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
            "yyyyMMdd");
    private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    /**
     * 获取YYYY格式
     * @author liuyj
     * @return
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-M格式(1位数字表示的月份)
     * @author liuyj
     * @return
     */
    public static String getMonth_S(String datetime) {
        String year = datetime.split("-")[0] + "-";
        String month = datetime.split("-")[1];
        if (Integer.parseInt(month) < 10) {
            String numMonth = String.valueOf(Integer.parseInt(month));
            return year + numMonth;
        }
        return year+ month;
    }

    /**
     * 获取YYYY-MM格式(2位数字表示的月份)
     * @author liuyj
     * @param datetime
     * @return
     */
    public static String getMonth_C(String datetime) {
        String year = datetime.split("-")[0] + "-";
        String month = datetime.split("-")[1];
        if (Integer.parseInt(month) < 10) {
            String numMonth = "0"+month;
            return year + numMonth;
        }
        return year+ month;
    }

    /**
     * 获取YYYY-MM-DD格式
     * @author liuyj
     * @return
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     * @author liuyj
     * @return
     */
    public static String getDays(){
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     * @author liuyj
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * @Title: compareDate
     * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
     * @param s
     * @param e
     * @return boolean
     * @throws
     * @author liuyj
     */
    public static boolean compareDate(Date s, Date e) {
        if(fomatDate(s)==0||fomatDate(e)==0){
            return false;
        }
        return true;
    }

    /**
     * 格式化日期
     * @author liuyj
     * @return
     */
    public static long fomatDate(Date date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //按以上格式 将当前时间转换成字符串
        String curTime;
        try {
            curTime = fmt.format(date);
            return fmt.parse(curTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 格式化日期 (重载+1)
     */
    public static String fomatDate(long date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fmt.format(date);
    }

    /**
     * 校验日期是否合法
     * @author liuyj
     * @return
     */
    public static boolean isValidDate(String s) {
        boolean convertSuccess=true;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            fmt.setLenient(false);
            fmt.parse(s);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return convertSuccess=false;
        }
        return convertSuccess;
    }

    public static int getDiffYear(String startTime,String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long
     * @author liuyj
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;
        try {
            beginDate = format.parse(beginDateStr);
            endDate= format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        //System.out.println("相隔的天数="+day);
        return day;
    }

    /**
     * 得到n天之后的日期
     * @author liuyj
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        return dateStr;
    }

    /**
     * 得到n天之后的日期
     * @author liuyj
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 获取时间戳函数(10位)
     * @return
     */
    public static String getTimeStamp() {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String time = getTime();
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Long.toString(date.getTime()/1000-8);
    }

    /**
     * 根据给定的日期获取其年和月
     * @param datetime 给定的日期格式(yyyy-mm-dd)
     * @return 年和月的格式(yyyy-mm)
     * @author liuyj
     */
    public static String getYearAndMonth(String datetime){
        return datetime.split("-")[0] + "-" + datetime.split("-")[1];
    }

    /**
     * 根据两个日期计算每月的天数,并且除去周六日
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 除去周六日的天数
     * @author liuyj
     */
    @SuppressWarnings("deprecation")
    public static int getDiffDays(String startDate, String endDate) {
        Date startTime, endTime;
        int result = 0;
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            while (startTime.compareTo(endTime) <= 0) { //比较开始日期小于等于结束日期
                if (startTime.getDay() != 6 && startTime.getDay() != 0) {
                    result++;
                }
                startTime.setDate(startTime.getDate() + 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据两个日期计算间隔工作小时,并且除去周六日
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 除去周六日的间隔小时
     * @author liuyj
     */
    @SuppressWarnings("deprecation")
    public static long getDiffHours(String startDate, String endDate){
        Date startTime, endTime, initTime;
        long day = 0,hour = 0, result = 0;
        long nd = 1000*24*60*60;//一天的毫秒数
        long nh = 1000*60*60;//一小时的毫秒数
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd HH").parse(startDate);
            initTime = new SimpleDateFormat("yyyy-MM-dd HH").parse(startDate);
            endTime = new SimpleDateFormat("yyyy-MM-dd HH").parse(endDate);
            while (startTime.compareTo(endTime) <= 0) {
                if (startTime.getDay() == 6 || startTime.getDay() == 0) {
                    result++;
                }
                startTime.setDate(startTime.getDate() + 1);
            }
            long diff = endTime.getTime()-initTime.getTime();
            day = diff/nd-result;//计算差多少天
            hour = diff%nd/nh;//计算差多少小时
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day*8 + hour;
    }

    /**
     * 获取当前的年月
     * @return
     */
    public static String getCurYearMonth(String ym){
        Calendar cal = Calendar.getInstance();
        if (ym.equals("") || ym==null) {
            String currentYear = String.valueOf(cal.get(Calendar.YEAR));
            String currentMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
            ym = currentYear+"-"+currentMonth;
        }
        return getMonth_C(ym);
    }

    /**
     * 判断时间是否在时间段内
     * @param date 当前时间  yyyy-MM-dd HH:mm:ss
     * @param strDateBegin 开始时间
     * @param strDateEnd 结束时间
     * @return 如果在指定的时间段内返回true，否则返回false.
     */
    public static boolean isInDate(String strDate, String strDateBegin,
                                   String strDateEnd) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date selDate = fmt.parse(strDate);
            Date dateBeigDate = fmt.parse(strDateBegin);
            Date dateEndDate = fmt.parse(strDateEnd);
            if (selDate.after(dateBeigDate) && selDate.before(dateEndDate)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取当前日期是星期几
     * @param dt
     * @return 返回整数，如星期一：1，星期二：2...
     */
    public static int getWeekOfDate(Date dt) {
        Integer[] weekDays = {0, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void main(String[] args) {
        DateUtil.getWeekOfDate(new Date());
        DateUtil.isInDate("2016-04-15 15:40:09", "2016-04-14 15:30:00", "2016-04-14 17:30:00");
    }
}
