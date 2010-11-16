(ns projecteuler.problem2)
(defn fib-step [ab]
  [(last ab) (+ (first ab) (last ab))])
 (defn fib-seq []
  (map first (iterate fib-step [0 1])))
 
(println (reduce (fn [x y] (+ x y)) 
           (take-while #(< % 4000000) (filter even? (fib-seq)))))



