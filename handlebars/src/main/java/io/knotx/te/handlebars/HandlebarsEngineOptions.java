/*
 * Copyright (C) 2018 Knot.x Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.knotx.te.handlebars;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Describes Handlebars Knot configuration
 */
@DataObject(generateConverter = true, publicConverter = false)
public class HandlebarsEngineOptions {

  /**
   * Default key hash algorithm = MD5
   */
  private static final String DEFAULT_CACHE_KEY_ALGORITHM = "MD5";

  private static final String DEFAULT_START_DELIMITER = "{{";

  private static final String DEFAULT_END_DELIMITER = "}}";

  private String cacheKeyAlgorithm;
  private Long cacheSize;
  private String startDelimiter;
  private String endDelimiter;

  /**
   * Default constructor
   */
  public HandlebarsEngineOptions() {
    init();
  }

  /**
   * Copy constructor
   *
   * @param other the instance to copy
   */
  public HandlebarsEngineOptions(HandlebarsEngineOptions other) {
    this.cacheKeyAlgorithm = other.cacheKeyAlgorithm;
    this.cacheSize = other.cacheSize;
    this.startDelimiter = other.startDelimiter;
    this.endDelimiter = other.endDelimiter;
  }

  /**
   * Create an settings from JSON
   *
   * @param json the JSON
   */
  public HandlebarsEngineOptions(JsonObject json) {
    init();
    HandlebarsEngineOptionsConverter.fromJson(json, this);
  }

  /**
   * Convert to JSON
   *
   * @return the JSON
   */
  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    HandlebarsEngineOptionsConverter.toJson(this, json);
    return json;
  }

  private void init() {
    cacheKeyAlgorithm = DEFAULT_CACHE_KEY_ALGORITHM;
    startDelimiter = DEFAULT_START_DELIMITER;
    endDelimiter = DEFAULT_END_DELIMITER;
  }

  /**
   * @return size of the cache
   */
  public Long getCacheSize() {
    return cacheSize;
  }

  /**
   * Set the size of the cache. After reaching the max size, new elements will replace the oldest one.
   *
   * @param cacheSize size of the cache
   * @return a reference to this, so the API can be used fluently
   */
  public HandlebarsEngineOptions setCacheSize(Long cacheSize) {
    this.cacheSize = cacheSize;
    return this;
  }

  /**
   * @return name of the algorithm used to generate hash from the handlebars snippet
   */
  public String getCacheKeyAlgorithm() {
    return cacheKeyAlgorithm;
  }

  /**
   * Set the algorithm used to build a hash from the handlebars snippet.
   * The hash is to be used as a cache key.
   *
   * The name should be a standard Java Security name (such as "SHA", "MD5", and so on).
   *
   * @param cacheKeyAlgorithm algorithm name
   * @return a reference to this, so the API can be used fluently
   */
  public HandlebarsEngineOptions setCacheKeyAlgorithm(String cacheKeyAlgorithm) {
    this.cacheKeyAlgorithm = cacheKeyAlgorithm;
    return this;
  }

  public String getStartDelimiter() {
    return startDelimiter;
  }

  /**
   * Set the start delimiter for the Handlebars engine to recognize start of placeholders.
   * By default, the Handlebars engine uses `{{` symbols as start delimiter.
   *
   * @param startDelimiter
   * @return
   */
  public HandlebarsEngineOptions setStartDelimiter(String startDelimiter) {
    this.startDelimiter = startDelimiter;
    return this;
  }

  public String getEndDelimiter() {
    return endDelimiter;
  }

  /**
   * Set the end delimiter for the Handlebars engine to recognize en of placeholders.
   * By default, the Handlebars engine uses `}}` symbols as end delimiter.
   * @param endDelimiter
   * @return
   */
  public HandlebarsEngineOptions setEndDelimiter(String endDelimiter) {
    this.endDelimiter = endDelimiter;
    return this;
  }
}
