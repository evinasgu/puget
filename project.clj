(defproject mvxcvi/puget "1.2.1-SNAPSHOT"
  :description "Colorizing canonical Clojure printer for EDN values."
  :url "https://github.com/greglook/puget"
  :license {:name "Public Domain"
            :url "http://unlicense.org/"}

  :deploy-branches ["master"]
  :pedantic? :abort

  :plugins
  [[lein-cloverage "1.1.2"]]

  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [org.clojure/clojurescript "1.10.520"]
   [lein-cljsbuild "1.1.7"]
   [mvxcvi/arrangement "1.2.0"]
   [fipp "0.6.21"]]

  :profiles {:dev {:plugins [[lein-difftest "2.0.0"]
                             [com.cemerick/clojurescript.test "0.3.3"]
                             [lein-cljsbuild "1.0.6"]]
                   :aliases {"cleantest" ["do" "clean," "once," "test," "cljsbuild" "test"]
                             "jar" ["do" "clean," "once," "jar"]
                             "deploy" ["do" "clean," "deploy" "clojars"]}}}
  :cljsbuild {:builds
              {:test {:source-paths ["target/classes" "target/test-classes"]
                      :compiler {:output-to "target/testable.js"
                                 :optimizations :simple
                                 :pretty-print true}}}
              :test-commands {"test" ["node" :node-runner "target/testable.js"]}}
  )

