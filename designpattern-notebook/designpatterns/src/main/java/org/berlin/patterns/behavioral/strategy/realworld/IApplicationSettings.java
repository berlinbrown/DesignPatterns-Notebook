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
 * Settings interface for application settings.
 * <p>
 * <i>internalErrorPage </i>- You can override this with your own page class to display internal
 * errors in a different way.
 * <p>
 * <i>pageExpiredErrorPage </i>- You can override this with your own bookmarkable page class to
 * display expired page errors in a different way. You can set property homePageRenderStrategy to
 * choose from different ways the home page url shows up in your browser.
 * <p>
 * <b>A Converter Factory </b>- By overriding getConverterFactory(), you can provide your own
 * factory which creates locale sensitive Converter instances.
 * 
 * @author Jonathan Locke
 */
public interface IApplicationSettings
{
}
