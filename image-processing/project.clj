(defproject image-processing "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/TimothyStiles/image-processing"
  :license {:name "Apache Software License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [funimage "0.1.88"]]
  :main image-processing.core
  :jvm-opts ["-Xmx128g" "-server"] 
  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"])
