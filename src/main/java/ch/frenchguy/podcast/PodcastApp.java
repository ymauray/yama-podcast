package ch.frenchguy.podcast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import ch.frenchguy.podcast.ui.AppFrame;
import ch.frenchguy.podcast.ui.WorkspaceButton;

@SpringBootApplication
public class PodcastApp implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(PodcastApp.class);

	public static void main(String[] args) {
		SpringApplication.run(PodcastApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.setProperty("java.awt.headless", Boolean.FALSE.toString());
		final JFrame mainFrame = new AppFrame();


		final JPanel panel = getMainPanel();
		mainFrame.setContentPane(panel);
		mainFrame.setPreferredSize(new Dimension(1024, 768));
		mainFrame.setLocation(100, 50);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.pack();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				LOGGER.info("Closing");
			}
		});
	}

	private JPanel getMainPanel() throws IOException {
		final JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		final JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		toolBar.setBackground(Color.WHITE);
		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.X_AXIS));
		toolBar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		toolBar.add(Box.createHorizontalGlue());
		final JButton button = new WorkspaceButton(new ImageIcon(new ClassPathResource("Bulleted_List-50.png").getURL()), "Shownotes");
		toolBar.add(button);
		toolBar.add(Box.createHorizontalStrut(8));
		final JButton button2 = new WorkspaceButton(new ImageIcon(new ClassPathResource("Music-50.png").getURL()), "Tracks");
		toolBar.add(button2);
		toolBar.add(Box.createHorizontalGlue());
		panel.add(toolBar, BorderLayout.NORTH);
		return panel;
	}
}
