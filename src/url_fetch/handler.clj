(ns url-fetch.handler
  (:require [clojure.core.memoize :as m]
            [compojure.api.sweet :refer :all]
            [clj-http.client :as client]))

(defn fetch-url [url]
  (client/get url))

(def fetch-url-with-cache
  (m/lru fetch-url :lru/threshold 1000))

(defn url-handler [url]
  (fetch-url-with-cache url))

(defapi app
  (GET "/" [] "")
  (GET "/url" []
    :query-params [url :- String]
    (url-handler url)))
