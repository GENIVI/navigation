/*
   D-Bus Java Viewer
   Copyright (c) 2006 Peter Cox

   This program is free software; you can redistribute it and/or modify it
   under the terms of either the GNU Lesser General Public License Version 2 or the
   Academic Free Licence Version 2.1.

   Full licence texts are included in the COPYING file with this program.
*/
package org.freedesktop.dbus.viewer;

import static org.freedesktop.dbus.Gettext._;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;

abstract class TabbedSaveAction extends AbstractAction implements Iterable<TextFile>
{
	/** File chooser component.
	 * Make static so that previous save location is stored
	 */
	private static JFileChooser chooser;
	protected final JTabbedPane tabbedPane;
	protected TabbedSaveAction(JTabbedPane tabbedPane)
	{
		super();
		this.tabbedPane = tabbedPane;
	}
	protected TabbedSaveAction(JTabbedPane tabbedPane, String name)
	{
		super(name);
		this.tabbedPane = tabbedPane;
	}
	
	/** Get the text file object associated with the supplied index
	 * @param index The tabbed pane index
	 * @return The text file object for the referenced tab
	 */
	protected TextFile getTextFile(int index)
	{
		JScrollPane scrollPane = (JScrollPane) tabbedPane.getComponentAt(index);
		JTextComponent textComponent = (JTextComponent) scrollPane.getViewport().getView();
		final String sourceCode = textComponent.getText();
		
		

		final String fileName = getFileName(index);
		

		TextFile textFile = new TextFile(fileName, sourceCode);
		return textFile;
	}
	
	
	/** Get the file name for the supplied index
	 * @param index The tabbed pane index
	 * @return The file name for the referenced tab
	 */
	protected String getFileName(int index)
	{
		return (index > -1) ? tabbedPane.getTitleAt(index) : "";
	}
	
	/** {@inheritDoc} */
	public final void actionPerformed(ActionEvent e)
	{
		
		if (chooser == null)
		{
			/** Occurs on event dispatch thread, so no problems with lazy static init here */
			chooser = new JFileChooser();
		}
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle(_("Select parent directory for saving"));
		
		int result = chooser.showDialog(tabbedPane, "Select");
		
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File parentDirectory = chooser.getSelectedFile();
			if (parentDirectory.exists() || parentDirectory.mkdirs())
			{
				if (parentDirectory.canWrite())
				{
					Runnable runnable = new FileSaver(tabbedPane, parentDirectory, this);
					
					new Thread(runnable).start();
				}
				else
				{
					JOptionPane.showMessageDialog(tabbedPane, _("Could not write to parent directory"), _("Invalid Parent Directory"), JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(tabbedPane, _("Could not access parent directory"), _("Invalid Parent Directory"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
