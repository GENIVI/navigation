{
  'targets': [
    {
	'target_name': 'NavigationCoreConfigurationProxy',
      	'product_prefix': 'lib',
      	'type': 'shared_library',
      	'sources': [ './dbus-proxies/NavigationCoreConfigurationProxy.cpp' ],
	'include_dirs': ['./','/usr/include/dbus-c++-1/','/usr/include/glib-2.0/','/usr/lib/i386-linux-gnu/glib-2.0/include/'],
	'cflags_cc': ['-Wall', '-std=gnu++11', '-fexceptions'],
	'libraries': ['-ldbus-c++-1 -ldbus-1 -ldbus-c++-glib-1', '-L/usr/lib/i386-linux-gnu/']
    },
    {
      	'target_name': 'NavigationCoreConfigurationWrapper',
      	'dependencies': [ 'NavigationCoreConfigurationProxy' ],
      	'sources': [ './NavigationCoreConfigurationWrapper.cpp' ],
	'include_dirs': ['./','./dbus-proxies','/usr/include/dbus-c++-1/','/usr/include/glib-2.0/','/usr/lib/i386-linux-gnu/glib-2.0/include/'],
	'cflags_cc': ['-Wall', '-std=gnu++11', '-fexceptions'],
	'libraries': ['-ldbus-c++-1 -ldbus-1 -ldbus-c++-glib-1', '-L/usr/lib/i386-linux-gnu/']
    }
  ]
}
