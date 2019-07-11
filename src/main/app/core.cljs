(ns app.core
  (:require ["react-native" :as rn]
            [reagent.core :as r]
            [app.react-native :as react-native]))

(defonce logo-img (js/require "../assets/shadow-cljs.png"))

(defn root []
  [:> rn/View {:style {:flex 1
                       :backgroundColor "#fff"
                       :alignItems "center"
                       :justifyContent "center"}}
   [:> rn/Text {:style {:fontWeight "bold"
                        :fontSize 24
                        :color "blue"}}
    "Hello ReactNative!"]
   [:> rn/Image {:source logo-img
                 :style {:width 200
                         :height 200}}]])

(defn reload
  {:dev/after-load true}
  []
  (react-native/render-root "ShadowCljsReactNative" (reagent.core/as-element [root]))
  (prn "app reloaded"))

(defn init []
  (react-native/render-root "ShadowCljsReactNative" (reagent.core/as-element [root]))
  (prn "app initialized"))
