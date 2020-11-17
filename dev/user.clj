(ns user
  (:require [notespace.api :as notespace]
            [portal.api :as inspect]))

;; Start Notespace
(notespace/init-with-browser)

;; Start Portal
;; Open a portal inspector window using default nord theme
(inspect/open {:portal.colors/theme :portal.colors/solarized-light})

;; Add portal as a tap> target
(inspect/tap)


(comment

  ;; Notespace helpers
  ;;;;;;;;;;;;;;;;;;;;;;

  ;; Initialise notespace, headless or open browser
  (notespace/init)
  (notespace/init-with-browser)


  ;; Portal helpers
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

  ;; Open Portal window with nord theme (default)
  (inspect/open)

  ;; Open Portal window with solarized-dark theme
  (inspect/open {:portal.colors/theme :portal.colors/solarized-dark})

  ;; Open Portal window with solarized-light theme
  (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  ;; Clear all values in the portal inspector window
  (inspect/clear)

  ;; Close the portal window
  (inspect/close)

  ) ;; End of rich comment block
