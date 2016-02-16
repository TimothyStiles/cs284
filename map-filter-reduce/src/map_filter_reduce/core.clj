;; gorilla-repl.fileformat = 1

;; @@
(ns map-filter-reduce.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;map-filter-reduce.core/-main</span>","value":"#'map-filter-reduce.core/-main"}
;; <=

;; @@
; Wikipedia has the following to say about MapReduce: "MapReduce is a programming model and an associated implementation for processing and generating large data sets with a parallel, distributed algorithm on a cluster."

; There you have have it. 
; If you understand most of this tutorial you will know how to write code that can run in parallel. 
; If you already know about MapReduce skip to the end to find about how easy it is to write parallel code in clojure.
; Now lets get started!
;; @@

;; @@
; Given a list of numbers.
(range 10)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(0 1 2 3 4 5 6 7 8 9)</span>","value":"(0 1 2 3 4 5 6 7 8 9)"}
;; <=

;; @@
; We can quickly map over all of them and add one to each element.
(map inc (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"(1 2 3 4 5 6 7 8 9 10)"}
;; <=

;; @@
; Mappings work great for when all elements in a list can be transformed independently. 
; Here we can transform all numbers between 97 and 122 to their ascii related characters.

(map char (range 97 122))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-char'>\\a</span>","value":"\\a"},{"type":"html","content":"<span class='clj-char'>\\b</span>","value":"\\b"},{"type":"html","content":"<span class='clj-char'>\\c</span>","value":"\\c"},{"type":"html","content":"<span class='clj-char'>\\d</span>","value":"\\d"},{"type":"html","content":"<span class='clj-char'>\\e</span>","value":"\\e"},{"type":"html","content":"<span class='clj-char'>\\f</span>","value":"\\f"},{"type":"html","content":"<span class='clj-char'>\\g</span>","value":"\\g"},{"type":"html","content":"<span class='clj-char'>\\h</span>","value":"\\h"},{"type":"html","content":"<span class='clj-char'>\\i</span>","value":"\\i"},{"type":"html","content":"<span class='clj-char'>\\j</span>","value":"\\j"},{"type":"html","content":"<span class='clj-char'>\\k</span>","value":"\\k"},{"type":"html","content":"<span class='clj-char'>\\l</span>","value":"\\l"},{"type":"html","content":"<span class='clj-char'>\\m</span>","value":"\\m"},{"type":"html","content":"<span class='clj-char'>\\n</span>","value":"\\n"},{"type":"html","content":"<span class='clj-char'>\\o</span>","value":"\\o"},{"type":"html","content":"<span class='clj-char'>\\p</span>","value":"\\p"},{"type":"html","content":"<span class='clj-char'>\\q</span>","value":"\\q"},{"type":"html","content":"<span class='clj-char'>\\r</span>","value":"\\r"},{"type":"html","content":"<span class='clj-char'>\\s</span>","value":"\\s"},{"type":"html","content":"<span class='clj-char'>\\t</span>","value":"\\t"},{"type":"html","content":"<span class='clj-char'>\\u</span>","value":"\\u"},{"type":"html","content":"<span class='clj-char'>\\v</span>","value":"\\v"},{"type":"html","content":"<span class='clj-char'>\\w</span>","value":"\\w"},{"type":"html","content":"<span class='clj-char'>\\x</span>","value":"\\x"},{"type":"html","content":"<span class='clj-char'>\\y</span>","value":"\\y"}],"value":"(\\a \\b \\c \\d \\e \\f \\g \\h \\i \\j \\k \\l \\m \\n \\o \\p \\q \\r \\s \\t \\u \\v \\w \\x \\y)"}
;; <=

;; @@
; But something seems off there. I really like the little quotes around strings. 
; Maybe we will just map str over the last line.

(map str (map char (range 97 122)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;a&quot;</span>","value":"\"a\""},{"type":"html","content":"<span class='clj-string'>&quot;b&quot;</span>","value":"\"b\""},{"type":"html","content":"<span class='clj-string'>&quot;c&quot;</span>","value":"\"c\""},{"type":"html","content":"<span class='clj-string'>&quot;d&quot;</span>","value":"\"d\""},{"type":"html","content":"<span class='clj-string'>&quot;e&quot;</span>","value":"\"e\""},{"type":"html","content":"<span class='clj-string'>&quot;f&quot;</span>","value":"\"f\""},{"type":"html","content":"<span class='clj-string'>&quot;g&quot;</span>","value":"\"g\""},{"type":"html","content":"<span class='clj-string'>&quot;h&quot;</span>","value":"\"h\""},{"type":"html","content":"<span class='clj-string'>&quot;i&quot;</span>","value":"\"i\""},{"type":"html","content":"<span class='clj-string'>&quot;j&quot;</span>","value":"\"j\""},{"type":"html","content":"<span class='clj-string'>&quot;k&quot;</span>","value":"\"k\""},{"type":"html","content":"<span class='clj-string'>&quot;l&quot;</span>","value":"\"l\""},{"type":"html","content":"<span class='clj-string'>&quot;m&quot;</span>","value":"\"m\""},{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-string'>&quot;o&quot;</span>","value":"\"o\""},{"type":"html","content":"<span class='clj-string'>&quot;p&quot;</span>","value":"\"p\""},{"type":"html","content":"<span class='clj-string'>&quot;q&quot;</span>","value":"\"q\""},{"type":"html","content":"<span class='clj-string'>&quot;r&quot;</span>","value":"\"r\""},{"type":"html","content":"<span class='clj-string'>&quot;s&quot;</span>","value":"\"s\""},{"type":"html","content":"<span class='clj-string'>&quot;t&quot;</span>","value":"\"t\""},{"type":"html","content":"<span class='clj-string'>&quot;u&quot;</span>","value":"\"u\""},{"type":"html","content":"<span class='clj-string'>&quot;v&quot;</span>","value":"\"v\""},{"type":"html","content":"<span class='clj-string'>&quot;w&quot;</span>","value":"\"w\""},{"type":"html","content":"<span class='clj-string'>&quot;x&quot;</span>","value":"\"x\""},{"type":"html","content":"<span class='clj-string'>&quot;y&quot;</span>","value":"\"y\""}],"value":"(\"a\" \"b\" \"c\" \"d\" \"e\" \"f\" \"g\" \"h\" \"i\" \"j\" \"k\" \"l\" \"m\" \"n\" \"o\" \"p\" \"q\" \"r\" \"s\" \"t\" \"u\" \"v\" \"w\" \"x\" \"y\")"}
;; <=

;; @@
; The above does the job but it feels messy. We are iterating over the list twice. 
; Once to pass all the elements of (range 97 122) to char and again for str.
; Why not iterate just once?

(map #(str (char %)) (range 97 122))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;a&quot;</span>","value":"\"a\""},{"type":"html","content":"<span class='clj-string'>&quot;b&quot;</span>","value":"\"b\""},{"type":"html","content":"<span class='clj-string'>&quot;c&quot;</span>","value":"\"c\""},{"type":"html","content":"<span class='clj-string'>&quot;d&quot;</span>","value":"\"d\""},{"type":"html","content":"<span class='clj-string'>&quot;e&quot;</span>","value":"\"e\""},{"type":"html","content":"<span class='clj-string'>&quot;f&quot;</span>","value":"\"f\""},{"type":"html","content":"<span class='clj-string'>&quot;g&quot;</span>","value":"\"g\""},{"type":"html","content":"<span class='clj-string'>&quot;h&quot;</span>","value":"\"h\""},{"type":"html","content":"<span class='clj-string'>&quot;i&quot;</span>","value":"\"i\""},{"type":"html","content":"<span class='clj-string'>&quot;j&quot;</span>","value":"\"j\""},{"type":"html","content":"<span class='clj-string'>&quot;k&quot;</span>","value":"\"k\""},{"type":"html","content":"<span class='clj-string'>&quot;l&quot;</span>","value":"\"l\""},{"type":"html","content":"<span class='clj-string'>&quot;m&quot;</span>","value":"\"m\""},{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-string'>&quot;o&quot;</span>","value":"\"o\""},{"type":"html","content":"<span class='clj-string'>&quot;p&quot;</span>","value":"\"p\""},{"type":"html","content":"<span class='clj-string'>&quot;q&quot;</span>","value":"\"q\""},{"type":"html","content":"<span class='clj-string'>&quot;r&quot;</span>","value":"\"r\""},{"type":"html","content":"<span class='clj-string'>&quot;s&quot;</span>","value":"\"s\""},{"type":"html","content":"<span class='clj-string'>&quot;t&quot;</span>","value":"\"t\""},{"type":"html","content":"<span class='clj-string'>&quot;u&quot;</span>","value":"\"u\""},{"type":"html","content":"<span class='clj-string'>&quot;v&quot;</span>","value":"\"v\""},{"type":"html","content":"<span class='clj-string'>&quot;w&quot;</span>","value":"\"w\""},{"type":"html","content":"<span class='clj-string'>&quot;x&quot;</span>","value":"\"x\""},{"type":"html","content":"<span class='clj-string'>&quot;y&quot;</span>","value":"\"y\""}],"value":"(\"a\" \"b\" \"c\" \"d\" \"e\" \"f\" \"g\" \"h\" \"i\" \"j\" \"k\" \"l\" \"m\" \"n\" \"o\" \"p\" \"q\" \"r\" \"s\" \"t\" \"u\" \"v\" \"w\" \"x\" \"y\")"}
;; <=

;; @@
; So what just happened up there? What is this hash nonsense and why is there a percent sign?
; What we just saw was an anonymous function or "lambda" and they are what make programming in clojure pleasant!

; The "#" is a macro that declares whatever is within the following paranthesis to be a function.
; The "%" represents that anonymous function or lamba's input.
; Try to figure out what the mapping below will evaluate to before you evaluate it.

(map #(= % %) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}],"value":"(true true true true true true true true true true)"}
;; <=

;; @@
; Now try writing your own anonymous lambda using the "#" macro and "%" below!

;; @@

;; @@
; Try writing another one here!
;; @@

;; @@
; Okay now that you may have the hang of how basic mappings work. Let's quickly go over filter and reduce.

;; @@

;; @@
; Filter is a function that take a conditional function that returns true or false and a list or vector as arguments.
; Filter then returns everything in the list where the conditional function is true.

(filter even? (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"(0 2 4 6 8)"}
;; <=

;; @@
; Filter can also take an anonymous function as its first argument.

(filter #(= (mod % 2) 0) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"(0 2 4 6 8)"}
;; <=

;; @@
(filter #(= (mod % 2) 1) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"}],"value":"(1 3 5 7 9)"}
;; <=

;; @@
; Remove is exactly like filter except that it returns everything is the list where the conditional function is false.
(remove #(= (mod % 2) 0) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"}],"value":"(1 3 5 7 9)"}
;; <=

;; @@
(remove #(= (mod % 2) 1) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"(0 2 4 6 8)"}
;; <=

;; @@
; Reduce is a function that takes a function and a list as arguments and returns a single value.
; Here we can sum all numbers from 0 - 10 using reduce.
(reduce + (range 11))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>55</span>","value":"55"}
;; <=

;; @@
; Here we can use reduce to calculate the product of a series of numbers.
(reduce * (range 1 10))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>362880</span>","value":"362880"}
;; <=

;; @@
; Reduce works by taking the first two elements in a list 
(reduce #(* (+ %1 %1) %2) (range 2 5))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>96</span>","value":"96"}
;; <=

;; @@
; I hope this has been enough of a crash course for everyone.
; I strongly suggest checking out chapters 3 & 4 of
; "Clojure for the Brave and True"
; For a couple of great explanations of map and reduce with diagrams.

; Now I know I said that I would show you all how to write a multithreaded program in clojure so here it is!

(time (remove number? (doall (pmap #(reduce + %) (repeatedly 100000 #(vec (range 11)))))))
;; @@
;; ->
;;; &quot;Elapsed time: 272.72425 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[],"value":"()"}
;; <=

;; @@
; The above function is almost exactly the same as the function except for one letter.
; The letter "p" in pmap signifies that it is a parallel mapping function in clojure.
; All it takes to add a little parralelism in clojure to most of your code is the letter "p"!
; Below is the same function as above without the p. There are calls here that many of you may have not seen.

;(doall) forces eager evaluation.
; time is a macro the prints how long it takes a function to return.

(time (remove number? (doall (map #(reduce + %) (repeatedly 100000 #(vec (range 11)))))))
;; @@
;; ->
;;; &quot;Elapsed time: 76.508963 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[],"value":"()"}
;; <=

;; @@
; Now you may have noticed that the multithreaded pmap call took longer to return in this instance than the map call.
; Why is that? Shouldn't more threads be faster?

; More threads can be faster.
; However there is an initial overhead cost in segmenting parts of the list to be evaluated in different threads. 
; pmap should only be really used for titanic jobs on many cored computers.

; If you run into computational time problems that can not be solved with optimization remember that Hampshire has a cluster for Evo Comp.

; Just ask Lee if you can run your code on the cluster and make sure to use pmap to get the most out of one cluster node!
;; @@
