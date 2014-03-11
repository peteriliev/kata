/**
 * TestSetProviderSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.iliev.peter.kata.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * TestSetProviderSkeleton java skeleton for the axisService
 */
public class TestSetProviderSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param getAll
	 * @return getAllResponse
	 */

	public com.iliev.peter.kata.utils.GetAllResponse getAll(com.iliev.peter.kata.utils.GetAll getAll) {
		com.iliev.peter.kata.utils.GetAllResponse response = new com.iliev.peter.kata.utils.GetAllResponse();

		response.add_return(fromOldSet(getEmptyValue()));
		response.add_return(fromOldSet(getSingleValue()));
		response.add_return(fromOldSet(getMinusOneZeroPlusOneSet()));
		// response.add_return(fromOldSet(getMaxValuesSets()));
		response.add_return(fromOldSet(get2Sets()));
		response.add_return(fromOldSet(get22Sets()));
		response.add_return(fromOldSet(getBigSet()));
		response.add_return(fromOldSet(getHeapSet()));

		response.add_return(fromOldSet(getRandomSet()));
		response.add_return(fromOldSet(getRandomSet()));
		response.add_return(fromOldSet(getRandomSet()));

		return response;
	}

	private static com.iliev.peter.kata.conventions.xsd.ISortTestSet getRandomSet2() {

		final int randomLenght = 250 + (new Random(9839021).nextInt(777));

		final int[] unorder = new int[randomLenght];

		for (int i = 0; i < randomLenght; i++) {
			unorder[i] = (new Random().nextInt(1024)) - 512;
		}

		final int[] orderred = Arrays.copyOf(unorder, randomLenght);
		Arrays.sort(orderred);

		final com.iliev.peter.kata.conventions.xsd.ISortTestSet result = new com.iliev.peter.kata.conventions.xsd.ISortTestSet();

		result.setSortedSet(orderred);

		final com.iliev.peter.kata.conventions.xsd.ArrayOfInteger arr = new com.iliev.peter.kata.conventions.xsd.ArrayOfInteger();
		arr.setArray(unorder);

		result.addUnsortedSets(arr);

		return result;

		/*
		 * return new com.iliev.peter.kata.conventions.xsd.ISortTestSet() {
		 * 
		 * public Integer[] getSortedSet() { return orderred; }
		 * 
		 * public Integer[][] getUnsortedSets() { return new Integer[][] {
		 * unorder }; } };
		 */}

	private static com.iliev.peter.kata.conventions.xsd.ISortTestSet fromOldSet(final ISortTestSet old) {

		final com.iliev.peter.kata.conventions.xsd.ISortTestSet result = new com.iliev.peter.kata.conventions.xsd.ISortTestSet();
		result.setSortedSet(fromWrapped(old.getSortedSet()));

		for (final Integer[] uo : old.getUnsortedSets()) {
			final com.iliev.peter.kata.conventions.xsd.ArrayOfInteger arr = new com.iliev.peter.kata.conventions.xsd.ArrayOfInteger();
			arr.setArray(fromWrapped(uo));
			result.addUnsortedSets(arr);
		}

		return result;
	}

	private static int[] fromWrapped(final Integer[] wrap) {
		if (null == wrap) {
			return new int[] {};
		}

		final int[] result = new int[wrap.length];
		for (int i = 0; i < wrap.length; i++) {
			result[i] = wrap[i];
		}

		return result;
	}

	private static ISortTestSet getRandomSet() {

		final int randomLenght = 250 + (new Random(9839021).nextInt(777));

		final Integer[] unorder = new Integer[randomLenght];

		for (int i = 0; i < randomLenght; i++) {
			unorder[i] = (new Random().nextInt(1024)) - 512;
		}

		final Integer[] orderred = Arrays.copyOf(unorder, randomLenght);
		Arrays.sort(orderred);

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return orderred;
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { unorder };
			}
		};
	}

	private static ISortTestSet getBigSet() {
		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { 7, 17, 18, 25, 28, 47, 53, 62, 69, 83, 86, 95 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { 62, 83, 18, 53, 7, 17, 95, 86, 47, 69, 25, 28 } };
			}
		};
	}

	private static ISortTestSet getEmptyValue() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] {};
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] {} };
			}
		};
	}

	private static ISortTestSet getSingleValue() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { -1 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { -1 } };
			}
		};
	}

	private static ISortTestSet getMinusOneZeroPlusOneSet() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { -1, 0, 1 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { -1, 0, 1 }, new Integer[] { -1, 1, 0 },

				new Integer[] { 0, -1, 1 }, new Integer[] { 0, 1, -1 },

				new Integer[] { 1, 0, -1 }, new Integer[] { 1, -1, 0 }, };
			}
		};
	}

	private static ISortTestSet get2Sets() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { -1, 0 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { -1, 0 }, new Integer[] { 0, -1 }, };
			}
		};
	}

	private static ISortTestSet get22Sets() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { -1, -1, 0, 1, 1 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { 1, -1, -1, 0, 1 }, new Integer[] { 1, 1, -1, -1, 0 } };
			}
		};
	}

	private static ISortTestSet getHeapSet() {

		return new ISortTestSet() {

			@Override
			public Integer[] getSortedSet() {
				return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 100, 200, 1000 };
			}

			@Override
			public Integer[][] getUnsortedSets() {
				return new Integer[][] { new Integer[] { 1000, 100, 200, 8, 6, 7, 1, 5, 3, 2, 4 } };
			}
		};
	}

	/*
	 * private static ISortTestSet getMaxValuesSets() {
	 * 
	 * return new ISortTestSet() {
	 * 
	 * @Override public Integer[] getSortedSet() { return new Integer[] {
	 * Integer.MIN_VALUE, 0, Integer.MAX_VALUE }; }
	 * 
	 * @Override public Integer[][] getUnsortedSets() { return new Integer[][] {
	 * 
	 * new Integer[] { Integer.MIN_VALUE, 0, Integer.MAX_VALUE }, new Integer[]
	 * { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 },
	 * 
	 * new Integer[] { 0, Integer.MIN_VALUE, Integer.MAX_VALUE }, new Integer[]
	 * { 0, Integer.MAX_VALUE, Integer.MIN_VALUE },
	 * 
	 * new Integer[] { Integer.MAX_VALUE, 0, Integer.MIN_VALUE }, new Integer[]
	 * { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 }, }; } }; }
	 */
}
