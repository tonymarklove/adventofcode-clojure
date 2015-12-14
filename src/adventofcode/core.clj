(ns adventofcode.core
  (:require [adventofcode.day_1 :as day_1])
  (:require [adventofcode.day_2 :as day_2])
  (:require [adventofcode.day_3 :as day_3]))

(defn -main
  "I don't do a whole lot."
  []
  (println (day_3/at-least-one-present-robo)))
