(ns projecteuler.problem3)
(defn something? [n]
  (do (def y 10) (println y) (> y 11)))

(println (something? 1))
(def primes `(2))
(defn is-prime? [n]
  (do 
    (def isp 
      (not-any? #(zero? (mod n %))
        (filter #(<= % (inc (Math/sqrt n)))
          primes)))
    (if isp
      (def primes (cons n primes)))
    isp
    ))

(println (lazy-seq (for [i (range 2 100)] [i (is-prime? i)])))

