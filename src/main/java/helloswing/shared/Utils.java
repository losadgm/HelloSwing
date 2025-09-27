package helloswing.shared;

/**
 * Utility class providing common helper methods for validation and general
 * operations. This class cannot be instantiated.
 */
public final class Utils {

    /**
     * Private constructor to prevent instantiation.
     */
    private Utils() {
	throw new AssertionError("Utils class should not be instantiated");
    }

    /**
     * Validates that none of the provided arguments are null.
     * 
     * @param args the arguments to check for null values
     * @throws IllegalArgumentException if any argument is null
     */
    public static void checkNullArgs(Object... args) {
	for (Object arg : args) {
	    if (arg == null) {
		throw new IllegalArgumentException("Null argument not allowed");
	    }
	}
    }
}
