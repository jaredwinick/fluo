/*
 * Copyright 2014 Fluo authors (see AUTHORS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fluo.api.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import io.fluo.api.data.Bytes;
import io.fluo.api.data.Column;
import io.fluo.api.data.Span;

/**
 * Configures Scanner
 */
public class ScannerConfiguration implements Cloneable {

  private Span span = new Span();
  // TODO use a set
  private ArrayList<Column> columns = new ArrayList<>();

  public ScannerConfiguration setSpan(Span span) {
    this.span = span;
    return this;
  }

  public Span getSpan() {
    return span;
  }

  public List<Column> getColumns() {
    return Collections.unmodifiableList(columns);
  }

  // TODO document SnapshotIterator

  public ScannerConfiguration fetchColumnFamily(Bytes col) {
    Preconditions.checkNotNull(col);
    // TODO causes NPE w/ set, add unit test
    columns.add(new Column(col, null));
    return this;
  }

  public ScannerConfiguration fetchColumn(Bytes colFam, Bytes colQual) {
    Preconditions.checkNotNull(colFam, colQual);
    columns.add(new Column(colFam, colQual));
    return this;
  }


  public void clearColumns() {
    columns.clear();
  }

  @Override
  @SuppressWarnings("unchecked")
  public Object clone() throws CloneNotSupportedException {
    ScannerConfiguration sc = (ScannerConfiguration) super.clone();

    sc.columns = (ArrayList<Column>) columns.clone();
    sc.span = span;

    return sc;
  }
}
