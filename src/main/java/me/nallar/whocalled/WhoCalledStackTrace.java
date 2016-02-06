package me.nallar.whocalled;

/**
 * StackTrace is very slow.
 * This class should not actually be used unless the SecurityManager implementation is broken by a future java update.
 * This is extremely unlikely.
 */
class WhoCalledStackTrace implements WhoCalled {
	private static final int OFFSET = 1;

	@Override
	public Class<?> getCallingClass() {
		try {
			return Class.forName(Thread.currentThread().getStackTrace()[OFFSET + 1].getClassName());
		} catch (ClassNotFoundException e) {
			throw new NoClassDefFoundError(e.getMessage());
		}
	}

	@Override
	public Class<?> getCallingClass(int depth) {
		try {
			return Class.forName(Thread.currentThread().getStackTrace()[OFFSET + depth].getClassName());
		} catch (ClassNotFoundException e) {
			throw new NoClassDefFoundError(e.getMessage());
		}
	}

	@Override
	public boolean isCalledByClass(Class<?> clazz) {
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
			if (element.getClassName().equals(clazz.getName())) {
				return true;
			}
		}
		return false;
	}
}
