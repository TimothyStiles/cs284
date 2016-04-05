(ns image-processing.core
  (:use [funimage imp]
        [funimage.imp.calculator])
  #_(:require [funimage imp :as imp]
            [funimage project :as proj]
            [funimage util :as util])
  (:gen-class))

; This tutorial is a little more advanced than the others that I have written for this
; class. All of the functions used here can be found at either:
; https://github.com/funimage/funimage/blob/master/src/funimage/imp.clj
; or
; https://github.com/funimage/funimage/blob/master/src/funimage/imp/calculator.clj
; Also having a basic understanding of how image convolution works will surely help
; in any of your image processing endeavors so be sure to check out this wikicommons
; graphic to understand how I am "mutating" these pokemon.
; https://commons.wikimedia.org/wiki/File:3D_Convolution_Animation.gif
; convolution is easy to understand visually and explain in person but its pretty hard
; to convey in writing so feel free to ask me in class or in my TA hours about how 
; convolution works if you can't figure it out on your own! 

; generating a list of filepaths to images of pokemon. the ->> is called a threading macro.
(def pokedex (->> "resources/pokemon"
                  (clojure.java.io/file)
                  (file-seq)
                  (drop 2)
                  (map str)))

(defn pokediff
  "opens 2 random pokemon and subtracts them from eachother. A whole list of similar
  operators can be found at:
  https://github.com/funimage/funimage/blob/master/src/funimage/imp/calculator.clj"
  []
  (apply imp-subtract (repeatedly 2 #(open-imp (rand-nth pokedex)))))

;saves example output
(save-imp (pokediff) "resources/output/rand-pokediff.png")

(defn random-kernel
  "generates a random filter that can be used to transform an image like an anonymous function."
  [width]
  (float-array (repeatedly (* width width) #(* (rand 2) (rand-nth (range -10 10))))))

(defn pokemutate
  "opens an image and applies a random kernel to it."
  []
  (convolve (open-imp (rand-nth pokedex)) (random-kernel 3) 3 3))

;saving the result of a single convolution.
(save-imp (pokemutate) "resources/output/poke-mutate.png")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
