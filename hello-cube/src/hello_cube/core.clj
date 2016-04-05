(ns hello-cube.core
  (:gen-class)
  (:require [thi.ng.geom.core :as g]
            [thi.ng.geom.mesh.io :as mio]
            [thi.ng.geom.cuboid :as cube]
            [clojure.java.io :as io]))

(defn save-stl
  "Takes file path and mesh instance, saves mesh as STL"
  [path mesh]
  (with-open [out (io/output-stream path)]
    (mio/write-stl
     (mio/wrapped-output-stream out)
     (g/tessellate mesh))))


(defn -main
  "Hello cube!"
  [& args]
  (save-stl (g/as-mesh (g/center (cube/cuboid 1)))))

;uncomment and evaluate in repl to get a 3D printable cube spit into this
;project directory!.
;(main)
