(ns adventofcode.day_2)
(use ['clojure.string :only '(split)])

(defn dimensions
  "Get the sequence of directions"
  []
  (with-open [rdr (clojure.java.io/reader "resources/input_day_2.txt")]
    (doall (line-seq rdr))))

(defn split-dimension
  [dimension]
  (map (fn [n] (Integer. n)) (split dimension #"x")))

(defn split-dimensions
  []
  (map split-dimension (dimensions)))

(defn sorted-split-dimensions
  []
  (map sort (split-dimensions)))

(defn calculate-area
  [box]
  (let [w (nth box 0)
        h (nth box 1)
        l (nth box 2)]
    (+
      (* 2 l w)
      (* 2 w h)
      (* 2 h l))))

(defn calculate-slack
  [box]
  (let [a (nth box 0)
        b (nth box 1)]
    (* a b)))

(defn calculate-ribbon
  [box]
  (let [w (nth box 0)
        h (nth box 1)]
    (+ w w h h)))

(defn calculate-bow
  [box]
  (let [w (nth box 0)
        h (nth box 1)
        l (nth box 2)]
    (* w h l)))

(defn sum [vs]
  (reduce + vs))

(defn paper-required
  []
  (sum
    (map
      (fn [box] (+ (calculate-area box) (calculate-slack box)))
      (sorted-split-dimensions))))

(defn ribbon-required
  []
  (sum
    (map
      (fn [box] (+ (calculate-ribbon box) (calculate-bow box)))
      (sorted-split-dimensions))))
