class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private int module = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            calculateResultOf(node);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            calculateResultOf(leaf);
        }
    }

    private void calculateResultOf(Tree tree) {
        result = (result * tree.getValue()) % module;
    }
}

class FancyVisitor extends TreeVis {

    private int greenLeavesSum = 0;
    private int nonLeafEvenDepthSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if (isNonLeaf(node)) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }

    private boolean isNonLeaf(TreeNode node) {
        return node.getDepth() % 2 == 0;
    }
}

public class Solution {

    private static int [] values;
    private static Color [] colors;
    private static int nodesQuantity;
    private static Map<Integer, Set<Integer>> nodes;

    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        nodesQuantity = scanner.nextInt();

        saveNodeValues(scanner);
        saveNodeColors(scanner);
        saveEdges(scanner);
        scanner.close();

        createTreeLeaf();
        TreeNode root = createRoot();
        return root;
    }

    private static void saveNodeValues(Scanner input) {
        values = new int[nodesQuantity];
        for (int i = 0; i < nodesQuantity; i++) {
            values[i] = input.nextInt();
        }
    }

    private static void saveNodeColors(Scanner input) {
        colors = new Color[nodesQuantity];
        for (int i = 0; i < nodesQuantity; i++) {
            colors[i] = (input.nextInt() == 0) ? Color.RED : Color.GREEN;
        }
    }

    private static void saveEdges(Scanner input) {
        nodes = new HashMap<>(nodesQuantity);
        for (int i = 0; i < nodesQuantity - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();

            Set<Integer> uNeighbors = nodes.get(u);
            if (uNeighbors == null) {
                uNeighbors = new HashSet<>();
                nodes.put(u, uNeighbors);
            }
            uNeighbors.add(v);

            Set<Integer> vNeighbors = nodes.get(v);
            if (vNeighbors == null) {
                vNeighbors = new HashSet<>();
                nodes.put(v, vNeighbors);
            }
            vNeighbors.add(u);
        }
    }

    private static TreeNode createRoot() {
        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static TreeLeaf createTreeLeaf() {
        if (nodesQuantity == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }
        return null;
    }

    private static void addChildren(TreeNode parent, Integer parentNum) {
        for (Integer treeNum : nodes.get(parentNum)) {
            nodes.get(treeNum).remove(parentNum);

            Set<Integer> grandChildren = nodes.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if (childHasChild) {
                tree = new TreeNode(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
            } else {
                tree = new TreeLeaf(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
            }

            parent.addChild(tree);
            if (tree instanceof TreeNode) {
                addChildren((TreeNode) tree, treeNum);
            }
        }
    }
