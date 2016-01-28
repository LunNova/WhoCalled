package me.nallar.whocalled;

// Deprecated method call - acceptable as this implementation is only used after it is tested by WhoCalledProvider
@SuppressWarnings("deprecation")
class WhoCalledReflection implements WhoCalled {
	@Override
	public Class<?> getContext(int depth) {
		return sun.reflect.Reflection.getCallerClass(depth + 2);
	}

	@Override
	public boolean runningUnder(Class<?> c) {
		for (int i = 3; ; i++) {
			Class caller = sun.reflect.Reflection.getCallerClass(i);

			if (caller == null)
				return false;

			if (caller == c)
				return true;
		}
	}
}
