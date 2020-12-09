(defproject practicalli/notespace-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://practicalli.github.io/data-science/notebooks/notespace/"
  :license {:name "Creative Commons Attribution Share-Alike 4.0 International"
            :url  "https://creativecommons.org"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [scicloj/notespace "3-alpha3-SNAPSHOT"]]
  :main ^:skip-aot practicalli.notespace-demo
  :target-path "target/%s"
  :profiles {:dev     {:dependencies [[djblue/portal "0.6.4"]]}
             :uberjar {:aot :all}})
