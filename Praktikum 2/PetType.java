public class PetType {
    public enum Type {
        DOG(new double[] {2, 2, 2}),
        CAT(new double[] {1, 3, 2}),
        BIRD(new double[] {0.75, 1, 0.75}),
        RABBIT(new double[] {0.5, 0.5, 1});

        private final double[] values;

        Type(double[] values) {
            this.values = values;
        }

        public double getHappinessMultiplier() {
            return values[0];
        }

        public double getHungrinessMultiplier() {
            return values[1];
        }

        public double getSleepinessMultiplier() {
            return values[2];
        }
    }
}
