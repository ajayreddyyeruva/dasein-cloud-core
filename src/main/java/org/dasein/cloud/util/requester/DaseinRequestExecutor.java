/**
 * Copyright (C) 2009-2016 Dell, Inc.
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.util.requester;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.util.requester.fluent.Requester;

/**
 * @author Vlad Munthiu
 */

public class DaseinRequestExecutor<T> extends AbstractDaseinRequestExecutor<T> implements Requester<T> {
    private HttpUriRequest httpUriRequest;

    public DaseinRequestExecutor(CloudProvider provider, HttpClientBuilder httpClientBuilder, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler){
        super(provider, httpClientBuilder, responseHandler);
        this.httpUriRequest = httpUriRequest;
    }

    public T execute() throws CloudException {
        return execute(this.httpUriRequest);
    }
}
