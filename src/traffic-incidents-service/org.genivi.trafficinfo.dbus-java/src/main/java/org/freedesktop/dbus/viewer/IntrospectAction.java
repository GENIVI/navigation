/*
   D-Bus Java Viewer
   Copyright (c) 2006 Peter Cox

   This program is free software; you can redistribute it and/or modify it
   under the terms of either the GNU Lesser General Public License Version 2 or the
   Academic Free Licence Version 2.1.

   Full licence texts are included in the COPYING file with this program.
*/
package org.freedesktop.dbus.viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.StringReader;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.freedesktop.DBus.Introspectable;
import org.freedesktop.dbus.bin.CreateInterface;

@SuppressWarnings("serial")
final class IntrospectAction extends AbstractAction implements ListSelectionListener
{
	private final JTable table;

	IntrospectAction(JTable table)
	{
		super("Introspect");
		setEnabled(false);
		this.table = table;
		

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(this);
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	/** {@inheritDoc} */
	public void valueChanged(ListSelectionEvent e)
	{
		if (!e.getValueIsAdjusting())
		{
			DBusTableModel model = (DBusTableModel) table.getModel();
			int selection = table.getSelectedRow();
			if (selection > -1 && selection < model.getRowCount())
			{
				DBusEntry entry = model.getEntry(selection);
				final Introspectable introspectable = entry.getIntrospectable();
				setEnabled(introspectable != null);
			}
		}
	}			

	/** {@inheritDoc} */
	public void actionPerformed(ActionEvent e) 
	{
	
		int row = table.getSelectedRow();
		DBusTableModel model = (DBusTableModel) table.getModel();
		if (row > -1 && row < model.getRowCount())
		{
			DBusEntry entry = model.getEntry(row);
			final String xmlFile = entry.getName() + ".xml";
			final Introspectable introspectable = entry.getIntrospectable();
			new Thread(new Runnable()
			{
				public void run()
				{
					
					StringStreamFactory factory = new StringStreamFactory();
					CreateInterface createInterface = new CreateInterface(factory, false);
					try
					{
						String xml = introspectable.Introspect();
						
						String docType = "<!DOCTYPE node PUBLIC \"-//freedesktop//DTD D-BUS Object Introspection 1.0//EN\"\n\"http://www.freedesktop.org/standards/dbus/1.0/introspect.dtd\">";
	
						createInterface.createInterface(new StringReader(xml.replace(docType, "")));
						final JTabbedPane tabbedPane = new JTabbedPane();
						
						tabbedPane.addTab(xmlFile, createSourceTab(xmlFile, xml));
						
						for (String file : factory.streamMap.keySet())
						{
							final String source = factory.streamMap.get(file).toString();
							
							tabbedPane.addTab(file, createSourceTab(file, source));
						}
						tabbedPane.setPreferredSize(new Dimension(600, 400));
						
						final JPanel introspectionPanel = new JPanel(new BorderLayout());
						introspectionPanel.add(tabbedPane, BorderLayout.CENTER);

						JPanel southPanel = new JPanel();
						southPanel.add(new JButton(new SaveFileAction(tabbedPane)));
						southPanel.add(new JButton(new SaveAllAction(tabbedPane)));
						introspectionPanel.add(southPanel, BorderLayout.SOUTH);
						
						SwingUtilities.invokeLater(new Runnable()
						{
							@SuppressWarnings("synthetic-access")
							public void run()
							{
								JOptionPane.showMessageDialog(table, introspectionPanel, "Introspection", JOptionPane.PLAIN_MESSAGE);
							}
						});
						
					}
					catch (final Exception e)
					{
						e.printStackTrace();
						SwingUtilities.invokeLater(new Runnable()
						{
							@SuppressWarnings("synthetic-access")
							public void run()
							{
								JOptionPane.showMessageDialog(table, e.getMessage(), "Introspection Failed", JOptionPane.ERROR_MESSAGE);
							}
						});
					}
				}
	
				private JScrollPane createSourceTab(String file, final String source)
				{
					JTextArea area = new JTextArea(source);
					area.setLineWrap(true);
					area.setWrapStyleWord(true);
					return new JScrollPane(area, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				}
			}).start();
			
		}
	}
}
