package me.nallar.whocalled;

interface WhoCalled {
	WhoCalled INSTANCE = WhoCalledProvider.getContextAccess();

	/**
	 * @param depth Depth of class to get - 0 = method you're calling this from, 1 = caller of the method calling getContext, 2 = caller's caller etc.
	 * @return Class object for context
	 */
	Class<?> getContext(int depth);

	boolean runningUnder(Class<?> c);
}
