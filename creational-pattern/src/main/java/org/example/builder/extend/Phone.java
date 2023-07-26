package org.example.builder.extend;

/**
 * @Title: Phone 手机
 * @Author Hannibal
 * @Package org.example.builder
 * @Date 26/07/2023 21:49
 * @Description: TODO 产品类
 */
public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String mainBoard;

    /**
     * 内部提供一个建造者
     */
    public final static class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainBoard;

        /**
         * 链式编程
         *
         * @param cpu
         * @return
         */
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder mainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }

    /**
     * 私有化构造方法
     */
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.mainBoard = builder.mainBoard;
        this.memory = builder.memory;
    }

}
