(ns adventofcode.day_4)
(require 'digest)

(def puzzle-input "iwrupvqb")

(defn input-sequence []
  (map (fn [n] (str puzzle-input n)) (range)))

(defn input-md5s []
  (map (fn [input] {:num input, :md5 (digest/md5 input)}) (input-sequence)))

(defn md5-starts-with-zeros [input]
  (if (.startsWith (:md5 input) "000000")
    input
    false))

(defn five-zero-hash []
  (some md5-starts-with-zeros (input-md5s)))
