(defproject noir-servlet "0.1.0"
  :description "An HttpServlet subclass that delegates to a Noir handler."
  :url "http://github.com/brokensandals/noir-servlet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[noir "1.3.0-beta7"]
                 [org.clojure/clojure "1.4.0"]]
  :aot [noir-servlet.servlet])
