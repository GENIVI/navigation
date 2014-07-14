/*
   D-Bus Java Viewer
   Copyright (c) 2006 Peter Cox

   This program is free software; you can redistribute it and/or modify it
   under the terms of either the GNU Lesser General Public License Version 2 or the
   Academic Free Licence Version 2.1.

   Full licence texts are included in the COPYING file with this program.
*/
package org.freedesktop.dbus.viewer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.freedesktop.dbus.bin.CreateInterface.PrintStreamFactory;

/**
 * A factory using a byte array input stream
 * 
 * 
 * @author pete
 * @since 10/02/2006
 */
final class StringStreamFactory extends PrintStreamFactory
{
	Map<String, ByteArrayOutputStream> streamMap = new HashMap<String, ByteArrayOutputStream>();

	/** {@inheritDoc} */
	public void init(String file, String path)
	{

	}

	/** {@inheritDoc} */
	@SuppressWarnings("unused")
	public PrintStream createPrintStream(final String file) throws IOException
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		streamMap.put(file, stream);
		return new PrintStream(stream);

	}
}
