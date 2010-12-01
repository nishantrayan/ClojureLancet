(defn choose-gt[x,y] (if (> x y) x y))
(def map1 {:n1 1 :n2 2})
(def map2 {:n1 0 :n2 12})
(def merged (merge-with choose-gt map1 map2))
(println merged)
; key as function
(println (:n1 merged))
; map as function
(println (merged :n1))
; value not present
(println (merged :n3 100))