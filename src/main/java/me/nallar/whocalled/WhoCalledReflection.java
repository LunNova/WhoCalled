package me.nallar.whocalled;

// Deprecated method call - acceptable as this implementation is only used after it is tested by WhoCalledProvider
@SuppressWarnings("deprecation")
class WhoCalledReflection implements WhoCalled {
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
		for (int i = OFFSET + 1; ; i++) {
			Class<?> caller = sun.reflect.Reflection.getCallerClass(i);

			if (caller == null)
				return false;

			if (caller == clazz)
				return true;
		}
	}
}
