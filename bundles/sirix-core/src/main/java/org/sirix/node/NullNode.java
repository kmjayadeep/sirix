/**
 * Copyright (c) 2011, University of Konstanz, Distributed Systems Group
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the University of Konstanz nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sirix.node;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.base.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.sirix.api.visitor.EVisitResult;
import org.sirix.api.visitor.IVisitor;
import org.sirix.node.interfaces.INode;
import org.sirix.node.interfaces.IStructNode;
import org.sirix.settings.EFixed;

/**
 * Null node (NullObject pattern).
 * 
 * @author Johannes Lichtenberger, University of Konstanz
 * 
 */
public final class NullNode implements IStructNode {

  /** The underlying item. */
  private final INode mNode;

  /**
   * Constructor.
   * 
   * @param pNode
   *          the underlying node which is wrapped
   * @throws NullPointerException
   *           if {@code pNode} is {@code null}
   */
  public NullNode(final INode pNode) {
    mNode = checkNotNull(pNode);
  }

  @Override
  public long getFirstChildKey() {
    return EFixed.NULL_NODE_KEY.getStandardProperty();
  }

  @Override
  public void setFirstChildKey(final long mFirstChildKey) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void decrementChildCount() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void incrementChildCount() {
    throw new UnsupportedOperationException();
  }

  @Override
  public EVisitResult acceptVisitor(@Nonnull final IVisitor paramVisitor) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setHash(final long pHash) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long getHash() {
    throw new UnsupportedOperationException();
  }

  @Override
  public long getNodeKey() {
    return mNode.getNodeKey();
  }

  @Override
  public long getParentKey() {
    return mNode.getParentKey();
  }

  @Override
  public boolean hasParent() {
    return mNode.hasParent();
  }

  @Override
  public EKind getKind() {
    return mNode.getKind();
  }

  @Override
  public int getTypeKey() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setParentKey(final long pNodeKey) {
    throw new UnsupportedOperationException();

  }

  @Override
  public void setTypeKey(final int pTypeKey) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasFirstChild() {
    return false;
  }

  @Override
  public boolean hasLeftSibling() {
    return false;
  }

  @Override
  public boolean hasRightSibling() {
    return false;
  }

  @Override
  public long getChildCount() {
    return 0;
  }

  @Override
  public long getLeftSiblingKey() {
    return EFixed.NULL_NODE_KEY.getStandardProperty();
  }

  @Override
  public long getRightSiblingKey() {
    return EFixed.NULL_NODE_KEY.getStandardProperty();
  }

  @Override
  public void setRightSiblingKey(final long pNodeKey) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setLeftSiblingKey(final long pNodeKey) {
    throw new UnsupportedOperationException();
  }

  /** Get the underlying node. */
  public INode getUnderlyingNode() {
    return mNode;
  }

  @Override
  public long getDescendantCount() {
    return 0;
  }

  @Override
  public void decrementDescendantCount() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void incrementDescendantCount() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setDescendantCount(final long pDescendantCount) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean isSameItem(@Nullable final INode pOther) {
    return mNode.isSameItem(pOther);
  }
  
  @Override
  public boolean equals(@Nullable final Object pObj) {
    if (pObj instanceof NullNode) {
      final NullNode other = (NullNode) pObj;
      return Objects.equal(mNode, other.mNode);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(mNode);
  }
}
