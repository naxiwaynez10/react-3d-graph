(ns ^{:figwheel-hooks true} hubble.core
  (:require
   [reagent.core :as reagent]
   [hubble.views :as views]
   [hubble.config :as config]
   [taoensso.timbre :as timbre]
   [re-frame.core :as re-frame])
  (:import goog.net.Cookies))

(def cookies (Cookies. js/document))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app"))
  (timbre/info "App version:" config/version))

(defn ^:after-load re-render
  "Re-render the app when figwheel reloads"
  []
  (mount-root))

(defn ^:export init []
  (dev-setup)
  (mount-root)
  (views/center)
  (views/write-to-atom))
