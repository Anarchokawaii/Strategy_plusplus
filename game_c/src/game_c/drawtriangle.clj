(ns game-c.drawtriangle
  (:require [game-c.core :as core]))

(def gl (.getGL4 (.getGL core/window)))
(def tri [ [0.0 0.0] [0.5 0.0] [0.5 0.5] ])
(doto gl
  (.glCreateVertexArrays 1 tri)
)
