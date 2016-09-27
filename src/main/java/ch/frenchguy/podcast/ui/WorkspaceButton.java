package ch.frenchguy.podcast.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class WorkspaceButton extends JButton {

	private static final long serialVersionUID = -7629595366329387087L;

	private static final Color HIGHLIGHT_COLOR = Color.decode("#e1ecf4");

	public WorkspaceButton(Icon icon, String label) throws IOException {
		super(label);
		setBackground(Color.WHITE);
		setFocusPainted(false);
		setPreferredSize(new Dimension(96, 96));
		setMaximumSize(new Dimension(96, 96));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setIcon(icon);
		setIconTextGap(12);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(HIGHLIGHT_COLOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(Color.WHITE);
			}
		});
	}

}
