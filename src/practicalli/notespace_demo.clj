(ns practicalli.notespace-demo
  (:require [notespace.api :as notespace]
            [notespace.kinds :as kind]))

;; Notespace
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Listen for changes in the namespace and update notespace automatically
^kind/hidden
(comment
  (notespace/listen)
  )


;; Notespace examples
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Full details at:
;; https://scicloj.github.io/notespace/doc/notespace/v3-experiment1-test/index.html


;; simple values

^kind/hiccup-nocode
[:h2 "Simple values"]

(rand)

[34388]

^kind/hiccup-nocode
[:h2 "Simple code"]

(defn simple
  [arg]
  (* arg 9))

(simple 11)


^kind/hiccup-nocode
[:h2 "Generative code"]


^kind/hiccup
[:div
 (->> (range 9)
      (map (fn [i] [:h1 i])
           (into [:div])))]


^kind/hiccup-nocode
[:h2 "Hidden evaluation"]

^kind/void
[:h1 "Hide my evaluation result. Am I even evaluated?"]



;; Inspect values with Portal
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

^kind/hiccup-nocode
[:div
 [:h2 "Inspect data with Portal"]
 [:p "Wrap values and code with tap> and evaluate to send to Portal"]]


^kind/hiccup-nocode
[:p "Weather forcast"]

(tap>
  (zipmap [:monday :tuesday :wednesday :thursday :friday :saturday :sunday]
          (range 10 20)))




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

  ;; Clear the Portal window
  (inspect/clear)

  ;; Close the Portal window
  (inspect/close)

  ;; Open Portal window with solarized-dark theme
  (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  ) ;; End of rich comment block
