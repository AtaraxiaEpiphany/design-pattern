package org.example.strategy;

import org.example.strategy.impl.StrategyOne;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.strategy
 * @Date 02/08/2023 22:08
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    void testThreadPool() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4,
                8,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5),
                new CustomRejectExecutionHandler()
        );
    }

    @Test
    public void test() {
        Strategy strategy = new StrategyOne();
        Context context = new Context(strategy);
        context.saleShow();
    }
}

/**
 * Concrete Strategy.
 */
class CustomRejectExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Arrays.sort(null, (o1, o2) -> 0);
        throw new RuntimeException("r => " + r);
    }
}