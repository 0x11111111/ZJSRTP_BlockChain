package cn.lpctstr.node.data.util;

import java.util.Arrays;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:22 2019/8/6
 * @Project: ZJSRTP
 */
public class ArrayMerkleTree {
    private ArrayMerkleTreeNode[] data;
    private static final int DefaultSize = 128;
    private static final int DefaultExpendLevel = 1;

    private int curr;

    public String getHash(){
        if(data[1]==null)
            return "Null";
        return data[1].getGeneralHash();
    }
    public ArrayMerkleTree(int size) {
        data = new ArrayMerkleTreeNode[size];
        curr = 1;
    }

    public ArrayMerkleTree() {
        this(DefaultSize);
    }

    public void addLast(ArrayMerkleTreeNode wrapper) {
        if (curr < data.length)
            extendSize();
        data[curr] = wrapper;
        updateDerivedPath(curr);
        curr++;
    }

    public void updateNode(int index,Object value){
        if(index>=curr)
            return ;
        data[index].setValue(value);
        updateDerivedPath(index);
    }

    private void updateDerivedPath(int index) {
        int parent = index / 2;
        int branch = index % 2;
        if (parent == 0)
            return;
        if (branch == 0)
            data[parent].setlChildHash(data[index].getGeneralHash());
        else
            data[parent].setrChildHash(data[index].getGeneralHash());
        updateDerivedPath(parent);
    }


    private void extendSize() {
        int originSize = data.length;
        data = Arrays.copyOf(data, originSize + (originSize >> DefaultExpendLevel));
    }
}
