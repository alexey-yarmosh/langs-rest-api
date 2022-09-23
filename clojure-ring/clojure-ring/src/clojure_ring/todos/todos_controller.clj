(ns clojure-ring.todos.todos-controller (:gen-class))

(require '[clojure-ring.todos.todos-service :as todos-service])

(defn todos-controller []
  [["/:id" {:get {:parameters {:path {:id int?}}
                  :responses  {200 {:body {:id int? :value string?}}}
                  :handler    (fn [{{:keys [id]} :path-params}]
                                {:status 200
                                 :body (todos-service/get-todos-by-id id)})}}]
   ["" {:get {:responses {200 {:body [{:id int? :value string?}]}}
              :handler (fn [_] {:status 200
                                :body (todos-service/get-all-todos)})}}]])
