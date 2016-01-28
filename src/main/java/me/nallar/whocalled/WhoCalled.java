package me.nallar.whocalled;

public interface WhoCalled {
	WhoCalled $ = WhoCalledProvider.getWhoCalled();

	/**
	 * Returns the Class of the method which is one level above the current method.
	 *
	 * For example, if you call WhoCalled.$.getCallingClass in the Example.whoCalled(), which was called by Main.main(),
	 * it will return Main.class.
	 *
	 * @return Calling class
	 */
	Class<?> getCallingClass();

	/**
	 * Returns the Class of the method which is (depth) levels above the current method.
	 *
	 * For example, if you call WhoCalled.$.getCallingClass(0) in the Example class, it will return
	 * Example.class.
	 *
	 * @param depth Depth of class to get. 0 = current method, 1 = caller, etc.
	 * @return Calling class
	 */
	Class<?> getCallingClass(int depth);

	/**
	 * Returns whether the given class is one of the calling classes
	 *
	 * @param clazz Class to search for in callers
	 * @return true if the class clazz is a caller of this class
	 */
	boolean isCalledByClass(Class<?> clazz);
}
