package common.exceptions;

public class MyExceptions {
    public static class InvalidNameException extends RuntimeException {
        public InvalidNameException() {
            super("Name length should be more than 2 letters!");
        }
    }

    public static class InvalidAgeException extends RuntimeException {
        public InvalidAgeException() {
            super("Age must be more than 14!");
        }
    }

    public static class InvalidHealthException extends RuntimeException {
        public InvalidHealthException() {
            super("Soldier to be alive his/her health should be more than 0 ( < 0)!");
        }
    }

    public static class InvalidDamageException extends RuntimeException {
        public InvalidDamageException() {
            super("Damage can't be negative!");
        }
    }

}
