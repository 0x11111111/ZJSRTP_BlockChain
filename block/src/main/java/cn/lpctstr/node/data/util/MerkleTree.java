package cn.lpctstr.node.data.util;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 17:58 2019/6/25
 * @Project: ZJSRTP
 */


import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    private List<TreeNode> buffer;

    public MerkleTree(List<String> src_data) {
        buffer = new ArrayList<>();
        int id = 0;
        for (String tmp : src_data) {
            buffer.add(new TreeNode(null, null, "Src_data:" + id, tmp));
            id++;
        }
        GenerateTree(buffer);
    }

    public boolean compare() {
        return true;
    }

    private void GenerateTree(List<TreeNode> src_data) {
        if (src_data.size() == 1) {
            root = src_data.get(0);
            return;
        }
        List<TreeNode> tmp = new ArrayList<>();
        int cur = 0;//Current pointer
        while (src_data.size() >= cur + 2) {
            TreeNode l = buffer.get(cur);
            TreeNode r = buffer.get(cur + 1);
            cur += 2;
            tmp.add(new TreeNode(l, r, SHA256_Encoder.generateSHA256(l.data + r.data)));
        }
        if (src_data.size() % 2 != 0)
            tmp.add(new TreeNode(buffer.get(cur), SHA256_Encoder.generateSHA256(buffer.get(cur).data)));
        buffer = tmp;
        GenerateTree(buffer);
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        String name;
        String hash;
        String data;

        public TreeNode(TreeNode left, TreeNode right, String name, String data) {
            this.left = left;
            this.right = right;
            this.name = name;
            this.data = data;
            hash = SHA256_Encoder.generateSHA256(data);
        }


        public TreeNode(TreeNode left, TreeNode right, String data) {
            this(left, right, "Default", data);
        }

        /**
         * 单节点
         *
         * @param left
         * @param data
         */
        public TreeNode(TreeNode left, String data) {
            this(left, null, data);
        }
    }
}