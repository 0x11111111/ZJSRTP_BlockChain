package cn.lpctstr.node.data;

import cn.lpctstr.node.data.util.ArrayMerkleTree;
import cn.lpctstr.node.data.wrapper.BlockNodeWrapper;
import cn.lpctstr.node.global.Logger.LogFactory;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 10:54 2019/8/6
 * @Project: ZJSRTP
 */
public class BlockChain {
    private ArrayMerkleTree tree;

    public BlockChain() {
        tree = new ArrayMerkleTree();
    }

    public void add(BlockNodeWrapper wrapper){
        tree.addLast(wrapper);
        LogFactory.GetLog(this).info(wrapper.toString());
    }
}

