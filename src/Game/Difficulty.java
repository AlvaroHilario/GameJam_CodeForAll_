package Game;

/** This class is used to help to generate the right ammount of difficulty of the levels
 * The stats will be maxed to level 5
 * */
    public enum Difficulty{
        EASY(5, 12),
        MEDIUM(10,30),
        HARD(15,60);

        private int carSpeed;
        private int maxCars;

        Difficulty(int carSpeed, int maxCars){
            this.carSpeed = carSpeed;
            this.maxCars = maxCars;
        }

        public int getCarSpeed() {
            return carSpeed;
        }

        public int getMaxCars() {
            return maxCars;
        }
    }
