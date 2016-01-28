package me.nallar.whocalled;

class WhoCalledSecurityManager extends SecurityManager implements WhoCalled {
	@Override
	public Class<?> getContext(int depth) {
		return getClassContext()[depth + 1];
	}

	@Override
	public boolean runningUnder(Class<?> c) {
		Class<?>[] classes = getClassContext();
		for (int i = 2; i < classes.length; i++) {
			if (classes[i] == c) {
				return true;
			}
		}
		return false;
	}
}
