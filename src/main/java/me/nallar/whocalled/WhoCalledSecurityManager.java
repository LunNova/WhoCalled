package me.nallar.whocalled;

class WhoCalledSecurityManager extends SecurityManager implements WhoCalled {
	private static final int OFFSET = 1;

	@Override
	public Class<?> getCallingClass() {
		return getClassContext()[OFFSET + 1];
	}

	@Override
	public Class<?> getCallingClass(int depth) {
		return getClassContext()[OFFSET + depth];
	}

	@Override
	public boolean isCalledByClass(Class<?> c) {
		Class<?>[] classes = getClassContext();

		for (int i = OFFSET + 1; i < classes.length; i++) {
			if (classes[i] == c) {
				return true;
			}
		}

		return false;
	}
}
