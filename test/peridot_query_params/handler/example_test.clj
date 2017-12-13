(ns peridot-query-params.handler.example-test
  (:require
    [clojure.test :refer :all]
    [integrant.core :as ig]
    [kerodon.core :as kc]
    [kerodon.test :as kt]
    [peridot.core :as peridot]
    [ring.mock.request :as mock]
    [peridot-query-params.handler.example :as example]))


(deftest smoke-test
  (testing "example page exists"
    (let [handler  (ig/init-key :peridot-query-params.handler/example {})]
      (-> handler
          kc/session
          (peridot/request "/example?foo=bar" :params {:baz "buz"})
          (kt/has (kt/status? 200))))))
