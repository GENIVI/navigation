export WLD=$HOME/usrfs

export QTVER=qt5
export QTDIR=$WLD/$QTVER
export QT_PLUGIN_PATH=$QTDIR/lib/plugins

export PATH=$QTDIR/bin:$WLD/bin:$PATH

export LD_LIBRARY_PATH=$QTDIR/lib:$WLD/lib:/usr/lib/i386-linux-gnu

export PKG_CONFIG_PATH=$QTDIR/lib/pkgconfig:$WLD/lib/pkgconfig:$WLD/share/pkgconfig:/usr/lib/i386-linux-gnu/pkgconfig

export ACLOCAL_PATH=$WLD/share/aclocal
export ACLOCAL="aclocal -I $ACLOCAL_PATH"



