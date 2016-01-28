package me.nallar.whocalled;

class WhoCalledProvider {
	private static final Class<?>[] contextAccessClasses = {
		WhoCalledReflection.class,
		WhoCalledSecurityManager.class,
	};

	static WhoCalled getWhoCalled() {
		for (Class<?> clazz : contextAccessClasses) {
			try {
				WhoCalled whoCalled = (WhoCalled) clazz.newInstance();
				Class<?> currentClass = whoCalled.getCallingClass(0);
				if (currentClass != WhoCalledProvider.class) {
					StringBuilder sb = new StringBuilder();
					sb.append("Stack:\n");
					for (int i = -2; i < 3; i++) {
						try {
							sb.append(whoCalled.getCallingClass(i).getName()).append(" at ").append(i).append('\n');
						} catch (Throwable ignored) {
						}
					}
					throw new Error("Wrong class returned: " + currentClass + ", expected WhoCalledProvider. " + sb);
				}
				return whoCalled;
			} catch (Throwable ignored) {
				// ignore, try another context access
			}
		}
		throw new Error("Failed to set up any context access");
	}
}
