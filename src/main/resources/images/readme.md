// Create a ImageIcon
ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/myImage.png"));

// Use the ImageIcon in a JLabel, for example
JLabel label = new JLabel(icon);
