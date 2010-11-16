(ns projecteuler.problem3)
(defn prime? [n] 
  (let [sq (Math/sqrt n)]
    (not-any? 
      #(zero? (mod n %)) 
      (range 2 (+ sq 1)))))
(defn large-prime [n] 
    (first 
      (drop-while (complement prime?) 
        (filter #(= (mod n %) 0) 
          (take n 
            (iterate dec n))))))

(def primes (list 2))
(defn is-prime? [n] 
  (do 
    (def isp 
      (not-any? #(zero? (mod n %))
        (filter #(<= (inc (Math/sqrt n)))
          primes)))
    (if isp 
      (def primes (conj primes n)))
    (isp)))
(println (is-prime? 11))
  

