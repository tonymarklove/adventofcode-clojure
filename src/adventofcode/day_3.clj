(ns adventofcode.day_3)

(defrecord HouseLocation [x y])

(defn directions []
  (seq (slurp "resources/input_day_3.txt")))

(defn location-inc
  [location-map location]
  (update-in location-map [location] (fnil inc 0)))

(defn next-location
  [location direction]
  (case direction
    \^ (->HouseLocation (:x location) (inc (:y location)))
    \< (->HouseLocation (dec (:x location)) (:y location))
    \> (->HouseLocation (inc (:x location)) (:y location))
    \v (->HouseLocation (:x location) (dec (:y location)))))

(def start-location (->HouseLocation 0 0))
(def location-map (location-inc {} start-location))

(defn count-houses
  [location-map current-location directions]
  (if (empty? directions)
    location-map
    (let [new-location (next-location current-location (first directions))]
      (recur (location-inc location-map new-location) new-location (rest directions)))))

(defn at-least-one-present []
  (count (count-houses location-map start-location (directions))))

(defn at-least-one-present-robo []
  (count
    (merge-with +
      (count-houses location-map start-location (take-nth 2 (directions)))
      (count-houses location-map start-location (take-nth 2 (rest (directions))))
    )
  )
)
