/*
   D-Bus Java Viewer
   Copyright (c) 2006 Peter Cox

   This program is free software; you can redistribute it and/or modify it
   under the terms of either the GNU Lesser General Public License Version 2 or the
   Academic Free Licence Version 2.1.

   Full licence texts are included in the COPYING file with this program.
*/
package org.freedesktop.dbus.viewer;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
class SaveAllAction extends TabbedSaveAction
{

	private class TabIterator implements Iterator<TextFile>
	{
		private int i = 0;
		/** {@inheritDoc} */
		public boolean hasNext()
		{
			return i < tabbedPane.getTabCount();
		}

		/** {@inheritDoc} */
		public TextFile next()
		{
			if (hasNext())
			{
				int currentIndex = i;
				i++;
				return getTextFile(currentIndex);
			}
			throw new NoSuchElementException();
		}

		/** {@inheritDoc} */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	protected SaveAllAction(JTabbedPane tabbedPane)
	{
		super(tabbedPane, "Save All...");
	}

	/** {@inheritDoc} */
	public Iterator<TextFile> iterator()
	{
		return new TabIterator();
	}
	
}
