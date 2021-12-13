#!/usr/bin/env bb

(require '[clojure.java.shell :refer [sh]])
(require '[clojure.string :as str])
(require '[clojure.tools.cli :refer [parse-opts]])
(require '[cheshire.core :as json])

(def cli-options
  [["-e" "--env ENV" "The deployment environment (dev master stg sbx)" :default "dev"]])

(let [{:keys [options]} (parse-opts *command-line-args* cli-options)
      env (:env options)
      {:keys [out]} (sh "aws" "cloudfront" "list-distributions")
      response (json/parse-string out true)
      distro-id (->> (get-in response [:DistributionList :Items])
                     (some (fn [distro]
                             (some
                              (fn [origin]
                                (when (str/starts-with? (:DomainName origin) env)
                                  (:Id distro)))
                              (get-in distro [:Origins :Items])))))]
  (println distro-id))
