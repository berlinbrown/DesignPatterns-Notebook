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
package org.berlin.patterns.behavioral.strategy.realworld;

/**
 * Interface for security related settings
 * 
 * @author Igor Vaynberg (ivaynberg)
 */
public interface ISecuritySettings
{
	/**
	 * encryption key used by default crypt factory
	 */
	public static final String DEFAULT_ENCRYPTION_KEY = "WiCkEt-FRAMEwork";

	/**
	 * Gets the authorization strategy.
	 * 
	 * @return Returns the authorizationStrategy.
	 */
	IAuthorizationStrategy getAuthorizationStrategy();

	/**
	 * Gets whether mounts should be enforced. If true, requests for mounted targets have to done
	 * through the mounted paths. If, for instance, a bookmarkable page is mounted to a path, a
	 * request to that same page via the bookmarkablePage parameter will be denied.
	 * 
	 * @return Whether mounts should be enforced
	 */
	boolean getEnforceMounts();

	/**
	 * Sets the authorization strategy.
	 * 
	 * @param strategy
	 *            new authorization strategy
	 * 
	 */
	void setAuthorizationStrategy(IAuthorizationStrategy strategy);

	

}
