project(socket-based-web-poc)
cmake_minimum_required(VERSION 2.8)
aux_source_directory(. SRC_LIST)
include_directories(
    ./
    /usr/include/dbus-c++-1/
    /usr/include/nodejs/src/
    /usr/include/glib-2.0/
    /usr/lib/i386-linux-gnu/glib-2.0/include/
)

add_executable(${PROJECT_NAME} ${SRC_LIST})
set(npm 'npm build .')
execute_process(
    COMMAND ${npm}
)
