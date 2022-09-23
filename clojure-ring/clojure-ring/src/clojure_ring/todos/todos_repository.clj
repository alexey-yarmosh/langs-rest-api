(ns clojure-ring.todos.todos-repository (:gen-class))

(require '[cheshire.core :as json])

(defn read-todos [] (get (json/parse-stream (clojure.java.io/reader "src/clojure_ring/todos/data.json") true) :todos))
