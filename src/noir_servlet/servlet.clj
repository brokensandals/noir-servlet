(ns noir-servlet.servlet
  (:use noir.server
        ring.util.servlet)
  (:gen-class :extends javax.servlet.http.HttpServlet
              :state serviceImpl
              :init construct))

(defn -construct
  []
  [[] (atom nil)])

(defn- wrap-path-info
  "Wraps a handler so that :path-info and :context elements
   will be added, for the sake of Compojure."
  [handler]
  (fn [request]
    (handler
      (merge request
        {:path-info (-> request :servlet-request .getPathInfo)
         :context (-> request :servlet-context .getContextPath)}))))

(defn -init-void
  [servlet]
  (load-views-ns (-> servlet (.getInitParameter "views-ns") symbol))
  (reset! (.serviceImpl servlet)
    (-> (gen-handler :base-url (-> servlet .getServletContext .getContextPath)
                     :mode (-> "noir.mode" System/getProperty (or :prod) keyword))
        wrap-path-info
        make-service-method)))

(defn -service
  [servlet request response]
  (@(.serviceImpl servlet) servlet request response))
