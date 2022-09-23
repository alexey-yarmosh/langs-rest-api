(ns clojure-ring.todos.todos-service (:gen-class))

(require '[clojure-ring.todos.todos-repository :as todos-repository])

(defn get-todos-by-id [id] (first (filter (fn [todo] (= (:id todo) (Integer. id))) (todos-repository/read-todos))))

(defn get-all-todos [] (todos-repository/read-todos))
