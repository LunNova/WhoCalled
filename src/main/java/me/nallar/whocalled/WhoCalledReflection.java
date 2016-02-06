package me.nallar.whocalled;

// Deprecated method call - acceptable as this implementation is only used after it is tested by WhoCalledProvider
@SuppressWarnings("deprecation")
class WhoCalledReflection extends SecurityManager implements WhoCalled {
	private static final int OFFSET = 2;

	@Override
	public Class<?> getCallingClass() {
		return sun.reflect.Reflection.getCallerClass(OFFSET + 1);
	}

	@Override
	public Class<?> getCallingClass(int depth) {
		return sun.reflect.Reflection.getCallerClass(OFFSET + depth);
	}

	@Override
	public boolean isCalledByClass(Class<?> clazz) {
		// Using SecurityManager is better performing than Reflection for isCalledByClass unless the stack depth is very small
		// So WhoCalledReflection uses SecurityManager for this method
		Class<?>[] classes = getClassContext();

		for (int i = OFFSET; i < classes.length; i++) {
			if (classes[i] == clazz) {
				return true;
			}
		}

		return false;
	}

	boolean isCalledByClassReflection(Class<?> clazz) {
		for (int i = OFFSET + 1; ; i++) {
			Class<?> caller = sun.reflect.Reflection.getCallerClass(i);

			if (caller == null)
				return false;

			if (caller == clazz)
				return true;
		}
	}
}
