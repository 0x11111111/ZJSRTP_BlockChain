package cn.lpctstr.node.data.wrapper;

import cn.lpctstr.node.data.AbstractDataInfo;
import cn.lpctstr.node.data.model.Stud_Info;
import cn.lpctstr.node.data.util.ArrayMerkleTreeNode;
import cn.lpctstr.node.data.util.SHA256_Encoder;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 10:10 2019/8/6
 * @Project: ZJSRTP
 */
public class BlockNodeWrapper extends AbstractDataInfo implements ArrayMerkleTreeNode {
    private Stud_Info stud_info;
    private String localHash;

    @Override
    public String getlChildHash() {
        return lChildHash;
    }

    public void setlChildHash(String lChildHash) {
        this.lChildHash = lChildHash;
    }

    @Override
    public String getrChildHash() {
        return rChildHash;
    }

    @Override
    public String getGeneralHash() {
        return SHA256_Encoder.generateSHA256(localHash + lChildHash + rChildHash);
    }

    @Override
    public void setValue(Object o) {
        this.stud_info = (Stud_Info) o;
        updateLocalHash();
    }

    public void setrChildHash(String rChildHash) {
        this.rChildHash = rChildHash;
    }

    private String lChildHash;
    private String rChildHash;

    public BlockNodeWrapper(Stud_Info stud_info) {
        this.stud_info = stud_info;
        updateLocalHash();
        lChildHash = "null";
        rChildHash = "null";
    }

    @Override
    public String toString() {
        return stud_info.getName() + stud_info.getId() + stud_info.getCourseAbstract();
    }

    @Override
    public String getLocalHash() {
        return localHash;
    }

    public void updateLocalHash() {
        localHash = SHA256_Encoder.generateSHA256(this.toString());
    }

}
