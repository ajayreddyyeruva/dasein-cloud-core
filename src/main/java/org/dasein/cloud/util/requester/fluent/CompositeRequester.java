package org.dasein.cloud.util.requester.fluent;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.util.requester.DaseinRequestExecutor;
import org.dasein.cloud.util.requester.DriverToCoreMapper;
import org.json.JSONObject;
import org.w3c.dom.Document;

 /**
 * @author Vlad Munthiu
 */
public interface CompositeRequester extends Requester<String> {
    <T> Requester<T> withXmlProcessor(Class<T> classType);
    <T, V> Requester<V> withXmlProcessor(DriverToCoreMapper<T, V> mapper, Class<T> classType);
    <T> Requester<T> withJsonProcessor(Class<T> classType);
    <T, V> Requester<V> withJsonProcessor(DriverToCoreMapper<T, V> mapper, Class<T> classType);
    <T> DaseinRequestExecutor<Document> withDocumentProcessor();
    <T> DaseinRequestExecutor<JSONObject> withJSONObjectProcessor();
    String execute() throws CloudException;
}
