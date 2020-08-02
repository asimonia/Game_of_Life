package life;

public enum Symbol {
    ALIVE {
        @Override
        public String toString() {
            return "O";
        }
    },
    DEAD {
        @Override
        public String toString() {
            return " ";
        }
    }

}
