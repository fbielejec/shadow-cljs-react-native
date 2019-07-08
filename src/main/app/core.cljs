(ns app.core
  (:require ["react-native" :as rn]
            [reagent.core :as r]))

(def app-registry (.-AppRegistry rn))
(defonce logo-img (js/require "./assets/shadow-cljs.png"))

(defonce component-to-update (atom nil))

(defn root []
  [:> rn/View {:style {:flex 1
                       :backgroundColor "#fff"
                       :alignItems "center"
                       :justifyContent "center"}}
   [:> rn/Text {:style {:fontWeight "bold"
                        :fontSize 24
                        :color "blue"}} "Hello on iOS!"]
   [:> rn/Image {:source logo-img
                 :style {:width 200
                         :height 200}}]])

(def updatable-root
  (with-meta root
    {:component-did-mount
     (fn [] (this-as ^js this
              (reset! component-to-update this)))}))

(defn reload
  {:dev/after-load true}
  []
  (prn "app reloaded")
  (.forceUpdate ^js @component-to-update))

(defn init []
  (.registerComponent app-registry "react native demo" #(r/reactify-component updatable-root))
  (prn "app initialized"))
