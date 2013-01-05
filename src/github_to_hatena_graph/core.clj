(ns github-to-hatena-graph.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as jio]
            [hatena.graph :as graph])
  (:gen-class))

(defn- props
  [n]
  (let [u (jio/resource n)]
    (with-open [r (jio/reader u)]
      (doto
        (java.util.Properties.)
        (.load r)))))

(defn- props->map
  [^java.util.Properties props]
  (let [names (enumeration-seq (.propertyNames props))
        pairs (map (juxt keyword #(.getProperty props %)) names)]
    (into {} pairs)))

(defn -main
  [& args]
  (let [p (props->map (props "my.properties"))]
    (binding [graph/*auth* p]
      (doseq [[date followers following public-repos public-gists] (csv/read-csv (slurp (p :filename)))]
        (graph/post-data "GitHub Followers" date followers)
        (graph/post-data "GitHub Following" date following)
        (graph/post-data "GitHub Public Repos" date public-repos)
        (graph/post-data "GitHub Public Gists" date public-gists)))))

