(ns projecteuler.puzzle1)
(defn div? [n d]
  (zero? (mod n d)))
(defn map-num [n]
  (if(div? n 15) "Hop"
    (if(div? n 5) "Hophop"
      (if(div? n 3) "Hoppity"))))
(println (apply str  
           (interpose "\n" 
             (filter (complement nil?) 
               (map map-num (range 10))))))


    

