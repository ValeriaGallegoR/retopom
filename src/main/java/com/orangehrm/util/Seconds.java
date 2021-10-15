package com.orangehrm.util;

public enum Seconds {
        ZERO_SECONDS(0),
        ONE_SECONDS(1),
        TWO_SECONDS(2),
        THREE_SECONDS(3),
        FOUR_SECONDS(4),
        FIVE_SECONDS(5),
        SIX_SECONDS(6),
        SEVEN_SECONDS(7),
        EIGHT_SECONDS(8);

        private final int value;

        Seconds(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
}
