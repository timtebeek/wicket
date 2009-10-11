/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.util.lang;

import org.apache.wicket.util.string.Strings;

public class Checks
{
	public static void argumentNotNull(Object argument, String name)
	{
		if (argument == null)
		{
			throw new IllegalArgumentException("Argument '" + name + "' may not be null.");
		}
	}

	public static void argumentNotEmpty(String argument, String name)
	{
		if (Strings.isEmpty(argument))
		{
			throw new IllegalArgumentException("Argument '" + name +
				"' may not be null or empty string.");
		}
	}

	/**
	 * TODO javadoc and unit test
	 * 
	 * @param <T>
	 * @param min
	 * @param max
	 * @param value
	 * @param name
	 */
	public static <T extends Comparable<T>> void argumentWithinRange(T min, T max, T value,
		String name)
	{
		// TODO nullchecks
		if (value.compareTo(min) < 0 || value.compareTo(max) > 0)
		{
			throw new IllegalArgumentException(
				String.format("Argument '%s' must have a value within [%s,%s], but was %s", name,
					min, max, value));
		}

		return;
	}
}
