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

;If you want to learn more than how to generate a simple cube then I definitely recommend checking out the overview
;section at https://github.com/thi-ng/geom/tree/develop which shows a list of tutorials to help you get started
;using the geom library. It's a great set of tools that is quite frankly far too huge to accurately start covering
;here, but if you want to start generating your own meshes you can also check out this project:
; https://github.com/TimothyStiles/hexer/blob/master/src/hexer/core.clj
;that I wrote to generate hexagonal terrain to give you an idea of what you can do with geom in an afternoon.
