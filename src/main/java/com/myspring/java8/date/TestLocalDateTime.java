package com.myspring.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

    //1.LocalDate LocalTime LocalDateTime
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
    }

    //
    public static void test8() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Ulyanovsk"));
        System.out.println(ldt);

        //带时区的时间日期格式
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Ulyanovsk"));
        ZonedDateTime zonedDateTime = ldt2.atZone(ZoneId.of("Europe/Ulyanovsk"));
        System.out.println(zonedDateTime);


    }

    //ZonedDate,ZoneTime,ZonedDateTime
    public static void test7() {
        //获取所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }


    // DateTimeFormatter:格式化时间/日期
    public static void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("--------------------- 自定义格式 --------------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        //将字符串转换成LocalDateTime
        LocalDateTime newDate = ldt.parse(strDate2,dtf2);
        System.out.println(newDate);


    }

    //5.
    public static void test5() {
        LocalDateTime ldt = LocalDateTime.now(); //获取当前系统时间
        System.out.println(ldt);

        //指定月中的天
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        //下一个周日是什么时候
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日是什么时候
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek(); //获取当前时间是周几
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });

        System.out.println(ldt5);
    }

    //4.
    //获取两个日期之间的间隔
    public static void test4() {
        LocalDate ld1 = LocalDate.of(2015,1,1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }


    //3.
    //Duration:计算两个“时间”之间的间隔
    //Period:计算两个“日期”之间的间隔
    public static void test3() {
        Instant ins1 = Instant.now();
        Instant ins2 = Instant.now();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {

        }

        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis()); //相差毫秒数，获取秒用getSecond，这里有toXxx

        System.out.println("------------------------------");

        LocalTime lt1 = LocalTime.now();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {

        }
        LocalTime lt2 = LocalTime.now();

        System.out.println(Duration.between(lt1,lt2).toMillis());

    }

    //Instant : 时间戳（以Unix元年：1970年00:00:00 到某个时间的毫秒值）
    public static void test2() {
        Instant ins1 = Instant.now(); //默认获取UTC时区
        System.out.println(ins1);

        //UTC时区时间跟我们相差8个小时
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        //将ins1转成毫秒
        System.out.println(ins1.toEpochMilli());

        //从1970年00:00:00加60秒
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    public static void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 22, 33);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
        System.out.println(ldt.getDayOfWeek());
    }

}
