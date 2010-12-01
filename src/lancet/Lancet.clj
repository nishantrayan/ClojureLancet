(ns lancet.step-1-complete)
(import '(java.beans Introspector))
(def
  #^{:doc "Dummy ant project to keep Ant tasks happy"}
  ant-project
  (let [proj (org.apache.tools.ant.Project.)
        logger (org.apache.tools.ant.NoBannerLogger.)]
    (doto logger
      (.setMessageOutputLevel org.apache.tools.ant.Project/MSG_INFO)
      (.setOutputPrintStream System/out)
      (.setErrorPrintStream System/err))
    (doto proj
      (.init)
      (.addBuildListener logger))))
(defn property-descriptor [inst prop-name]
  (first
    (filter #(= (name prop-name) (.getName %))
      (.getPropertyDescriptors
        (Introspector/getBeanInfo (class inst))))))
(defn set-property! [inst prop value]
  (let [pd (property-descriptor inst prop)]
    (.invoke (.getWriteMethod pd) inst (into-array [value]))))
(defn set-properties! [inst values]
  (doseq [[k v] values] (set-property! inst k v)))
(defn instantiate-task [project name properties]
  (let [task (.createTask project name)]
    (set-properties! task properties)
    (doto task
      (.init)
      (.setProject project))))
(def echo-task (instantiate-task ant-project "echo" {:message "helloa"}))
;extending to support setting multiple properties
;before set-property
(.execute echo-task)
(set-property! echo-task :message "this was changed later using setProperty function")
;after set-property
(.execute echo-task)
;using set-properties!
(set-properties! echo-task {:message "this was set using set-properties"})
(.execute echo-task)