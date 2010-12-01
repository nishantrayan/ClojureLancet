(def student #{
  {:name "Nishant" :year 2}
  {:name "Rayan" :year 3}})

(def year #{
  {:year 1 :string "first year"}
  {:year 2 :string "second year"}})

;need to show Nishant : second year using join
(def query (clojure.set/project (clojure.set/join student year) [:name :string]))
(println query)
