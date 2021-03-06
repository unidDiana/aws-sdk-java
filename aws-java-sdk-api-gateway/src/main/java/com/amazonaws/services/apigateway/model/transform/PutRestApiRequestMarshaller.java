/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.apigateway.model.transform;

import java.util.Map;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.apigateway.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;

import com.amazonaws.protocol.json.*;

/**
 * PutRestApiRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PutRestApiRequestMarshaller implements Marshaller<Request<PutRestApiRequest>, PutRestApiRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public PutRestApiRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<PutRestApiRequest> marshall(PutRestApiRequest putRestApiRequest) {

        if (putRestApiRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<PutRestApiRequest> request = new DefaultRequest<PutRestApiRequest>(putRestApiRequest, "AmazonApiGateway");

        request.setHttpMethod(HttpMethodName.PUT);

        String uriResourcePath = "/restapis/{restapi_id}";

        uriResourcePath = com.amazonaws.transform.PathMarshallers.NON_GREEDY.marshall(uriResourcePath, "restapi_id", putRestApiRequest.getRestApiId());
        request.setResourcePath(uriResourcePath);

        if (putRestApiRequest.getMode() != null) {
            request.addParameter("mode", StringUtils.fromString(putRestApiRequest.getMode()));
        }

        if (putRestApiRequest.getFailOnWarnings() != null) {
            request.addParameter("failonwarnings", StringUtils.fromBoolean(putRestApiRequest.getFailOnWarnings()));
        }

        java.util.Map<String, String> parameters = putRestApiRequest.getParameters();
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                if (entry.getValue() != null) {
                    request.addParameter(StringUtils.fromString(entry.getKey()), StringUtils.fromString(entry.getValue()));
                }
            }
        }

        request.setContent(BinaryUtils.toStream(putRestApiRequest.getBody()));
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", protocolFactory.getContentType());
        }

        return request;
    }

}
