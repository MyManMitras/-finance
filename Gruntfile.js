/*global define, module, require */
module.exports = function (grunt) {
    'use strict';

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        path: {
            nginx: 'openresty'
        },
        clean: {
            openresty: ['openresty.zip'],
            nginxconfig: ['openresty/config*.zip'],
            restysession: ['restysession.zip'],
            nginxlocalconfig: ['openresty/conf/local/']
        },
        mkdir: {
            logs: {
                options: {
                    create: ['logs', 'openresty/logs']
                }
            }
        },
        curl: {
            'openresty': {
                src: {
                    url: 'http://openresty.org/download/openresty-1.9.7.4-win32.zip'
                },
                dest: 'openresty.zip'
            },
            'restysession': {
                src: {
                    url: 'https://github.com/bungle/lua-resty-session/archive/v2.7.zip'
                },
                dest: 'restysession.zip'
            }
        },
        unzip: {
            'openresty': {
                router: function (filepath) {
                    return filepath.substring(filepath.indexOf('/') + 1);
                },
                src: 'openresty.zip',
                dest: 'openresty'
            },
            'restysession': {
                router: function (filepath) {
                    if ((filepath.split('/').length - 1) > 1) {
                        return filepath.split('/').slice(2).join('/');
                    } else {
                        return null;
                    }
                },
                src: 'restysession.zip',
                dest: 'openresty/lualib'
            }
        },
        exec: {
            start_nginx: {
                cwd: 'openresty',
                command: 'nginx -c ../openresty/conf/app/nginx.conf -p ../openresty'
            },
            reload_nginx: {
                cwd: 'openresty',
                command: 'nginx -c ../openresty/conf/app/nginx.conf -p ../openresty -s reload'
            },
            stop_nginx: {
                cwd: 'openresty',
                command: 'nginx -c ../openresty/conf/app/nginx.conf -p ../openresty -s stop',
                stdout: false,
                stderr: false,
                exitCode: [0, 1]
            }
        }
    });

    grunt.loadNpmTasks('grunt-artifactory-artifact');
    grunt.loadNpmTasks('grunt-mkdir');
    grunt.loadNpmTasks('grunt-curl');
    grunt.loadNpmTasks('grunt-zip');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-exec');
    grunt.loadNpmTasks('grunt-subgrunt');

    grunt.registerTask('nginxconf:update', ['clean:nginxconfig']);
    grunt.registerTask('setup:openresty', ['mkdir:logs', 'curl:openresty', 'unzip:openresty', 'clean:openresty']);
    grunt.registerTask('setup:restysession', ['curl:restysession', 'unzip:restysession', 'clean:restysession']);
    grunt.registerTask('setup:web', ['subgrunt:web']);

    grunt.registerTask('setup', ['setup:openresty', 'nginxconf:update', 'setup:restysession']);

    grunt.registerTask('nginx:start', ['exec:start_nginx']);
    grunt.registerTask('nginx:stop', ['exec:stop_nginx']);
    grunt.registerTask('nginx:reload', ['exec:reload_nginx']);
};
