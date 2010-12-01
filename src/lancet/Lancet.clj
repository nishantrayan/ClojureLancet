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
(defn instantiate-task [project name]
  (let [task (.createTask project name)]
    (doto task
      (.init)
      (.setProject project))))
(def echo-task (instantiate-task ant-project "echo"))
(.setMessage echo-task "hello")
(defn property-descriptor [inst prop-name]
  (first
    (filter #(= (name prop-name) (.getName %))
      (.getPropertyDescriptors
        (Introspector/getBeanInfo (class inst))))))
(.execute echo-task)