(require '[ring.adapter.jetty :refer [run-jetty]])
(require '[ring.middleware.defaults :refer [wrap-defaults site-defaults]])
(require '[ring.util.response :refer [resource-response content-type]])

(defn handler
  "Passes all requests back to index.html which is needed
  for client-side deep-linking"
  [req]
  (some-> (resource-response "index.html" {:root "public"})
          (content-type "text/html; charset=utf-8")))

(run-jetty
  (wrap-defaults handler site-defaults)
  {:port 4000})
