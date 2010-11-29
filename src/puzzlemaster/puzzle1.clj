(ns projecteuler.puzzle1)
(require 'clojure.string)
(defn div? [n d]
  (zero? (mod n d)))
(defn map-num [n]
  (if(div? n 15) "Hop"
    (if(div? n 5) "Hophop"
      (if(div? n 3) "Hoppity"))))
(def n 
    (line-seq (java.io.BufferedReader. *in*)))
(println n)
;(println (apply str  
 ;          (interpose "\n" 
 ;            (filter (complement nil?) 
  ;             (map map-num (range n))))))


    

