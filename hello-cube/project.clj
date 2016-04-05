(defproject hello-cube "0.1.0-SNAPSHOT"
  :description "Using Geom to create a cube mesh"
  :url "http://github/TimothyStiles/cs284/hello-cube"
  :license {:name "Apache Software License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [thi.ng/geom "0.0.1050"]]
  :main ^:skip-aot hello-cube.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
