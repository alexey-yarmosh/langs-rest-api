(ns clojure-ring.core (:gen-class))

(require '[ring.adapter.jetty :as ring-jetty])
(require '[muuntaja.core :as m])
(require '[reitit.ring :as ring])
(require '[reitit.coercion.spec])
(require '[reitit.ring.coercion :as rrc])
(require '[reitit.ring.middleware.muuntaja :as muuntaja])
(require '[reitit.ring.middleware.parameters :as parameters])

(require '[clojure-ring.todos.todos-controller :as todos-controller])

(def app
  (ring/ring-handler
   (ring/router
    ["/todos" (todos-controller/todos-controller)]
    ;; router data affecting all routes
    {:data {:coercion   reitit.coercion.spec/coercion
            :muuntaja   m/instance
            :middleware [parameters/parameters-middleware
                         rrc/coerce-request-middleware
                         muuntaja/format-response-middleware
                         rrc/coerce-response-middleware]}})))

(defonce server (ring-jetty/run-jetty app {:port 3000 :join? false}))

(.start server)
