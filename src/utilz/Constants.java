package utilz;

public class Constants {

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;

    }

    public static class MainShipConstants {
        /*
        public static final int IDLE = 0;
        public static final int POWER_UP = 1;
        public static final int SHOOT = 2;
         */

    }

    public static class EngineConstants {
        public static final int BASIC_IDLE = 0;
        public static final int BASIC_POWER_UP = 1;
        public static final int BIG_PULSE_IDLE = 2;
        public static final int BIG_PULSE_POWER_UP = 3;
        public static final int BURST_IDLE = 4;
        public static final int BURST_POWER_UP = 5;
        public static final int SUPERCHARGED_IDLE = 6;
        public static final int SUPERCHARGED_POWER_UP = 7;

        public static int getSpriteAmount(int engine_effects) {

            switch (engine_effects) {
                case BASIC_IDLE:
                    return 3;
                case BASIC_POWER_UP:
                case BIG_PULSE_IDLE:
                case BIG_PULSE_POWER_UP:
                case SUPERCHARGED_IDLE:
                case SUPERCHARGED_POWER_UP:
                    return 4;
                case BURST_IDLE:
                    return 7;
                case BURST_POWER_UP:
                    return 6;
                default:
                    //in case of wrong input, run default one
                    return 1;
            }

        }

    }


}
