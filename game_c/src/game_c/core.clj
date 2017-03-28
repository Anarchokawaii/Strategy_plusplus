(ns game-c.core
 (:require [game-c.drawtriangle :as drawtri])
 (:import [com.jogamp.opengl 
             GL 
             GL2 
             GLAutoDrawable
             GLCapabilities
             GLEventListener
             GLProfile]
          [com.jogamp.newt.event
             WindowAdapter
             WindowEvent]
          [com.jogamp.newt.opengl
             GLWindow]
          [com.jogamp.opengl.util
             FPSAnimator])
 )
 
;implement event listener; implement methods sigs
 (deftype Program []
   GLEventListener
     (display [this drawable] (drawtri/drawtriangle))
     (init [this drawable] "init")
     (dispose [this drawable] "dispose")
     (reshape [this drawable x y width height] "reshape")
   )

;set up and start window methods/functions
 (def glp (GLProfile/getDefault))
 (def caps (GLCapabilities. glp))
 (def window (GLWindow/create caps))
 
 (def ani (FPSAnimator. window 60 true))
 
 (doto window
 ;(.addWindowListener (proxy [WindowAdapter][]
 ;                      (windowDestroyNotify [arg0]
 ;                        (.start (proxy [java.lang.Thread][]
 ;                                  (run []
 ;                                    (.stop ani)
 ;                                    (System/exit 0)))))))
 (.addGLEventListener (Program.))
 (.setSize 600 600)
 (.setTitle "CloGame")
 (.setVisible true)
 (.start ani)
 )

 
 
 