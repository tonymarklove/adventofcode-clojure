(ns adventofcode.day_5)

(defn input-strings []
  (with-open [rdr (clojure.java.io/reader "resources/input_day_5.txt")]
    (doall (line-seq rdr))))

(defn contains-three-vowels? [input]
  (let [total (count(filter (fn [ch] (some (fn [c] (= ch c)) [\a \e \i \o \u])) (seq input)))]
    (>= total 3)))

(defn is-letter-pair? [pair]
  (let [[a b] pair]
    (= a b)))

(defn contains-letter-pairs? [input]
  (let [pairs (partition 2 1 (seq input))]
    (seq (filter is-letter-pair? pairs))))

(defn is-letter-nearby? [trio]
  (let [[a b c] trio]
    (= a c)))

(defn contains-nearby-letters? [input]
  (let [trios (partition 3 1 (seq input))]
    (seq (filter is-letter-nearby? trios))))

(defn contains-invalid-strings? [input]
  (some #(.contains input %) ["ab" "cd" "pq" "xy"]))

(def filter-nice-strings
  (comp
    (partial filter contains-letter-pairs?)
    (partial filter contains-three-vowels?)
    (partial remove contains-invalid-strings?)))

(def filter-nice-strings-2
  (comp
    (partial filter contains-nearby-letters?)
    (partial filter contains-three-vowels?)))

(defn nice-count []
  (count (filter-nice-strings (input-strings))))

(defn nice-count-2 []
  (count (filter-nice-strings-2 (input-strings))))
