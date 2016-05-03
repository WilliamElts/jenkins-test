# Java to use
export JAVA_HOME=/usr

# Main class name, must be set
export APP_MAIN_CLASS=com.bigsoft.mvn.jk.test.store.Store

# App name, will appear in jps
export APP_NAME=book-store

# Heap size
export APP_HEAPSIZE=1024

# Extra class path
# export APP_CLASSPATH=

# Extra runtime opt
export APP_OPTS="-XX:+UseConcMarkSweepGC"

# Log
export APP_ROOT_LOGGER=INFO,console

# Daemonize
export APP_PID_DIR=logs

# Set run mode
if [ -z $RUNMODE ]; then
    export RUNMODE="dev"
fi

