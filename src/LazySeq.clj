(ns LazySeq)
(defn whole-numbers [] (iterate inc 1))
(defn prime? [n] 
  (let [sq (Math/sqrt n)]
    (not-any? 
      #(zero? (mod n %)) 
      (range 2 (+ sq 1)))))
(println (prime? 15))