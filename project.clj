(defproject practicalli/notespace-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Creative Commons Attribution Share-Alike 4.0 International"
            :url  "https://creativecommons.org"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [scicloj/notespace "3-alpha2"]]
  :main ^:skip-aot practicalli.notespace-demo
  :target-path "target/%s"
  :profiles {:dev     {:resource-paths ["dev"]}
             :uberjar {:aot :all}})
