/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.apache.fluo.core.exceptions;

import org.apache.fluo.accumulo.iterators.GarbageCollectionIterator;
import org.apache.fluo.api.exceptions.FluoException;
import org.apache.fluo.core.impl.TimestampTracker;

/**
 * This exception is thrown if a table has aged off data necessary to complete a scan at a certain
 * timestamp. This exception should never be thrown now that clients use the
 * {@link TimestampTracker} to maintain their oldest active timestamp in Zookeeper. The
 * {@link GarbageCollectionIterator} will determine the oldest active timestamp of all clients
 * before data is aged off.
 */
public class StaleScanException extends FluoException {

  private static final long serialVersionUID = 1L;

  public StaleScanException(String msg) {
    super(msg);
  }

  public StaleScanException() {
    super();
  }
}
