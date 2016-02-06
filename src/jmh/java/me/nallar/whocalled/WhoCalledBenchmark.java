package me.nallar.whocalled;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.*;

public class WhoCalledBenchmark {
	private static final WhoCalledSecurityManager whoCalledSecurityManager = new WhoCalledSecurityManager();
	private static final WhoCalledReflection whoCalledReflection = new WhoCalledReflection();
	private static final WhoCalledStackTrace whoCalledStackTrace = new WhoCalledStackTrace();

	@Benchmark
	public void testSecurityManagerGet() {
		whoCalledSecurityManager.getCallingClass();
	}

	@Benchmark
	public void testSecurityManagerCalledBy() {
		whoCalledSecurityManager.isCalledByClass(ArrayList.class);
	}

	@Benchmark
	public void testReflectionGet() {
		whoCalledReflection.getCallingClass();
	}

	@Benchmark
	public void testReflectionCalledBy() {
		whoCalledReflection.isCalledByClassReflection(ArrayList.class);
	}

	@Benchmark
	public void testStackTraceGet() {
		whoCalledStackTrace.getCallingClass();
	}

	@Benchmark
	public void testStackTraceCalledBy() {
		whoCalledStackTrace.isCalledByClass(ArrayList.class);
	}
}
