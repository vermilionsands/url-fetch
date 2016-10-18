(defproject url-fetch "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "1.1.8"]
                 [clj-http "2.3.0"]
                 [org.clojure/core.memoize "0.5.8"]]
  :ring {:handler url-fetch.handler/app}
  :uberjar-name "url-fetch.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[ikitommi/lein-ring "0.9.8-FIX"]]}})
