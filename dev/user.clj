(ns user
  (:require [notespace.api :as notespace]))

(notespace/init-with-browser)


;; Rich comment block with redefined vars ignored
#_{:clj-kondo/ignore [:redefined-var]}
(comment

  ;; Generate a static web page from
  ;; can we specify the namespace as an argument?
  (notespace/render-static-html "index.html")

  ;; Initialise notespace, headless or open browser
  (notespace/init)
  (notespace/init-with-browser)

  ) ;; End of rich comment block
