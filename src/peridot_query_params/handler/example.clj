(ns peridot-query-params.handler.example
  (:require
    [compojure.core :refer :all]
    [clojure.java.io :as io]
    [integrant.core :as ig]))


(defmethod ig/init-key :peridot-query-params.handler/example [_ options]
  (context "/example" []
    (GET "/" [foo baz]
      (println "foo: " foo)
      (println "baz: " baz)
      (io/resource "peridot_query_params/handler/example/example.html"))))
