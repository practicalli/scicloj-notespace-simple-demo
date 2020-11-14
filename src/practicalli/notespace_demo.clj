(ns practicalli.notespace-demo
  (:gen-class)
  (:require [notespace.api :as notespace]
            [notespace.kinds :as kind]))

(comment
  (notespace/init)
  (notespace/init-with-browser)

  ;; Update the notespace with current namespace
  (notespace/eval-this-notespace)

  (notespace/eval-and-realize-note-at-line 26)

  ;; Listen for changes in the namespace and update notespace automatically
  (notespace/listen)
  )

(comment
  ;;simple code
  (defn simple
    [arg]
    (* arg 9))

  (simple 11)
  ) ;; End of rich comment block


^kind/hiccup
[:div
 (->> (range 9)
      (map (fn [i] [:h1 i])
           (into [:div])))]


(rand)

[34388]



;; Rich comment block with redefined vars ignored
#_{:clj-kondo/ignore [:redefined-var]}
(comment
  (defn -main
    "I don't do a whole lot ... yet."
    [& args]
    (println "Hello, World!"))

  ) ;; End of rich comment block
