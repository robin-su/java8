package com.myspring.java8.parallelStream;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForJoin {

    /**
     * ForkJoin 框架
     *
     */
    public static void main(String[] args) {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,1000000000);
        long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());

        Instant start2 = Instant.now();
        long num2 = 0L;
        for(int i=0;i<=1000000000L;i++) {
            num2 += i;
        }

        System.out.println(num2);
        Instant end2 = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start2,end2).toMillis());

        new TestForJoin().test();
    }

    /**
     * java 8并行流
     * parallel 的底层是fork join框架
     */
    public void test() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0,1000000000L)
                  .parallel()
                  .reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start,end).toMillis());
    }

}
