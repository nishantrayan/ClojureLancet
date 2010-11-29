(ns projecteuler.problem1)
(defn x []
(for [i (range 1 1000)] (println i)))
(def anf (fn [x y] (+ x y)))
(println (anf 1 2))
(println (reduce (fn [x y] (+ x y)) (range 1 11)))

"actual solution"
(defn divides? [x y]
  (zero? (mod x y)))
(println (reduce  (fn [x y] (+ x y)) (filter #(or (divides? % 3)(divides? % 5)) (range 1 1000))))