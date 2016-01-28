package me.nallar.whocalled;

public interface WhoCalled {
	WhoCalled $ = WhoCalledProvider.getWhoCalled();

	/**
	 * Returns the Class of the method which is one level above the current method.
	 * <p/>
	 * For example, if you call WhoCalled.$.getCallingClass in the Example.whoCalled(), which was called by Main.main(),
	 * it will return Main.class.
	 *
	 * @return Calling class
	 */
	Class<?> getCallingClass();

	/**
	 * Returns the Class of the method which is (depth) levels above the current method.
	 * <p/>
	 * For example, if you call WhoCalled.$.getCallingClass(0) in the Example class, it will return
	 * Example.class.
	 *
	 * @param depth Depth of class to get. 0 = current method, 1 = caller, etc.
	 * @return Calling class
	 */
	Class<?> getCallingClass(int depth);

	boolean isCalledByClass(Class<?> c);
}
