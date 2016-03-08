project(socket-based-web-poc)
cmake_minimum_required(VERSION 2.8)
aux_source_directory(. SRC_LIST)
include_directories(
    ./
    /usr/include/nodejs/src/
)

add_executable(${PROJECT_NAME} ${SRC_LIST})
set(npm 'npm build .')
execute_process(
    COMMAND ${npm}
)
