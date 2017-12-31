/*
 * Copyright 2017-2018 Emmanuel Keller / Jaeksoft
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  <p>
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jaeksoft.opensearchserver.front;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class CrawlerWebTransaction extends IndexBaseTransaction {

	private final static String TEMPLATE_INDEX = "web_crawl.ftl";

	private final String crawlName;

	CrawlerWebTransaction(final IndexServlet servlet, final String indexName, final String crawlName,
			final HttpServletRequest request, final HttpServletResponse response) {
		super(servlet, indexName, request, response);
		this.crawlName = crawlName;
	}

	@Override
	void doGet() throws IOException, ServletException {
		request.setAttribute("indexName", indexName);
		doTemplate(TEMPLATE_INDEX);
	}
}