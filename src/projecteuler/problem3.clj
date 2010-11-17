(ns projecteuler.problem3)
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
(defn max-prime [n]
  (last
    (filter #(zero? (mod n %))
        (filter is-prime? 
          (range 2 (Math/sqrt n))))))

(def n (inc (int 
  (Math/sqrt 600851475143))))
(println n)
(def isprime (boolean-array n true))
(defn set-primes [prime n]
  (loop [m 2]
    (if (<= (* m prime) n)
      (do (aset isprime (* m prime) false)
      (recur  (inc m))))))
(def ans 2)
(defn find-prime [] 
  (loop [p 2]
    (if (< p n)
      (do
        (if (aget isprime p)
          (do (if (zero? (mod 600851475143 p)) (def ans p)) (println (str "Prime:" ans))
            (set-primes p n)))
        (recur (inc p))))))
    
(find-prime)
(println (ans)
      
    