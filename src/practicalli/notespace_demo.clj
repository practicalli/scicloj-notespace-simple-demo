(ns practicalli.notespace-demo
  (:require [notespace.api :as notespace]
            [notespace.kinds :as kind]))

;; Notespace
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Listen for changes in the namespace and update notespace automatically
;; Hidden kinds should not show in the notespace page
^kind/hidden
(comment
  ;; Manually start an empty notespace - autostarted when using Clojure CLI
  ;; re-evaluate to start 
  (notespace/init-with-browser)

  (notespace/init)

  ;; Notespace listens to file changes
  (notespace/listen)
  )


;; Notespace examples
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Full details at:
;; https://scicloj.github.io/notespace/doc/notespace/v3-experiment1-test/index.html


;; Simple Content

["## Notes are the pieces of a notespace
A note is a top level form in the Clojure namespace"]

["Notespace renders each top level form and shows both the code of that form and the evaluation result"]

["There are many kinds of notes available, including static **markdown** content like these *introductory paragraphs*.  Code evaluation and results can be added as their own note or evaluated as part of hiccup style code.   Visualizations such as graphs and plots can be rendered using the [Vega graphics language](https://vega.github.io/vega/docs/specification/)"]



;; simple values

;; Plain HTML content - no code rendering
;; use keywords for html tags, scoped to the vector
^kind/hiccup-nocode
[:h2 "Simple values"]

;; A value evaluates to itself, not very useful
[34388]


^kind/hiccup-nocode
[:h2 "Evaluating expressions"]

["Top level forms will render showing code and a pretty printed result to make nested results easier to read for humans"]

(+ 1 2 3 4 5 6)

;; Top level forms can be explicitly tagged as naive
^kind/naive
(->> (partial rand-int 6)
     (partial repeatedly 6)
     (repeatedly 6))


^kind/hiccup-nocode
[:h2 "Defining and calling functions"]

;; Define a function and call it to see the results
(defn pie-me
  ""
  [number]
  (* number 3.14))

(pie-me 12)


^kind/hiccup-nocode
[:h2 "Generative code"]

;; Render Clojure code writen in the hiccup style
^kind/hiccup
[:div
 (->> (range 1 4)
      (map (fn [i] [:h1 i]))
      (into [:div]))]

(defn weather-forcast-mock
  "Generate mock weati"
  [temperature-min temperature-max]
  (zipmap [:monday :tuesday :wednesday :thursday :friday :saturday :sunday]
          (repeatedly #(rand-nth (range temperature-min temperature-max)))))

(weather-forcast-mock 20 30)

^kind/hidden
;; Send evaluation result to the connected data inspector, portal.
(tap>
  (weather-forcast-mock 20 30))

^kind/hiccup-nocode
[:h2 "Hidden evaluation"]

;; Show the code but not the result
^kind/void
[:h1 "Hide my evaluation result. Am I even evaluated?"]



^kind/hiccup-nocode
[:p "Weather forcast"]


;; Visualizations



^kind/hidden
(comment

  ;; Notespace helpers
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  ;; These function must be kept in a comment block
  ;; or they will disrupt the evaluation of the notespace

  (notespace/init)
  (notespace/init-with-browser)

  ;; Update the notespace with current namespace
  (notespace/eval-this-notespace)

  ;; Update the notespace with current line
  (notespace/eval-and-realize-note-at-line 26)

  ;; Generate static web page from current namespace
  (notespace/render-static-html "index.html")

  ;; Listen for changes in the namespace and update notespace automatically
  (notespace/listen)

  (notespace/check)

  ;; Portal helpers
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

  ;; Require portal library when using Leiningen
  (require '[portal.api :as inspect])

  ;; Open Portal window with solarized-dark theme
  (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  ;; Clear the Portal window
  (inspect/clear)

  ;; Close the Portal window
  (inspect/close)


  ;; Inspect values with Portal
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

  (tap>
    (zipmap [:monday :tuesday :wednesday :thursday :friday :saturday :sunday]
            (range 10 20)))

  ) ;; End of rich comment block
