	private void handleContextMenu(JTree tree, int x, int y) {
		TreePath path = tree.getPathForLocation(x, y);
		tree.setSelectionPath(path);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		if (node == null)
			return;
		if (!node.isLeaf()) {
			tree.setSelectionPath(null);
			return;
		}
		final AppInfo info = (AppInfo) node.getUserObject();

		JMenuItem copyname = new JMenuItem("Copy Name");
		copyname.addActionListener(e -> {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(info.app.getSimpleName()), null);
		});

		JMenuItem copypath = new JMenuItem("Copy Path");
		copypath.addActionListener(e -> {
			String path1 = UtilIO.getSourcePath(info.app.getPackage().getName(), info.app.getSimpleName());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(path1), null);
		});

		JMenuItem github = new JMenuItem("Go to Github");
		github.addActionListener(e -> openInGitHub(info));

		JPopupMenu submenu = new JPopupMenu();
		submenu.add(copyname);
		submenu.add(copypath);
		submenu.add(github);
		submenu.show(tree, x, y);
	}