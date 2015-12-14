(ns adventofcode.day_1)

(defn directions
  "Get the sequence of directions"
  []
  (seq (slurp "resources/input_day_1.txt")))

(defn what-floor
  "Entry point for day 1 question 1"
  []
  (let [downs (count
              (filter
                (fn [ch] (= ch \)))
                (directions)))
        ups (count
              (filter
                (fn [ch] (= ch \( ))
                (directions)))]
    (println (- ups downs))))

(defn find-basement
  [directions floor list-position]
  (let [move (first directions)]
    (if (< floor 0)
      list-position
      (if (= move \()
        (find-basement (rest directions) (+ floor 1) (+ list-position 1))
        (find-basement (rest directions) (- floor 1) (+ list-position 1))))))

(defn first-entry-to-basement
  "Entry point for day 1 question 2"
  []
  (println (find-basement (directions) 0 0)))
