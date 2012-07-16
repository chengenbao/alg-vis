/*******************************************************************************
 * Copyright (c) 2012 Jakub Kováč, Katarína Kotrlová, Pavol Lukča, Viktor Tomkovič, Tatiana Tóthová
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package algvis.redblacktree;

import algvis.bst.BST;
import algvis.core.Node;
import algvis.gui.VisPanel;
import algvis.gui.view.Layout;
import algvis.gui.view.View;

public class RB extends BST {
	public static String dsName = "redblack";
	final RBNode NULL;
	public boolean mode24 = false;

	@Override
	public String getName() {
		return "redblack";
	}

	public RB(VisPanel M) {
		super(M);
		NULL = new RBNode(this, Node.NULL);
		NULL.setParent(NULL);
		NULL.setRight(NULL);
		NULL.setLeft(NULL);	
		NULL.setRed(false);
		NULL.size = NULL.height = NULL.sumh = 0;
		NULL.state = Node.INVISIBLE;
	}

	@Override
	public void insert(int x) {
		start(new RBInsert(this, x));
	}

	@Override
	public void find(int x) {
		start(new RBFind(this, x));
	}

	@Override
	public void delete(int x) {
		start(new RBDelete(this, x));
	}

	@Override
	public void draw(View V) {
		if (getRoot() != null) {
			getRoot().moveTree();
			((RBNode) getRoot()).drawRBTree(V);
		}
		if (getV() != null) {
			getV().move();
			getV().draw(V);
		}
	}

	@Override
	public Layout getLayout() {
		return Layout.COMPACT;
	}
}
