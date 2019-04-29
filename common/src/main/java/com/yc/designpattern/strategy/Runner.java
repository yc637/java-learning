package com.yc.designpattern.strategy;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年08月09日 18:18:13
 */
public class Runner {

    public static void main(String[] args) {

        // 为了实现某功能，可以选择不同的算法
        Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();
        doSomething(strategyA);
        doSomething(strategyB);

    }

    public static void doSomething(Strategy strategy){
        strategy.method();
    }
}
