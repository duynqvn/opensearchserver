/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2012 Emmanuel Keller / Jaeksoft
 * 
 * http://www.open-search-server.com
 * 
 * This file is part of OpenSearchServer.
 *
 * OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with OpenSearchServer. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.result;

final public class ResultScoreDocCollapseJoin extends ResultScoreDocCollapse
		implements ResultScoreDocJoinInterface {

	final private int[] foreignDocIds;

	protected ResultScoreDocCollapseJoin(ResultScoreDocJoin rsdj) {
		super(rsdj);
		this.foreignDocIds = rsdj.getForeignDocIds();
	}

	public ResultScoreDocCollapseJoin(ResultScoreDocCollapseJoin doc) {
		super(doc);
		this.foreignDocIds = doc.foreignDocIds;
	}

	@Override
	public ResultScoreDocCollapse newResultScoreDocCollapse() {
		return ResultScoreDocCollapseJoin.newInstance(this);
	}

	@Override
	final public int[] getForeignDocIds() {
		return foreignDocIds;
	}

	@Override
	final public void setForeignDocId(int pos, int doc) {
		foreignDocIds[pos] = doc;
	}

	@Override
	final public ResultScoreDoc getForeignDoc(int pos) {
		return new ResultScoreDoc(foreignDocIds[pos], score);
	}

}